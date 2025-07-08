package testing;
import structures.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// CS-2920
// Unit test for Queue ADT

public class QueueTest {
    private Queue<String> queue;

    @BeforeEach
    public void setUp() {
        queue = new Queue<>();
    }

    // Add values to queue and check toString()
    @Test
    public void testAdd() {
        assertNull(queue.peek(queue));
        queue.add(queue, "1");
        queue.add(queue, "3");
        queue.add(queue, "2");
        queue.add(queue, "4");
        queue.add(queue, "5");
        assertEquals("[Node1 Data=1, Node2 Data=3, Node3 Data=2, Node4 Data=4, Node5 Data=5]", queue.toString(), "Queue toString does not match output.");
    }

    // Remove values from queue
    @Test
    public void testRemove() {
        assertNull(queue.peek(queue));
        queue.add(queue, "1");
        queue.add(queue, "2");
        queue.add(queue, "3");
        assertEquals("1", queue.remove(queue).getData(), "Removed value is incorrect.");
        assertEquals("2", queue.remove(queue).getData(), "Removed value is incorrect.");
        assertEquals("3", queue.remove(queue).getData(), "Removed value is incorrect.");
    }

    // Peek at values from queue
    @Test
    public void testPeek() {
        queue.add(queue, "1");
        assertEquals("1", queue.peek(queue).getData(), "Peeked value is incorrect.");
        queue.remove(queue);
        queue.add(queue, "2");
        assertEquals("2", queue.peek(queue).getData(), "Peeked value is incorrect.");
        queue.remove(queue);
        queue.add(queue, "3");
        assertEquals("3", queue.peek(queue).getData(), "Peeked value is incorrect.");
        queue.remove(queue);

        assertNull(queue.peek(queue));

        queue.add(queue, "1");
        queue.add(queue, "2");
        queue.add(queue, "3");
        assertEquals("1", queue.peek(queue).getData(), "Peeked value is incorrect.");
        queue.remove(queue);
        assertEquals("2", queue.peek(queue).getData(), "Peeked value is incorrect.");
        queue.remove(queue);
        assertEquals("3", queue.peek(queue).getData(), "Peeked value is incorrect.");

    }

    // Test 1: peek empty queue->add->remove
    @Test
    public void test1() {
        assertNull(queue.peek(queue), "Queue should be empty initially");
        queue.add(queue, "1");
        assertEquals("1", queue.remove(queue).getData(), "Removed value should be '1'");
    }

    // Test 2: Add->add->add->add -> confirm order
    @Test
    public void test2() {
        queue.add(queue, "1");
        queue.add(queue, "2");
        queue.add(queue, "3");
        queue.add(queue, "4");
        String temp = queue.remove(queue).getData() + queue.remove(queue).getData() + queue.remove(queue).getData() + queue.remove(queue).getData();
        assertEquals("1234", temp, "FIFO - 1234 -> 1234");
    }

    // Test 3: Add->add->peek->remove->peek
    @Test
    public void test3() {
        queue.add(queue, "1");
        queue.add(queue, "2");
        assertEquals("1", queue.peek(queue).getData(), "Peeked value should be 1");
        assertEquals("1", queue.remove(queue).getData(), "Removed value should be '1'");
        assertEquals("2", queue.peek(queue).getData(), "Peeked value should be 1");
    }

    // Test 4: Remove from empty queue->add->remove
    @Test
    public void test4() {
        assertNull(queue.remove(queue));
        queue.add(queue, "1");
        assertEquals("1", queue.remove(queue).getData());

    }

}
