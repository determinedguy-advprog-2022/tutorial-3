package id.ac.ui.cs.adpro.tutorial3.automata.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryRepositoryImpl implements InventoryRepository {

    private List<String> inventory = new ArrayList<>();
    private int indexCounter = 0;

    @Override
    public List<String> fetchInventory() {
        return inventory;
    }

    @Override
    public String getItem() {
        // Get item based on indexCounter
        String item = inventory.get(this.indexCounter++);
        // Reset indexCounter if it's overflow
        if (indexCounter > inventory.size() - 1) {
            indexCounter = 0;
        }
        return item;
    }

    @Override
    public void addItem(String item) {
        inventory.add(item);
    }
}
