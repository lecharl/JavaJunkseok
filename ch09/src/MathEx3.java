
import static java.lang.Math.*;

public class MathEx3 {

	public static void main(String[] args) {
		int x1 = 1, y1 = 1;
		int x2 = 2, y2 = 2;
		
//		double pow(double a, double n) :: a의 n승
		double c = sqrt(pow(x2-x1, 2) + pow(y2-y1, 2));	//거리 구하기
		double a = c * sin(PI/4);	//PI/4 rad = 45 degree
		double b = c * cos(PI/4);
		double b1 = c * cos(toRadians(45));	//위와 같음
		
		System.out.printf("a= %f%n", a);
		System.out.printf("b= %f%n", b);
		System.out.printf("b1= %f%n", b1);
		System.out.printf("c= %f%n", c);
		System.out.printf("angle=%f rad%n", atan2(a, b));
		System.out.printf("angle=%f degree%n", atan2(a, b)*180/PI);
		System.out.printf("angle=%f degree%n", toDegrees(atan2(a,b)));	//위와 같음
		
		System.out.printf("24 * log10(2)=%f%n", 24*log10(2));
		System.out.printf("53 * log10(2)=%f%n", 53*log10(2));
		
	}

}
