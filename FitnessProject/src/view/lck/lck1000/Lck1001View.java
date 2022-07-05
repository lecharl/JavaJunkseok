package view.lck.lck1000;

import java.util.LinkedHashMap;
import java.util.Scanner;

import com.ComController;
import com.FrontController;

/*
 * 사물함 추가
 */
/**
 * @Class Name : Lck1001View.java
 * @Description : Lck1001View View class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Lck1001View {
	static Scanner sc = new Scanner(System.in);

	public static void callView() {
		selectLck1001View();
	}
	
	public static void selectLck1001View() {
		System.out.println("\n[사물함 추가]======================================================================");
		while(true) {
			System.out.print("\n* 회원의 ID를 입력하세요. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
			String inputId = sc.nextLine().trim();
			//메뉴 이동 먼저
			if("999".equals(inputId)) {
				break;
			}else if("0".equals(inputId)) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}else {
				LinkedHashMap<String, String> inputIdMap = new LinkedHashMap<String, String>();
				inputIdMap.put("input", inputId);
				ComController controller = FrontController.selectMapping("insertLck1001");
				String result =  (String) controller.selectMethod("insertLck1001", inputIdMap);
				System.out.println(result);
				
			}//메뉴 이동 제외 else end
		}//while end
	}//selectLck1001View() end
	
}
