package view.lck.lck1000;

import java.util.Scanner;

import lck.lck1000.vo.Lck1000Vo;
import lck.lck1000.web.Lck1000Controller;

/*
 * 사물함 조회
 */

public class Lck1000View {
	Scanner sc = new Scanner(System.in);
	Lck1000Controller controller = new Lck1000Controller();

	public void selectLck1000View() {
		System.out.println("\n[사물함 조회]======================================================================");
		while(true) {
			System.out.print("\n* 조회할 사물함의 번호(1~99) 또는 회원의 ID를 입력하세요. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
			String input = sc.nextLine().trim();
			//메뉴 이동 먼저
			if("999".equals(input)) {
				break;
			}else if("0".equals(input)) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			//사물함 조회
			}else {
//				컨트롤러~
				Lck1000Vo returnVo = controller.selectLck1000(input);
				//null == input을 제대로 안하거나, 입력한 id에 배정된 사물함 존재 안함
				if(returnVo == null) {
					System.out.println("해당하는 사물함이 존재하지 않습니다. 다시 입력해주세요.");
				}else {
					System.out.println(returnVo);
				}
			}
		}//while end
	}//selectUsr1000View() end
}
