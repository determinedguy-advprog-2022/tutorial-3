package id.ac.ui.cs.adpro.tutorial3.automata.core.fluids;

import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid;
import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Direction;
import id.ac.ui.cs.adpro.tutorial3.automata.core.util.Shape;

import java.util.List;

public class FluidsAdapter implements Droid {

    private Fluids fluids;

    public FluidsAdapter(Fluids fluids) {
        this.fluids = fluids;
    }

    @Override
    public String liftItem(String item) {
        return this.fluids.pushItem(item, Direction.Up);
    }

    @Override
    public String countItem(List<String> inventory, String item) {
        String countBinary = fluids.splitBy(inventory, item);
        int decimal = Integer.parseInt(countBinary, 2);
        return String.format("Counted %d %s\n", decimal, item);
    }

    @Override
    public String useTransporter() {
        return fluids.shapeShift(Shape.Transporter);
    }

    @Override
    public String useCrane() {
        return fluids.shapeShift(Shape.Crane);
    }

    @Override
    public String getName() {
        return this.fluids.getName();
    }

    @Override
    public String getType() {
        return "Fluids";
    }
}
