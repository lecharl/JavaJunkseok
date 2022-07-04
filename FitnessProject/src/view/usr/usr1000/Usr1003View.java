package view.usr.usr1000;

import java.util.LinkedHashMap;
import java.util.Scanner;

import com.ComController;
import com.FrontController;


/*
 * 회원 삭제
 */

public class Usr1003View {
	static Scanner sc = new Scanner(System.in);
	
	public static void callView() {
		selectUsr1003View();
	}
	
	public static void selectUsr1003View() {
		System.out.println("\n[회원 삭제]======================================================================");
		while(true) {
			System.out.print("\n* 삭제할 회원의 ID를 입력하세요. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
			String inputId = sc.nextLine().trim();
			//메뉴 이동 먼저
			if("999".equals(inputId)) {
				break;
			}else if("0".equals(inputId)) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			//id 조회하기 먼저 
			}else {
				LinkedHashMap<String, String> inputIdMap = new LinkedHashMap<String, String>();
				inputIdMap.put("usrId", inputId);
				ComController selectController = FrontController.selectMapping("insertUsr1001");
				LinkedHashMap<String, String> returnMap = (LinkedHashMap<String, String>) selectController.selectMethod("selectUsr1000", inputIdMap);
				//회원 없으면
				if(returnMap == null) {
					System.out.println("다른 ID로 조회하세요sdsdd.");
					continue;
				//회원 존재하면
				}else {
//				더블체크
					if(!dblCheck1003View()) {
						return;
						//더블체크 통과하면 회원 삭제 후, 반복문 돌기
					}else {
						ComController controller = FrontController.selectMapping("deleteUsr1003");
						String result = (String) controller.selectMethod("deleteUsr1003", returnMap);
						System.out.println(result);
					}
				}
			}
		}//while end
	}//deleteUsr1003View() end
	
	//더블 체크
	public static boolean dblCheck1003View() {
		System.out.print("정말로 삭제하시겠습니까? (Y/N) >> ");
		String inputYn = sc.nextLine();
		return ("Y".equalsIgnoreCase(inputYn))? true : false;
	}//dblCheck1003View() end
}
