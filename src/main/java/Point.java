import java.util.Scanner;
import java.util.Random;

public class Point {

    public double x,y;
    private static final Random RND = new Random();
    private static final Scanner sc = new Scanner(System.in);

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.hypot(dx, dy);
    }

    public static Point inPoint() {
        return new Point(sc.nextDouble(),sc.nextDouble());
    }

    public static Point randPoint() {
        return new Point(RND.nextDouble() * 100 - 50, RND.nextDouble() * 100 - 50);
    }

}
