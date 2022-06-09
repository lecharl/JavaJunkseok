import java.util.Scanner;

public class StarEx2 {

	public static void main(String[] args) {
//		직각 역 삼각형
		/*
		 *****
		 ****
		 ***
		 **
		 *
		 */
		
		System.out.print("몇줄인지 입력하세요. >> ");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
//		i = 5(input), 4, 3, ...1
//		j = 5, 4, 3, ... 1
		
		for(int i=input; i>=1; i--) {
			for(int j=i; j>=1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
