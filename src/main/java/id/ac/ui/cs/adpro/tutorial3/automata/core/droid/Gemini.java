package id.ac.ui.cs.adpro.tutorial3.automata.core.droid;

import java.util.List;

public class Gemini extends DroidImpl implements Droid {
    private String name;

    public Gemini(String name) {
        this.name = name;
    }

    @Override
    public String liftItem(String item) {
        return "Lifting item";
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
        return "Using transporter";
    }

    @Override
    public String useCrane() {
        return "Using crane";
    }

    @Override
    public String getName() {
        return this.name;
    }

}
