package view.usr.usr1000;

import java.util.Scanner;

import usr.usr1000.vo.Usr1000Vo;
import usr.usr1000.web.Usr1000Controller;

/*
 * 회원 삭제
 */

public class Usr1003View {
	Scanner sc = new Scanner(System.in);
	Usr1000Controller controller = new Usr1000Controller();
	
	public void deleteUsr1003View() {
		System.out.println("\n[회원 삭제]");
		while(true) {
			System.out.print("삭제할 회원의 ID를 입력하세요. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
			String inputId = sc.nextLine();
			//메뉴 이동 먼저
			if("999".equals(inputId)) {
				break;
			}else if("0".equals(inputId)) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			//회원 삭제
			}else {
//				더블 체크
				if(!dblCheck1003View()) {
					return;
				//더블체크 통과하면 회원 삭제 후, 반복문 돌기
				}else {
//				컨트롤러~
					System.out.println(controller.deleteUsr1003(inputId));
					continue;
				}
			}
		}//while end
	}//deleteUsr1003View() end
	
	//더블 체크
	public boolean dblCheck1003View() {
		System.out.print("정말로 삭제하시겠습니까? (Y/N) >> ");
		String inputYn = sc.nextLine();
		return ("Y".equalsIgnoreCase(inputYn))? true : false;
	}//dblCheck1003View() end
}
