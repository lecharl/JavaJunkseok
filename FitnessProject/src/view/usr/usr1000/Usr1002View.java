package view.usr.usr1000;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/*
 * 회원 수정
 */
/**
 * @Class Name : Usr1002View.java
 * @Description : Usr1002View View class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Usr1002View {
	static Scanner sc = new Scanner(System.in);
	//날짜 포맷 2가지
	SimpleDateFormat yMDFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//날짜
	Calendar nowCal;

	public static void callView() {
		selectUsr1002View();
	}
	
	public static void selectUsr1002View() {
		System.out.println("\n[회원 수정]======================================================================");
		while(true) {
			System.out.println("\n* 수정할 회원의 ID를 입력합니다. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
			String inputId = sc.nextLine().trim();
			
			//메뉴 이동 먼저
			if("999".equals(inputId)) {
				break;
			}else if("0".equals(inputId)) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
		}//while end
		
	}//updateUsr1002View() end
	
	
	//더블 체크
	public boolean dblCheck1002View() {
		System.out.print("정말로 수정하시겠습니까? (Y/N) >> ");
		String inputYn = sc.nextLine();
		return ("Y".equalsIgnoreCase(inputYn))? true : false;
	}//dblCheck1002View() end
}
