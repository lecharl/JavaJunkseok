package ch04;

import java.util.Scanner;

public class Ex4_18 {

	public static void main(String[] args) {
//		메뉴를 보여주고 선택하기
//		메뉴를 잘못 선택할 경우 continue로 사디 메뉴 보여주고,
//		종료(0)를 선택한 경우 break문으로 반복문 벗어나기
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("(1) 짬뽕");
			System.out.println("(2) 짜장");
			System.out.println("(3) 탕수육");
			System.out.print("원하는 메뉴(1~3)를 선택하세요. (종료: 0) >> ");
			int input = Integer.parseInt(scanner.next());
			if(input == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else if(!(1 <= input && input <= 3)){
				System.out.println("메뉴를 잘못 선택하셨습니다.");
				continue;
			}else {
				System.out.println("선택하신 메뉴는 "+input+"번입니다.");
			}
		}

	}

}
