package view.usr.usr1000;

import java.util.LinkedHashMap;
import java.util.Scanner;

import com.ComController;
import com.FrontController;

/**
 * @Class Name : Usr1000View.java
 * @Description : Usr1000View View class, 회원 조회 화면
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Usr1000View {
	//입력 받을 Scanner 생성
	static Scanner sc = new Scanner(System.in);

	/**
	 * Usr1000View 화면 이동
	 * @desc 회원 조회 화면의 회원 조회 메뉴(selectUsr1000View()) 호출
	 * 
	 */
	public static void callView() {
		selectUsr1000View();
	}
	
	/**
	 * 회원 조회 메뉴
	 * @desc 회원 조회 메뉴를 출력한다.
	 * 
	 */
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
				LinkedHashMap<String, String> inputMap = new LinkedHashMap<String, String>();
				inputMap.put("input", inputId);
				ComController controller = FrontController.selectMapping("selectUsr1000");
				ComController lckController = FrontController.selectMapping("selectLck1000");
				try {
					LinkedHashMap<String, String> returnMap = (LinkedHashMap<String, String>) controller.selectMethod("selectUsr1000", inputMap);
					returnMap.forEach((key, value) -> {
						String keyStr = changeUsr1000Str(key);
						System.out.printf("- %s : %s\n", keyStr, value);
					});
					try {
						LinkedHashMap<String, String> returnLckMap = (LinkedHashMap<String, String>) lckController.selectMethod("selectLck1000", inputMap);
						System.out.printf("- 사물함 번호 : %s\n", returnLckMap.get("lckNo"));
					} catch (Exception e) {
					}
				} catch (Exception e) {
					System.out.println(">> 다른 ID로 조회하세요.");
				}
				
			}
		}//while end
		
	}//selectUsr1000View() end
	
	public static String changeUsr1000Str(String key) {
		String newStr = "회원 ID";
		switch (key) {
		case "usrName":
			newStr = "사물함 번호";
			break;
		case "usrGender":
			newStr = "회원 성별";
			break;
		case "usrPhoneNum":
			newStr = "회원 연락처";
			break;
		case "usrAddress":
			newStr = "회원 주소";
			break;
		case "usrDetail":
			newStr = "회원 설명";
			break;
		case "usrStatus":
			newStr = "회원 상태(정상/만료/임박)";
			break;
		case "joinDate":
			newStr = "가입 일자";
			break;
		case "usrExpireDate":
			newStr = "만료 일자";
			break;
		case "useYn":
			newStr = "사용 유무";
			break;
		case "enrollTime":
			newStr = "등록 일시";
			break;
		case "editTime":
			newStr = "수정 일시";
			break;
		}
		return newStr;
	}
}
