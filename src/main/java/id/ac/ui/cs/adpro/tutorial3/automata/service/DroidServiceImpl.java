package id.ac.ui.cs.adpro.tutorial3.automata.service;

import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid;

import java.util.ArrayList;
import java.util.List;

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
        List<Droid> droids = droidRepository.findAll();
        // TODO: Add Fluids and Golems, too!
        return droids;
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
        // TODO: Complete this method
    }

    /**
     * Rekam sebuah Log dengan format: "<Nama droid>: <Aksi droid>"
     *
     * @param droid  Droid yang melakukan aksi
     * @param action Aksi yang dilakukan droid
     */
    protected void recordLog(Droid droid, String action) {
        // TODO: Complete this method
    }
}
