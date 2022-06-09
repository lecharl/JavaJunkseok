import java.util.Scanner;

public class StarEx3 {

	public static void main(String[] args) {
//		공백 직각 삼각형
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
		
//		i = 1, 2, ... 4, 5(최대input)
//		공백k = 4, 3, ... 1, 0(input-i)
//		j = 1, 2, ... 4, 5(i따라감)
		
		for(int i=1; i<=input; i++) {
			for(int k=input-i; k>0; k--) {
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
