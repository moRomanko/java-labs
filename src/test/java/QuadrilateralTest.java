import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuadrilateralTest {

    private static final double EPS = 1e-9;

    @Test
    void testConstructor() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(1, 1);
        Point d = new Point(0, 1);

        Quadrilateral q = new Quadrilateral(a, b, c, d);

        assertSame(a, q.a);
        assertSame(b, q.b);
        assertSame(c, q.c);
        assertSame(d, q.d);
    }

    @Test
    void testPerimeterSquare() {
        Quadrilateral q = new Quadrilateral(
                new Point(0, 0),
                new Point(2, 0),
                new Point(2, 2),
                new Point(0, 2)
        );

        assertEquals(8.0, q.perimeter(), EPS);
    }

    @Test
    void testAreaSquare() {
        Quadrilateral q = new Quadrilateral(
                new Point(0, 0),
                new Point(2, 0),
                new Point(2, 2),
                new Point(0, 2)
        );

        assertEquals(4.0, q.area(), EPS);
    }

    @Test
    void testAreaRectangle() {
        Quadrilateral q = new Quadrilateral(
                new Point(0, 0),
                new Point(4, 0),
                new Point(4, 3),
                new Point(0, 3)
        );

        assertEquals(12.0, q.area(), EPS);
    }

    @Test
    void testTypeSquare() {
        Quadrilateral q = new Quadrilateral(
                new Point(0, 0),
                new Point(2, 0),
                new Point(2, 2),
                new Point(0, 2)
        );

        q.type();

        assertEquals("square", q.type);
    }

    @Test
    void testTypeRectangle() {
        Quadrilateral q = new Quadrilateral(
                new Point(0, 0),
                new Point(4, 0),
                new Point(4, 2),
                new Point(0, 2)
        );

        q.type();

        assertEquals("rectangle", q.type);
    }

    @Test
    void testTypeRhombus() {
        Quadrilateral q = new Quadrilateral(
                new Point(0, 0),
                new Point(2, 1),
                new Point(4, 0),
                new Point(2, -1)
        );

        q.type();

        assertEquals("rhombus", q.type);
    }

    @Test
    void testTypeArbitrary() {
        Quadrilateral q = new Quadrilateral(
                new Point(0, 0),
                new Point(4, 0),
                new Point(3, 2),
                new Point(0, 3)
        );

        q.type();

        assertEquals("arbitrary", q.type);
    }

    @Test
    void testRandQuadrilateral() {
        Quadrilateral q = Quadrilateral.randQuadrilateral();

        assertNotNull(q);
        assertNotNull(q.a);
        assertNotNull(q.b);
        assertNotNull(q.c);
        assertNotNull(q.d);

        assertTrue(q.a.x >= -50 && q.a.x <= 50);
        assertTrue(q.a.y >= -50 && q.a.y <= 50);

        assertTrue(q.b.x >= -50 && q.b.x <= 50);
        assertTrue(q.b.y >= -50 && q.b.y <= 50);

        assertTrue(q.c.x >= -50 && q.c.x <= 50);
        assertTrue(q.c.y >= -50 && q.c.y <= 50);

        assertTrue(q.d.x >= -50 && q.d.x <= 50);
        assertTrue(q.d.y >= -50 && q.d.y <= 50);
    }
}