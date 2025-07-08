package testing;
import structures.LinkedList;
import structures.Queue;
import utility.Node;
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
}
