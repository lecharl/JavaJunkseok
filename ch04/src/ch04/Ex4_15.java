package ch04;

import java.util.Scanner;

public class Ex4_15 {

	public static void main(String[] args) {
//		임의의 숫자 맞히기
		
//		1~100 난수
		int comNum = (int)(Math.random()*100)+1;
		System.out.println("answer : "+comNum);
		int input;
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.print("1~100 의 정수를 입력하세요. >> ");
			input = scanner.nextInt();
			if(input > comNum) {
				System.out.println("더 작은 값으로 다시 시도해보세요.");
			}else if(input < comNum) {
				System.out.println("더 큰 값으로 다시 시도해보세요.");				
			}
		} while (input != comNum);
		System.out.println("정답입니다!!");

	}

}
