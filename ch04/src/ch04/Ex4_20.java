package ch04;

import java.util.Scanner;

public class Ex4_20 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		outLoop : while(true) {
			System.out.println("(1) 제곱");
			System.out.println("(2) 제곱근");
			System.out.println("(3) 로그");
			System.out.print("원하는 항목(1~3)을 선택하세요.(종료: 0) >> ");
			int input = Integer.valueOf(scanner.next());
			if(input == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (!(1 <= input && input <= 3)) {
				System.out.println("메뉴를 잘못 선택하셨습니다.");
				continue;
			}
//			input == 1~3이 아니면 여기까지 못오니까 괜찮음!!
//			1~3이면 아래~~
			System.out.println("선택하신 항목은 "+input+"번입니다.");
			for(;;) {
				System.out.print("계산할 값을 입력하세요.(계산 종료: 0, 전체 종료: 99) >> ");
				int num = Integer.valueOf(scanner.next());
				if(num == 99) {
					System.out.println("프로그램을 종료합니다.");
					break outLoop;
				} else if (num == 0) {
					System.out.println("항목 선택으로 돌아갑니다.");
					break;
				}
//				num == 99, 0이면 여기까지 못오니까 괜찮음!
				switch (input) {
				case 1:
					System.out.println("result = "+num*num);
					break;
				case 2:
					System.out.println("result = "+Math.sqrt((double)num));
					break;
				case 3:
					System.out.println("result = "+Math.log((double)num));
					break;
				}
			} //for(;;)

		} //outLoop
	}

}
