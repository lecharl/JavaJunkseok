package view.lck.lck1000;

import java.util.Scanner;

import lck.lck1000.vo.Lck1000Vo;
import lck.lck1000.web.Lck1000Controller;
import usr.usr1000.vo.Usr1000Vo;
import usr.usr1000.web.Usr1000Controller;

/*
 * 사물함 추가
 */

public class Lck1001View {
	Scanner sc = new Scanner(System.in);
	Lck1000Controller lck1000Controller = new Lck1000Controller();
	Usr1000Controller usr1000Controller = new Usr1000Controller();

	public void selectLck1001View() throws Exception {
		System.out.println("\n[사물함 추가]======================================================================");
		while(true) {
			System.out.print("* 회원의 ID를 입력하세요. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
			String inputId = sc.nextLine();
			//메뉴 이동 먼저
			if("999".equals(inputId)) {
				break;
			}else if("0".equals(inputId)) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}else {
				//회원 먼저 조회
				Usr1000Vo usrVo = usr1000Controller.selectUsr1000(inputId);
				//null == id 존재안함
				if(usrVo == null) {
					System.out.println("존재하지 않는 회원입니다.");
					continue;
				//회원 존재하면 추가하기
				}else {
					System.out.println("\n회원 ID : "+inputId);
					System.out.print("사물함 번호 : ");
					String inputLckNo = sc.nextLine();
					System.out.print("만료 일자(yyyy-MM-dd) : ");
					String inputLckExpireDate = sc.nextLine();
//					더블 체크
					if(!dblCheck1001View()) {
						return;
					//더블체크 통과하면
					}else {
						Lck1000Vo newLckVo = new Lck1000Vo(inputLckNo, inputId, inputLckExpireDate);
						System.out.println(lck1000Controller.insertLck1001(newLckVo));
					}
				}//회원 존재 else end
			}//메뉴 이동 제외 else end
		}//while end
	}//selectLck1001View() end
	
	//더블 체크
	public boolean dblCheck1001View() {
		System.out.print("정말로 등록하시겠습니까? (Y/N) >> ");
		String inputYn = sc.nextLine();
		return ("Y".equalsIgnoreCase(inputYn))? true : false;
	}//dblCheck1001View() end

}
