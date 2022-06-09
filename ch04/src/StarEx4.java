import java.util.Scanner;

public class StarEx4 {

	public static void main(String[] args) {
//		공백 직각 역 삼각형
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
		
//		i =     5, 4, 3, 2, 1
//		공백k = 0, 1, 2, 3, 4(input - i)
//		j =     5, 4, 3, 2, 1(i 따라감)
		
		for(int i=input; i>=1; i--) {
			for(int k=0; k<input-i; k++) {
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
//		for(int i=1; i<=input; i++) {
//			for(int k=input-i; k>0; k--) {
//				System.out.print(" ");
//			}
//			for(int j=1; j<=i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}

	}

}
