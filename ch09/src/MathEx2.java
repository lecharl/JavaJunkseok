
import static java.lang.Math.*;

public class MathEx2 {

	public static void main(String[] args) {
//		**..Exact :: 정수형 간의 연산에서 발생할 수 있는 오버플로우 감지
		
		int i = Integer.MIN_VALUE;
		System.out.println("i= "+i);
		System.out.println("-i= "+(-i));	//오버플로우
		
		try {
			System.out.printf("negateExact(%d)= %d%n", 10, negateExact(10));
			System.out.printf("negateExact(%d)= %d%n", -10, negateExact(-10));
			System.out.printf("negateExact(%d)= %d%n", i, negateExact(i));	//예외발생
			
		} catch (ArithmeticException e) {
//			i -> long 타입으로 형변환 -> negateExact(long a) 호출
			System.out.printf("negateExact(%d)= %d%n", (long)i, negateExact((long)i));
			
		}

	}

}
