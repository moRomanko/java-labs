// 9. Определить класс Четырехугольник на плоскости, вершины которого имеют тип Точка.
// Определить площадь и периметр четырехугольника.
// Создать массив/список/множество объектов и подсчитать количество
// четырехугольников разного типа (квадрат, прямоугольник, ромб, произвольный).
// Определить для каждой группы наибольший и наименьший по площади (периметру) объект.

import java.util.Scanner;

public class T9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите способ ввода координат вершин четырехугольников: 1 - ручной, 2 - случайный");
        int choice = sc.nextInt();

        System.out.print("Введите количество четырехугольников: ");
        int n = sc.nextInt();

        Quadrilateral[] quadrilaterals = new Quadrilateral[n];

        if (choice == 1) {
            System.out.println("Введите точки четырехугольника:");
            for (int i = 0; i < n; i++) {
                quadrilaterals[i] = Quadrilateral.inQuadrilateral();
            }
        } else {
            for (int i = 0; i < n; i++) {
                quadrilaterals[i] = Quadrilateral.randQuadrilateral();
            }
        }

        String[] typeNames = {"квадратов", "прямоугольников", "ромбов", "произвольных четырёхугольников"};
        int[] counts = new int[4];

        double[] maxArea = new double[4];
        double[] minArea = new double[4];
        double[] maxPerim = new double[4];
        double[] minPerim = new double[4];

        for (int i = 0; i < 4; i++) {
            maxArea[i] = Double.NEGATIVE_INFINITY;
            minArea[i] = Double.POSITIVE_INFINITY;
            maxPerim[i] = Double.NEGATIVE_INFINITY;
            minPerim[i] = Double.POSITIVE_INFINITY;
        }

        for (Quadrilateral q : quadrilaterals) {
            q.type();
            int idx = switch (q.type) {
                case "square" -> 0;
                case "rectangle" -> 1;
                case "rhombus" -> 2;
                default -> 3; // arbitrary
            };

            counts[idx]++;

            double area = q.area();
            double perimeter = q.perimeter();

            if (area > maxArea[idx]) {
                maxArea[idx] = area;
            } else if (area < minArea[idx]) {
                minArea[idx] = area;
            }

            if (perimeter > maxPerim[idx]) {
                maxPerim[idx] = perimeter;
            } else if (perimeter < minPerim[idx]) {
                minPerim[idx] = perimeter;
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.println("\nКоличество " + typeNames[i] + " : " + counts[i]);
            if (counts[i] > 0) {
                System.out.println("  Наибольшая площадь: " + maxArea[i]);
                System.out.println("  Наименьшая площадь: " + minArea[i]);
                System.out.println("  Наибольший периметр: " + maxPerim[i]);
                System.out.println("  Наименьший периметр: " + minPerim[i]);
            }
        }


    }
}