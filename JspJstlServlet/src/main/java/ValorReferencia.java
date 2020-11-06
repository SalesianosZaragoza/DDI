import java.awt.Point;
import java.awt.geom.Point2D;

public class ValorReferencia {
	public static void main(String[] args) {
	
		Point2D pointA = new Point(0, 0);
		Point2D pointB = new Point(4, 4);
		//pointA + pointB;Sobrecarga de operadores no existe en java
		int a = 5;
		int b = 4;
		int c = 3;
		pasoPorValor(a, b, c);
		pasoPorReferencia(pointA);
		//System.out.println(a);
		System.out.println(pointA.getX());
		System.out.println(pointA.getY());
		
		
	}
	
	private static int pasoPorValor(int a, int b, int c) {
		a =a + b+ c;
		return a;
	}
	
	private static void pasoPorReferencia(Point2D point) {
		point.setLocation(1, 1);
		point = new Point(2,2);
	}
	
}
