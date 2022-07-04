package view.usr.usr1000;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.ComController;
import com.FrontController;

import usr.usr1000.vo.Usr1000Vo;
import usr.usr1000.web.Usr1000Controller;

/*
 * 회원 조회
 */

public class Usr1000View {
	static Scanner sc = new Scanner(System.in);

	public static void callView() {
		selectUsr1000View();
	}
	
	public static void selectUsr1000View() {
		System.out.println("\n[회원 조회]======================================================================");
		while(true) {
			System.out.print("\n* 조회할 회원의 ID를 입력하세요. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
			String inputId = sc.nextLine().trim();
			//메뉴 이동 먼저
			if("999".equals(inputId)) {
				break;
			}else if("0".equals(inputId)) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			//회원 조회
			}else {
//			컨트롤러~
				//다시 프론트 불러서 
				LinkedHashMap<String, String> inputMap = new LinkedHashMap<String, String>();
				inputMap.put("usrId", inputId);
				ComController controller = FrontController.selectMapping("selectUsr1000");
				try {
					LinkedHashMap<String, String> returnMap = (LinkedHashMap<String, String>) controller.selectMethod("selectUsr1000", inputMap);
//					LinkedHashMap<String, String> returnMap = (LinkedHashMap<String, String>) controller.selectUsr1000(inputId);
					returnMap.forEach((key, value) -> {
						System.out.printf("- %s : %s\n", key, value);
					});
//					controller.selectMethod("selectUsr1000", inputId);
				} catch (Exception e) {
					System.out.println("다른 ID로 조회하세요.");
//					e.printStackTrace();
				}
//				for (Entry<String, String> entrySet : returnMap.entrySet()) {
//					System.out.printf("- %s : %s\n", entrySet.getKey(), entrySet.getValue());
//				}
				
			}
		}//while end
		
	}//selectUsr1000View() end
	
}
