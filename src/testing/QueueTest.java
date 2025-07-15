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

    // enqueue values to queue and check toString()
    @Test
    public void testEnqueue() {
        assertNull(queue.peek(queue));
        queue.enqueue(queue, "1");
        queue.enqueue(queue, "3");
        queue.enqueue(queue, "2");
        queue.enqueue(queue, "4");
        queue.enqueue(queue, "5");
        assertEquals("[Node1 Data=1, Node2 Data=3, Node3 Data=2, Node4 Data=4, Node5 Data=5]", queue.toString(), "Queue toString does not match output.");
    }

    // dequeue values from queue
    @Test
    public void testDequeue() {
        assertNull(queue.peek(queue));
        queue.enqueue(queue, "1");
        queue.enqueue(queue, "2");
        queue.enqueue(queue, "3");
        assertEquals("1", queue.dequeue(queue).getData(), "dequeued value is incorrect.");
        assertEquals("2", queue.dequeue(queue).getData(), "dequeued value is incorrect.");
        assertEquals("3", queue.dequeue(queue).getData(), "dequeued value is incorrect.");
    }

    // Peek at values from queue
    @Test
    public void testPeek() {
        queue.enqueue(queue, "1");
        assertEquals("1", queue.peek(queue).getData(), "Peeked value is incorrect.");
        queue.dequeue(queue);
        queue.enqueue(queue, "2");
        assertEquals("2", queue.peek(queue).getData(), "Peeked value is incorrect.");
        queue.dequeue(queue);
        queue.enqueue(queue, "3");
        assertEquals("3", queue.peek(queue).getData(), "Peeked value is incorrect.");
        queue.dequeue(queue);

        assertNull(queue.peek(queue));

        queue.enqueue(queue, "1");
        queue.enqueue(queue, "2");
        queue.enqueue(queue, "3");
        assertEquals("1", queue.peek(queue).getData(), "Peeked value is incorrect.");
        queue.dequeue(queue);
        assertEquals("2", queue.peek(queue).getData(), "Peeked value is incorrect.");
        queue.dequeue(queue);
        assertEquals("3", queue.peek(queue).getData(), "Peeked value is incorrect.");

    }

    // Test 1: peek empty queue->enqueue->dequeue
    @Test
    public void test1() {
        assertNull(queue.peek(queue), "Queue should be empty initially");
        queue.enqueue(queue, "1");
        assertEquals("1", queue.dequeue(queue).getData(), "dequeued value should be '1'");
    }

    // Test 2: enqueue->enqueue->enqueue->enqueue -> confirm order
    @Test
    public void test2() {
        queue.enqueue(queue, "1");
        queue.enqueue(queue, "2");
        queue.enqueue(queue, "3");
        queue.enqueue(queue, "4");
        String temp = queue.dequeue(queue).getData() + queue.dequeue(queue).getData() + queue.dequeue(queue).getData() + queue.dequeue(queue).getData();
        assertEquals("1234", temp, "FIFO - 1234 -> 1234");
    }

    // Test 3: enqueue->enqueue->peek->dequeue->peek
    @Test
    public void test3() {
        queue.enqueue(queue, "1");
        queue.enqueue(queue, "2");
        assertEquals("1", queue.peek(queue).getData(), "Peeked value should be 1");
        assertEquals("1", queue.dequeue(queue).getData(), "dequeued value should be '1'");
        assertEquals("2", queue.peek(queue).getData(), "Peeked value should be 1");
    }

    // Test 4: dequeue from empty queue->enqueue->dequeue
    @Test
    public void test4() {
        assertNull(queue.dequeue(queue));
        queue.enqueue(queue, "1");
        assertEquals("1", queue.dequeue(queue).getData());

    }

}
