package id.ac.ui.cs.adpro.tutorial3.automata.core.golem;

import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Punchable;
import java.util.List;

/*
    DO NOT TOUCH
*/
public class SnowGolem implements Golem {

    private String name;

    public SnowGolem(String name) {
        this.name = name;
    }

    @Override
    public String liftItem(String item) {
        return "Lifting " + item + " with two hands";
    }

    @Override
    public String isItem(String item1, String item2) {
        String ret;
        if (item1.equals(item2)) {
            ret = String.format("item %s is %s", item1, item2);
        } else {
            ret = String.format("item %s is not %s", item1, item2);
        }
        return ret;
    }

    @Override
    public String punch(Punchable punchable) {
        return "Punching " + punchable;
    }

    @Override
    public String toss(String item) {
        return String.format("Tossing %s with two hand", item);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
