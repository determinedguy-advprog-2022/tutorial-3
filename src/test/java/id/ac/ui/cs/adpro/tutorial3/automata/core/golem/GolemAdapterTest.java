package id.ac.ui.cs.adpro.tutorial3.automata.core.golem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GolemAdapterTest {

    private Class<?> golemAdapterClass;
    private GolemAdapter golemAdapter;

    @BeforeEach
    public void setUp() throws Exception {
        golemAdapterClass = Class.forName("id.ac.ui.cs.adpro.tutorial3.automata.core.golem.GolemAdapter");
        golemAdapter = new GolemAdapter(new IronGolem("Stoneman"));
    }

    @Test
    public void testGolemAdapterIsADroid() {
        Collection<Type> interfaces = Arrays.asList(golemAdapterClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid")));
    }

    @Test
    public void testLiftItemIsCorrectlyImplemented() {
        String result = golemAdapter.liftItem("box");
        assertEquals("Carefully lifting box", result);
    }

    @Test
    public void testCountItemIsCorrectlyImplemented() {
        List<String> items = new ArrayList<>();
        items.add("Homa");
        items.add("Box");
        items.add("Homa");
        items.add("Box");
        items.add("Box");
        String result = golemAdapter.countItem(items, "Homa");
        List<String> expectedList = Arrays.asList("item Homa is Homa", "item Box is not Homa", "item Homa is Homa",
                "item Box is not Homa", "item Box is not Homa", "Counted 2 Homa");
        String expected = String.join("\n", expectedList);
        assertEquals(expected, result);
    }

    @Test
    public void testUseCraneIsCorrectlyImplemented() {
        String result = golemAdapter.useCrane();
        assertEquals("Punching CraneLever", result);
    }

    @Test
    public void testUseTransporterIsCorrectlyImplemented() {
        // Make Box as the tossed item
        golemAdapter.setItem("Box");
        String result = golemAdapter.useTransporter();
        assertEquals("Tossing Box with one hand", result);
    }

    @Test
    public void testGetNameIsCorrectlyImplemented() {
        String result = golemAdapter.getName();
        assertEquals("Stoneman", result);
    }

    @Test
    public void testGetTypeIsCorrectlyImplemented() {
        String result = golemAdapter.getType();
        assertEquals("Golem", result);
    }
}
