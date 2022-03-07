package id.ac.ui.cs.adpro.tutorial3.automata.core.droid;

import java.util.List;

public class T800 extends DroidImpl implements Droid {
    private String name;

    public T800(String name) {
        this.name = name;
    }

    @Override
    public String liftItem(String item) {
        return "Lifting " + item + " using mechanical arms";
    }

    /**
     * Count numbers of wanted items inside inventory.
     *
     * @param inventory collection of items
     * @param wanted    item to count
     * @return String that describes the count result.
     */
    @Override
    public String countItem(List<String> inventory, String wanted) {
        int count = 0;
        for (String item : inventory) {
            if (item.equals(wanted)) count++;
        }
        return String.format("Counted %d %s\n", count, wanted);
    }

    @Override
    public String useTransporter() {
        return "Using any available transporter";
    }

    @Override
    public String useCrane() {
        return "Using any available crane";
    }

    @Override
    public String getName() {
        return this.name;
    }

}
