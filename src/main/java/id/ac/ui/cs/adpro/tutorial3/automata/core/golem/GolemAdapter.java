package id.ac.ui.cs.adpro.tutorial3.automata.core.golem;

import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid;
import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Punchable;

import java.util.List;

public class GolemAdapter implements Droid {

    private Golem golem;
    private String savedItem;

    public GolemAdapter(Golem golem) {
        this.golem = golem;
    }

    public void setItem(String item) {
        this.savedItem = item;
    }

    @Override
    public String liftItem(String item) {
        return this.golem.liftItem(item);
    }

    @Override
    public String countItem(List<String> inventory, String item) {
        int count = 0;
        // Generate list of comparisons done by Golem
        StringBuilder res = new StringBuilder();
        for (String itemInInventory : inventory) {
            String comparison = String.format("%s\n", golem.isItem(itemInInventory, item));
            res.append(comparison);
            if (!comparison.contains("not")) {
                count++;
            }
        }
        res.append(String.format("Counted %d %s", count, item));
        return res.toString();
    }

    @Override
    public String useTransporter() {
        return this.golem.toss(this.savedItem);
    }

    @Override
    public String useCrane() {
        return this.golem.punch(Punchable.CraneLever);
    }

    @Override
    public String getName() {
        return this.golem.getName();
    }

    @Override
    public String getType() {
        return "Golem";
    }
}
