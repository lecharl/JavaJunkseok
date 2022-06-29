package view.usr.usr1000;

import java.util.Scanner;

import usr.usr1000.vo.Usr1000Vo;
import usr.usr1000.web.Usr1000Controller;

/*
 * 회원 조회
 */

public class Usr1000View {
	Scanner sc = new Scanner(System.in);
	Usr1000Controller controller = new Usr1000Controller();

	public void selectUsr1000View() {
		System.out.println("\n[회원 조회]");
		while(true) {
			System.out.print("조회할 회원의 ID를 입력하세요. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
			String inputId = sc.nextLine();
			//메뉴 이동 먼저
			if("999".equals(inputId)) {
				break;
			}else if("0".equals(inputId)) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			//회원 조회
			}else {
//			컨트롤러~
				Usr1000Vo returnVo = controller.selectUsr1000(inputId);
				//회원 존재안하면 아래 출력 후, 반복문 돌기
				if(returnVo == null) {
					System.out.println("존재하지 않는 회원입니다.");
					continue;
				}else {
					//회원 존재하면 정보 출력 후, 반복문 돌기
					System.out.println(returnVo);
					continue;
				}
				
			}
		}//while end
		
	}//selectUsr1000View() end
	
}
