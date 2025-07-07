package testing;
import structures.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// CS-2920
// Unit test for Linked List ADT

public class LLTest {

    private LinkedList<String> list;

    @BeforeEach
    public void setUp() {
        list = new LinkedList<>();
    }

    @Test
    public void testIsEmptyInitially() {
        assertTrue(list.isEmpty(), "List should be empty initially");
        assertEquals(0, list.size(), "Size should be 0 initially");
    }

    @Test
    public void testAddAndSize() {
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        assertFalse(list.isEmpty(), "List should not be empty after adding elements");
        assertEquals(3, list.size(), "Size should reflect number of added elements");
    }

    @Test
    public void testGet() {
        list.add("one");
        list.add("two");
        list.add("three");
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("three", list.get(2));
    }

    @Test
    public void testRemove() {
        list.add("x");
        list.add("y");
        list.add("z");
        String removed = list.remove(1);
        assertEquals("y", removed);
        assertEquals(2, list.size());
        assertEquals("x", list.get(0));
        assertEquals("z", list.get(1));
    }

    @Test
    public void testClear() {
        list.add("a");
        list.add("b");
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testContains() {
        list.add("cat");
        list.add("dog");
        assertTrue(list.contains("dog"));
        assertFalse(list.contains("lion"));
    }

    @Test
    public void testToStringFormat() {
        list.add("1");
        list.add("2");
        list.add("3");
        String expected = "[1, 2, 3]"; // Adjust this if your format differs
        assertEquals(expected, list.toString());
    }

    @Test
    public void testIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        list.add("first");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(2));
    }
}
}
