package view.usr.usr1000;

import java.util.Scanner;

/*
 * 회원 조회
 */

public class Usr1000View {
	Scanner sc = new Scanner(System.in);

	public void selectUsr1000View() {
		System.out.println("\n[회원 조회]");
		while(true) {
			System.out.print("조회할 회원의 ID를 입력하세요. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
			String inputUsrId = sc.next();
			//메뉴 이동 먼저
			if("999".equals(inputUsrId)) {
				break;
			}else if("0".equals(inputUsrId)) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			//회원 조회
			}else {
//			컨트롤러~
				//회원 존재하면
				System.out.println("\n<"+inputUsrId+">의 정보");
				//회원 존재안하면 아래 출력 후, 반복문 돌기
				System.out.println("존재하지 않는 회원입니다.");
				continue;
				
			}
		}//while end
		
	}//selectUsr1000View() end
}
