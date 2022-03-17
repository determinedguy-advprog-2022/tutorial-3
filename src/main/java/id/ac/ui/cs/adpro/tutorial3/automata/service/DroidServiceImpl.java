package id.ac.ui.cs.adpro.tutorial3.automata.service;

import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Fluids;
import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.FluidsAdapter;
import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.Golem;
import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.GolemAdapter;
import id.ac.ui.cs.adpro.tutorial3.automata.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroidServiceImpl implements DroidService {
    List<Droid> units = new ArrayList<>();

    @Autowired
    private DroidRepository droidRepository;

    @Autowired
    private FluidsRepository fluidsRepository;

    @Autowired
    private GolemRepository golemRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private LoggerRepository loggerRepository;

    /**
     * Mengambil seluruh droid yang tersimpan.
     * Note: Termasuk seluruh automata pengganti droid.
     *
     * @return List automata
     */
    @Override
    public List<Droid> fetchDroids() {
        // Loop Fluids and Golem (which has to be adapted first) to be added to droidRepository
        for (Fluids fluids : fluidsRepository.findAll()) {
            droidRepository.add(new FluidsAdapter(fluids));
        }
        for (Golem golem : golemRepository.findAll()) {
            droidRepository.add(new GolemAdapter(golem));
        }
        // Add droids to the list
        this.units = droidRepository.findAll();
        return units;
    }

    /**
     * Mengambil seluruh rekaman inventory yang tersimpan.
     *
     * @return List rekaman inventory
     */
    @Override
    public List<String> fetchInventories() {
        List<String> inventories = inventoryRepository.fetchInventory();
        return inventories;
    }

    /**
     * Menambahkan sebuah benda ke dalam inventory.
     *
     * @param item benda untuk ditambah
     */
    @Override
    public void addInventory(String item) {
        inventoryRepository.addItem(item);
    }

    /**
     * Mengambil seluruh rekaman log yang tersimpan.
     *
     * @return List rekaman log
     */
    @Override
    public List<String> fetchLogs() {
        List<String> logs = loggerRepository.getLogs();
        return logs;
    }

    /**
     * Memanggil droid untuk melakukan sebuah rutinitas.
     *
     * @param droidName droid yang ingin dipanggil
     * @param routine   rutinitas yang akan dilakukan droid
     */
    @Override
    public void doRoutine(String droidName, int routine) {
        Droid droid = null;
        for (Droid loopDroid : units) {
            if (loopDroid.getName().equals(droidName)) {
                droid = loopDroid;
            }
        }
        // If the Droid is found inside unit list
        if (droid != null) {
            String log = "";
            switch (routine) {
                case 0:
                    log = droid.liftItem(inventoryRepository.getItem());
                    recordLog(droid, log);
                    break;
                case 1:
                    log = droid.countItem(fetchInventories(), inventoryRepository.getItem());
                    recordLog(droid, log);
                    // Fluids need to be merged if it's split before
                    if (droid.getType().equals("Fluids")) {
                        String newLog = ((FluidsAdapter) droid).merge();
                        recordLog(droid, newLog);
                    }
                    break;
                case 2:
                    if (droid.getType().equals("Golem")) {
                        ((GolemAdapter) droid).setItem(inventoryRepository.getItem());
                    }
                    log = droid.useTransporter();
                    recordLog(droid, log);
                    break;
                case 3:
                    log = droid.useCrane();
                    recordLog(droid, log);
                    break;
            }
        }
    }

    /**
     * Rekam sebuah Log dengan format: "<Nama droid>: <Aksi droid>"
     *
     * @param droid  Droid yang melakukan aksi
     * @param action Aksi yang dilakukan droid
     */
    protected void recordLog(Droid droid, String action) {
        String record = String.format("%s: %s", droid.getName(), action);
        loggerRepository.addRecord(record);
    }
}
