package view.usr.usr1000;

import java.util.LinkedHashMap;
import java.util.Scanner;

import com.ComController;
import com.FrontController;

/**
 * @Class Name : Usr1003View.java
 * @Description : Usr1003View View class, 회원 삭제 화면
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Usr1003View {
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * Usr1003View 화면 이동
	 * @desc 회원 삭제 화면의 회원 삭제 메뉴(selectUsr1003View()) 호출
	 * 
	 */
	public static void callView() {
		selectUsr1003View();
	}
	
	/**
	 * 회원 삭제 메뉴
	 * @desc 회원 삭제 메뉴를 출력한다.
	 * 
	 */
	public static void selectUsr1003View() {
		System.out.println("\n[회원 삭제]======================================================================");
		
		while(true) {
			System.out.print("\n* 삭제할 회원의 ID를 입력하세요. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
			String inputId = sc.nextLine().trim();
			
			/* 메뉴 이동 */
			//"999" 입력 시 이전 화면으로
			if("999".equals(inputId)) {
				break;
			//"0" 입력 시 프로그램 종료
			}else if("0".equals(inputId)) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				
			/* 그 외 */ 	
			}else {
				//입력한 문자열을 Map에 담기
				LinkedHashMap<String, String> inputIdMap = new LinkedHashMap<String, String>();
				inputIdMap.put("input", inputId);
				
				/* 회원 삭제 요청을 받고 온 컨트롤러 */
				ComController controller = FrontController.selectMapping("deleteUsr1003");
				
				String result = (String) controller.selectMethod("deleteUsr1003", inputIdMap);
				System.out.println(result);
			}
		}
	}
	
}
