package testing;
import structures.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// CS-2920
// Unit test for Stack ADT

public class StackTest {
    private Stack<String> stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack<>();
    }

    // push
    @Test
    public void testPush(){
        stack.push("1");
        stack.push("2");
        stack.push("3");
        assertEquals("[Node1 Data=3, Node2 Data=2, Node3 Data=1]", stack.toString(), "Stack order is not correct");
    }

    // pop
    @Test
    public void testPop(){
        stack.push("1");
        stack.push("2");
        stack.push("3");
        assertEquals("3", stack.pop().getData(), "Popped item is not correct");
    }

    // peek
    @Test
    public void testPeek(){
        stack.push("1");
        stack.push("2");
        stack.push("3");
        assertEquals("3", stack.peek().getData(), "Peeked item is not correct");
        assertEquals("3", stack.pop().getData(), "Popped item is not correct");
        assertEquals("2", stack.peek().getData(), "Peeked item is not correct");

    }

    // isEmpty
    @Test
    public void testIsEmpty(){
        assertTrue(stack.isEmpty());
        stack.push("1");
        assertFalse(stack.isEmpty());
    }
}
