public class Quadrilateral {

    public Point a, b, c, d;
    public String type;
    public double EPS = 1e-9;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double perimeter() {
        return a.distanceTo(b)
                + b.distanceTo(c)
                + c.distanceTo(d)
                + d.distanceTo(a);
    }

    public double area() {
        return Math.abs(a.x * b.y - b.x * a.y
                + b.x * c.y - c.x * b.y
                + c.x * d.y - d.x * c.y
                + d.x * a.y - a.x * d.y
        ) / 2.0;
    }

    private double[] sides() {
        return new double[]{
                a.distanceTo(b),
                b.distanceTo(c),
                c.distanceTo(d),
                d.distanceTo(a)
        };
    }

    private double[] diagonals() {
        return new double[]{
                a.distanceTo(c),
                b.distanceTo(d)
        };
    }

    private boolean eq(double x, double y) {
        return Math.abs(x - y) < EPS;
    }

    public void type() {
        double[] sides = sides();
        double[] diags = diagonals();

        boolean allSidesEqual = eq(sides[0], sides[1]) && eq(sides[1], sides[2]) && eq(sides[2], sides[3]);

        boolean oppositeSidesEqual = eq(sides[0], sides[2]) && eq(sides[1], sides[3]);

        boolean diagonalsEqual = eq(diags[0], diags[1]);

        if (allSidesEqual && diagonalsEqual) {
            this.type = "square";
        } else if (allSidesEqual) {
            this.type = "rhombus";
        } else if (oppositeSidesEqual && diagonalsEqual) {
            this.type = "rectangle";
        } else {
            this.type = "arbitrary";
        }
    }

    public static Quadrilateral inQuadrilateral() {
        System.out.print("Введите координаты точек:\nA: ");
        Point a = Point.inPoint();
        System.out.print("B: ");
        Point b = Point.inPoint();
        System.out.print("C: ");
        Point c = Point.inPoint();
        System.out.print("D: ");
        Point d = Point.inPoint();
        return new Quadrilateral(a,b,c,d);
    }

    public static Quadrilateral randQuadrilateral() {
        Point a = Point.randPoint();
        Point b = Point.randPoint();
        Point c = Point.randPoint();
        Point d = Point.randPoint();
        return new Quadrilateral(a,b,c,d);
    }

}
