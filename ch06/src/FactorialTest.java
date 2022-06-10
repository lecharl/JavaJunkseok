import java.util.Scanner;

public class FactorialTest {

	public static void main(String[] args) {
//		팩토리얼 
		System.out.print("자연수를 입력하세요. >> ");
		Scanner scanner = new Scanner(System.in);
		int result = factorial(scanner.nextInt());
		System.out.println(result);

	}
	
	private static int factorial(int i) {
		int result = 0;
//		13!부터 20억이 넘기 때문에 -> long으로 하면 됨
//		fac(0) = 0 * fac(-1) * fac(-2) * ...... -> 스택오버플로우 에러!!!
		if(i <= 0 || i > 12) {
			result = -1;
		}else if(i == 1) {
			result = 1;
		}else {
			result =  i*factorial(i-1);
		}
		return result;
	}

}
