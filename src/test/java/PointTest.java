import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    private static final double EPS = 1e-9;

    @Test
    void testConstructor() {
        Point p = new Point(3.5, 4.2);

        assertEquals(3.5, p.x, EPS);
        assertEquals(4.2, p.y, EPS);
    }

    @Test
    void testDistanceTo() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);

        assertEquals(5.0, p1.distanceTo(p2), EPS);
    }

    @Test
    void testDistanceToSamePoint() {
        Point p = new Point(2, 3);

        assertEquals(0.0, p.distanceTo(p), EPS);
    }

    @Test
    void testRandPoint() {
        Point p = Point.randPoint();

        assertNotNull(p);

        assertTrue(p.x >= -50 && p.x <= 50);
        assertTrue(p.y >= -50 && p.y <= 50);
    }
}