import java.util.Scanner;

public class StarEx1 {

	public static void main(String[] args) {
//		FlowEx17
//		직각삼각형
		/*
		 * 
		 **
		 ***
		 ****
		 *****
		 */
		System.out.print("몇줄인지 입력하세요. >> ");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
//		i = 1, 2, 3, ... 9, 10 줄일 때
//		j = 1, 2, 3, ... 9, 10개 출력
		
		for(int i=1; i<=input; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
