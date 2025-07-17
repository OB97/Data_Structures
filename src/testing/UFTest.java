package testing;
import org.junit.jupiter.api.BeforeEach;
import structures.*;

// CS-2920
// Unit test for Union Find ADT

public class UFTest {
    private QuickUnionUF uf;

    // default array size = 10
    @BeforeEach
    public void setUp() {
        uf = new QuickUnionUF(10);
    }
}
