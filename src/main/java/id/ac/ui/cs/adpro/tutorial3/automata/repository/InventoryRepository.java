package id.ac.ui.cs.adpro.tutorial3.automata.repository;

import java.util.List;

public interface InventoryRepository {

    List<String> fetchInventory();

    String getItem();

    void addItem(String item);
}
