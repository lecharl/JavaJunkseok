import java.util.Scanner;

public class Scanf {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		연속으로 입력받고 싶을 때
		int num = scanner.nextInt();
		int num2 = scanner.nextInt();
		System.out.println(num);
		System.out.println(num2);
//		띄어쓰기로 두 수를 입력해도 되고, 엔터로 두 번 입력해도 된다.
		
//		*** NumberFormatException - nextInt() 가 숫자는 입력받고, 개행문자는 제거하지않은 채 그대로 남겨두기 때문에
//		해결방법 1 - scanner.nextInt 후 scanner.nextLine() 하기 전, scanner.nextLine() 을 한번 더 작성하여 개행문자 제거
		scanner.nextLine();
//		해결방법 2 - 위에 nextInt() 대신 scanner.nextLine() 로 읽어들인 후 Integer.parseInt()
		String inputString = scanner.nextLine();
		int num3 = Integer.parseInt(inputString);
		System.out.println(num3);
		
		scanner.close();
	}

}
