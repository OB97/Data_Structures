package testing;
import structures.UnionFind;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// CS-2920
// Unit test for Union Find ADT

public class UFTest {
    private UnionFind uf;

    // default array size = 10
    @BeforeEach
    public void setUp() {
        uf = new UnionFind(10);
    }
}
