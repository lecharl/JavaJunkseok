package ch04;

import java.util.Scanner;

public class Ex4_14 {

	public static void main(String[] args) {
//		각 자리수의 합 구하기
		System.out.print("숫자를 입력하세요. >> ");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int sum = 0;
//		num = 12345, 1234, 123, 12, 1
//		끝자리 = 5, 4, 3, 2, 1
		
		while(num>0) {
			sum += num%10;
			System.out.printf("sum = %d, num = %d, 끝 = %d\n", sum, num, num%10);
			num /= 10;
		}
//		for문으로
		for(int n=num; n>0; n /= 10) {
			sum += n%10;
			System.out.printf("sum = %d, num = %d, 끝 = %d\n", sum, n, n%10);
		}

	}

}
