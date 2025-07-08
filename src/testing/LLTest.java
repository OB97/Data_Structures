package testing;
import structures.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.Node;

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
        list.add(list,"apple");
        list.add(list, "banana");
        list.add(list, "cherry");
        assertFalse(list.isEmpty(), "List should not be empty after adding elements");
        assertEquals(3, list.size(), "Size should reflect number of added elements");
    }

    @Test
    public void testGet() {
        list.add(list, "one");
        list.add(list, "two");
        list.add(list, "three");
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("three", list.get(2));
    }

    @Test
    public void testRemove() {
        list.add(list, "x");
        list.add(list, "y");
        list.add(list,"z");
        Node<String> removed = list.remove(1);
        assertEquals("y", removed.getData());
        assertEquals(2, list.size());
        assertEquals("x", list.get(0));
        assertEquals("z", list.get(1));
    }

    @Test
    public void testClear() {
        list.add(list, "a");
        list.add(list, "b");
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testContains() {
        list.add(list, "cat");
        list.add(list, "dog");
        assertTrue(list.contains("dog"));
        assertFalse(list.contains("lion"));
    }

    @Test
    public void testToStringFormat() {
        list.add(list, "1");
        list.add(list, "2");
        list.add(list, "3");
        String expected = "[Node1 Data=1, Node2 Data=2, Node3 Data=3]";
        assertEquals(expected, list.toString());
    }

    @Test
    public void testIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        list.add(list, "first");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(2));
    }

    @Test
    public void insertHead() {
        list.insertHead("apple");
        assertEquals("apple", list.get(0), "Head should be equal to apple");
        list.insertHead("banana");
        assertEquals("banana", list.get(0), "Head should be equal to banana");
        list.insertHead("cherry");
        assertEquals("cherry", list.get(0), "Head should be equal to cherry");
        assertFalse(list.isEmpty(), "List should not be empty after adding elements");
        assertEquals(3, list.size(), "Size should reflect number of added elements");
    }
}
