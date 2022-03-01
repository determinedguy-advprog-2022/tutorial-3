package id.ac.ui.cs.adpro.tutorial3.automata.core.droid;

import java.util.List;

public class R2 extends DroidImpl implements Droid {

    public R2(String name) {
        // TODO: Complete this method
    }

    @Override
    public String liftItem(String item) {
        return "Lifting " + item + " using sockets";
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
        return ""; // TODO: Make this String meaningful
    }

    @Override
    public String useTransporter() {
        return ""; // TODO: Make this String meaningful
    }

    @Override
    public String useCrane() {
        return ""; // TODO: Make this String meaningful
    }

    @Override
    public String getName() {
        return ""; // TODO: Make this String meaningful
    }

}
