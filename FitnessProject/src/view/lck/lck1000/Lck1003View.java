package view.lck.lck1000;

import java.util.Scanner;

import lck.lck1000.web.Lck1000Controller;


/*
 * 사물함 삭제
 */

public class Lck1003View {
	Scanner sc = new Scanner(System.in);
	Lck1000Controller controller = new Lck1000Controller();
	
	public void selectLck1003View() {
		System.out.println("\n[사물함 삭제]======================================================================");
		while(true) {
			System.out.print("* 삭제할 사물함의 번호(1~99)를 입력하세요. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
			String inputNo = sc.nextLine();
			//메뉴 이동 먼저
			if("999".equals(inputNo)) {
				break;
			}else if("0".equals(inputNo)) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}else {
//				더블 체크
				if(!dblCheck1003View()) {
					return;
				//더블체크 통과하면 사물함 삭제
				}else {
					System.out.println(controller.deleteLck1003(inputNo));
				}
			}
		}
	}

	//더블 체크
	public boolean dblCheck1003View() {
		System.out.print("정말로 삭제하시겠습니까? (Y/N) >> ");
		String inputYn = sc.nextLine();
		return ("Y".equalsIgnoreCase(inputYn))? true : false;
	}//dblCheck1003View() end
}
