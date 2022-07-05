package view.lck.lck1000;

import java.util.LinkedHashMap;
import java.util.Scanner;

import com.ComController;
import com.FrontController;

/*
 * 사물함 조회
 */
/**
 * @Class Name : Lck1000View.java
 * @Description : Lck1000View View class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Lck1000View {
	static Scanner sc = new Scanner(System.in);

	public static void callView() {
		selectLck1000View();
	}
	
	public static void selectLck1000View() {
		System.out.println("\n[사물함 조회]======================================================================");
		while(true) {
			System.out.print("\n* 조회할 사물함의 번호(1~99) 또는 회원의 ID를 입력하세요. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
			String input = sc.nextLine().trim();
			//메뉴 이동 먼저
			if("999".equals(input)) {
				break;
			}else if("0".equals(input)) {
				System.out.println(">> 프로그램을 종료합니다.");
				System.exit(0);
			//사물함 조회
			}else {
//				컨트롤러~
				LinkedHashMap<String, String> inputMap = new LinkedHashMap<String, String>();
				inputMap.put("input", input);
				ComController controller = FrontController.selectMapping("selectLck1000");
				try {
					LinkedHashMap<String, String> returnMap = (LinkedHashMap<String, String>) controller.selectMethod("selectLck1000", inputMap);
//					for (Entry<String, String> entrySet : returnMap.entrySet()) {
//						System.out.printf("- %s : %s\n", entrySet.getKey(), entrySet.getValue());
//					}
					returnMap.forEach((key, value) -> {
						String keyStr = changeLck1000Str(key);
						System.out.printf("- %s : %s\n", keyStr, value);
					});
				} catch (Exception e) {
					System.out.println(">> 다시 입력해주세요");
//					e.printStackTrace();
				}
			}
		}//while end
	}//selectUsr1000View() end
	
	public static String changeLck1000Str(String key) {
		String newStr = "사물함 번호";
		switch (key) {
		case "usrId":
			newStr = "사물함 번호";
			break;
		case "lckExpireDate":
			newStr = "만료 일자";
			break;
		}
		return newStr;
	}
}
