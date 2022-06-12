import java.util.Scanner;

public class FactorialTest2 {

	public static void main(String[] args) {
//		팩토리얼 
		System.out.print("1~20 사이를 입력하세요. >> ");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		long result = 0;
		for(int i=1; i<=input; i++) {
			result = factorial(i);
			if(result == -1) {
				System.out.println("유효하지 않은 값입니다.(0이상 20이하) >> "+input);
				break;
			}
			System.out.printf("%2d! %20d\n", i, result);
		}

	}
	
	private static long factorial(int i) {
//		21!부터는 오버플로우
//		fac(0) = 0 * fac(-1) * fac(-2) * ...... -> 스택오버플로우 에러!!!
		if(i <= 0 || i > 20) return -1;
		if(i == 1)	return 1;
		return i * factorial(i-1);
	}

}
