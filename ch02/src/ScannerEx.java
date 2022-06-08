import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("두자리 정수를 하나 입력해주세요. >> ");
//		String inputString = scanner.nextLine();
		int inputString = scanner.nextInt();
//		int num = Integer.parseInt(inputString);
		
//		System.out.println("입력내용 >> "+num);
//		System.out.println("num = "+num);
		System.out.println("입력내용 >> "+inputString);
		System.out.println("num = "+inputString);

	}

}
