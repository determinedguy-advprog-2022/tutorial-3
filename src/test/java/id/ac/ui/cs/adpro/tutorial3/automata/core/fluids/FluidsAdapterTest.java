package id.ac.ui.cs.adpro.tutorial3.automata.core.fluids;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FluidsAdapterTest {

    private Class<?> fluidsAdapterClass;
    private FluidsAdapter fluidsAdapter;

    @BeforeEach
    public void setUp() throws Exception {
        fluidsAdapterClass = Class.forName("id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.FluidsAdapter");
        fluidsAdapter = new FluidsAdapter(new Symbiote("Venom"));
    }

    @Test
    public void testFluidsAdapterIsADroid() {
        Collection<Type> interfaces = Arrays.asList(fluidsAdapterClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid")));
    }

    @Test
    public void testLiftItemIsCorrectlyImplemented() {
        String result = fluidsAdapter.liftItem("box");
        assertEquals("Pushing box Up", result);
    }

    @Test
    public void testCountItemCorrectlyImplemented() {
        List<String> items = new ArrayList<>();
        items.add("Homa");
        items.add("Box");
        items.add("Homa");
        items.add("Box");
        items.add("Box");
        String result = fluidsAdapter.countItem(items, "Box");
        assertEquals("Counted 3 Box", result);
    }

    @Test
    public void testMergeIsCorrectlyImplemented() {
        String result = fluidsAdapter.merge();
        assertEquals("Collecting bodies", result);
    }

    @Test
    public void testUseCraneIsCorrectlyImplemented() {
        String result = fluidsAdapter.useCrane();
        assertEquals("Changed shape into Crane", result);
    }

    @Test
    public void testUseTransporterIsCorrectlyImplemented() {
        String result = fluidsAdapter.useTransporter();
        assertEquals("Changed shape into Transporter", result);
    }

    @Test
    public void testUseTransporterAfterSplitByIsFailCorrectlyImplemented() {
        List<String> items = new ArrayList<>();
        items.add("Homa");
        items.add("Box");
        items.add("Homa");
        items.add("Box");
        items.add("Box");
        String result1 = fluidsAdapter.countItem(items, "Homa");
        assertEquals("Counted 2 Homa", result1);
        String result2 = fluidsAdapter.useTransporter();
        assertEquals("Not enough body to change shape", result2);
    }

    @Test
    public void testGetNameIsCorrectlyImplemented() {
        String result = fluidsAdapter.getName();
        assertEquals("Venom", result);
    }

    @Test
    public void testGetTypeIsCorrectlyImplemented() {
        String result = fluidsAdapter.getType();
        assertEquals("Fluids", result);
    }
}
