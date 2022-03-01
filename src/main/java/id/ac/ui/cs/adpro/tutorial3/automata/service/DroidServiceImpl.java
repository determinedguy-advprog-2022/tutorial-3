package id.ac.ui.cs.adpro.tutorial3.automata.service;

import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DroidServiceImpl implements DroidService {

    /**
     * Mengambil seluruh droid yang tersimpan.
     * Note: Termasuk seluruh automata pengganti droid.
     *
     * @return List automata
     */
    @Override
    public List<Droid> fetchDroids() {
        // TODO: Complete this method
        return null;
    }

    /**
     * Mengambil seluruh rekaman inventory yang tersimpan.
     *
     * @return List rekaman inventory
     */
    @Override
    public List<String> fetchInventories() {
        // TODO: Complete this method
        return null;
    }

    /**
     * Menambahkan sebuah benda ke dalam inventory.
     *
     * @param item benda untuk ditambah
     */
    @Override
    public void addInventory(String item) {
        // TODO: Complete this method
    }

    /**
     * Mengambil seluruh rekaman log yang tersimpan.
     *
     * @return List rekaman log
     */
    @Override
    public List<String> fetchLogs() {
        // TODO: Complete this method
        return null;
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
