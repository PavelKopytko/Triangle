package by.epam.tr.triangle;

import java.util.Objects;

/* Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления площади, 
 * периметра и точки пересечения медиан*/

public class Triangle {

	private Point apexA;
	private Point apexB;
	private Point apexC;

	public Triangle() {
		apexA = new Point(0, 0);
		apexB = new Point(0, 1);
		apexC = new Point(1, 0);

	}

	public Triangle(Point apexA, Point apexB, Point apexC) {
		this.apexA = apexA;
		this.apexB = apexB;
		this.apexC = apexC;
		if (!isCorrect()) {
			System.out.println("Triangle triangle does not exist");// может лучше Exception?
			return;
		}
	}

	public Point getApexA() {
		return apexA;
	}

	public void setApexA(Point apexA) {
		this.apexA = apexA;
		if (!isCorrect()) {
			System.out.println("Triangle triangle does not exist");// может лучше Exception?
			return;
		}
	}

	public Point getApexB() {
		return apexB;
	}

	public void setApexB(Point apexB) {
		this.apexB = apexB;
		if (!isCorrect()) {
			System.out.println("Triangle does not exist");// может лучше Exception?
			return;
		}
	}

	public Point getApexC() {
		return apexC;
	}

	public void setApexC(Point apexC) {
		this.apexC = apexC;
		if (!isCorrect()) {
			System.out.println("Triangle triangle does not exist");// может лучше Exception?
			return;
		}
	}

	public double getPerimeter() {
		return (length(apexA, apexB) + length(apexB, apexC) + length(apexA, apexC)) /* / 2.0 */;
	}

	public double getSquare() {
		return Math.sqrt(getPerimeter() / 2 * (getPerimeter() / 2 - length(apexA, apexB))
				* (getPerimeter() / 2 - length(apexB, apexC)) * (getPerimeter() / 2 - length(apexA, apexC)));
	}

	public Point getMedianPoint() {
		double x = (apexA.getX() + apexB.getX() + apexC.getX()) / 3;
		double y = (apexA.getY() + apexB.getY() + apexC.getY()) / 3;
		return new Point(x, y);
	}

	private double length(Point a, Point b) {
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
	}

	private boolean isCorrect() {

		double lengthAB = length(apexA, apexB);
		double lengthBC = length(apexB, apexC);
		double lengthAC = length(apexA, apexC);

		if (lengthAB + lengthBC > lengthAC && lengthAC + lengthBC > lengthAB && lengthAC + lengthAB > lengthBC) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apexA, apexB, apexC);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		return Objects.equals(apexA, other.apexA) && Objects.equals(apexB, other.apexB)
				&& Objects.equals(apexC, other.apexC);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [apexA=" + apexA + ", apexB=" + apexB + ", apexC=" + apexC + "]";
	}

}
