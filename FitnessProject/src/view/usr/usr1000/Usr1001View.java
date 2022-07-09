package view.usr.usr1000;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Scanner;

import com.ComController;
import com.FrontController;

/*
 * 회원 추가
 */
/**
 * @Class Name : Usr1001View.java
 * @Description : Usr1001View View class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Usr1001View {
	Scanner sc = new Scanner(System.in);
	//날짜 포맷 2가지
	SimpleDateFormat yMDFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//날짜
	Calendar nowCal;
	
	public void callView() {
		selectUsr1001View();
	}

	public void selectUsr1001View() {
		System.out.println("\n[회원 추가]======================================================================");
		while(true) {
			System.out.println("\n* 추가할 회원의 ID를 입력합니다.");
			System.out.print("* 알파벳 소문자와 숫자가 각각 최소 1개 이상인 최소 5자리를 입력하세요. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
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
				inputIdMap.put("input", inputId);
				ComController controller = FrontController.selectMapping("insertUsr1001");
				String result = (String) controller.selectMethod("insertUsr1001", inputIdMap);
				System.out.println(result);
			}//메뉴 이동 제외 else end
		}//while end
		
	}//insertUsr1001View() end
	
}
