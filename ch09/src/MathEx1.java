
import static java.lang.Math.*;

public class MathEx1 {

	public static void main(String[] args) {
		double val = 90.7552;
		System.out.println("90.7552 를 소수점 셋째자리에서 반올림해서 둘째자리까지 보여주기");
//		**round() -> 정수long
		System.out.printf("round(%.4f) = %d\n", val, round(val));
		
		val *= 100;
		System.out.printf("round(%.2f) = %d\n", val, round(val));
		
		System.out.printf("round(%.2f)/100 = %d\n", val, round(val)/100);
		System.out.printf("round(%.2f)/100.0 = %.2f\n", val, round(val)/100.0);
		
		System.out.printf("ceil(%3.1f)=%3.1f%n", 1.1, ceil(1.1));
		System.out.printf("floor(%3.1f)=%3.1f%n", 1.5, floor(1.5));
		System.out.printf("round(%3.1f)=%d%n", 1.1, round(1.1));
		System.out.printf("round(%3.1f)=%d%n", 1.5, round(1.5));
		System.out.println("----");
//		**rint() -> 실수double
		System.out.printf("rint(%3.1f)=%f%n", 1.5, rint(1.5));
		System.out.printf("round(%3.1f)=%d%n", -1.5, round(-1.5));
		System.out.printf("rint(%3.1f)=%f%n", -1.5, rint(-1.5));
		System.out.printf("ceil(%3.1f)=%f%n", -1.5, ceil(-1.5));
		System.out.printf("floor(%3.1f)=%f%n", -1.5, floor(-1.5));
		

	}

}
