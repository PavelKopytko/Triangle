package by.epam.tr.triangle;

public class Main {

	public static void main(String[] args) {

		Triangle tr = new Triangle(new Point(0, 1), new Point(2, 3), new Point(3, 1));

		System.out.printf("Perimeter: %.2f\n", tr.getPerimeter());

		System.out.printf("Square: %.2f\n", tr.getSquare());

		System.out.printf("Median point ( %.2f; %.2f)\n", tr.getMedianPoint().getX(), tr.getMedianPoint().getY());

		tr.setApexB(new Point(2, 1));

	}

}
