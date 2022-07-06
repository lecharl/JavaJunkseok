package view.cmm.cmm1000;

import java.util.Scanner;

import com.ComController;
import com.FrontController;

/**
 * @Class Name : Cmm1000View.java
 * @Description : Cmm1000View View class, 메인 화면
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Cmm1000View {
	//입력 받을 Scanner 생성
	Scanner sc = new Scanner(System.in);
	
	/**
	 * 메인 메뉴(selectCmm1000View)를 반복문으로 계속 보여준다.
	 * @desc 1.회원 id 유무 확인
	 * 		 2.없는 회원일 경우 회원 정보 삽입
	 * 
	 */
	//메인 메뉴
	public void menuLoop() {

		while(true) {
			//메인 메뉴 호출
			selectCmm1000View();
			
			//입력 inputNum = 0,11,12,13,14,21,22,23,24,31,32, 그외
			String inputNum = sc.nextLine().trim();
			
			/* 요청을 담을 request 
			 * request = 0,10,11,12,13 20,21,22,23,30,31, 그외는 예외처리
			 */
			String request = "";
			try {
				//숫자로 바꿀 수 있는지 체크
				request = String.valueOf((Integer.valueOf(inputNum)-1));
			
			//숫자로 바꿀 수 없는 문자열이 들어올 때 예외처리
			} catch (NumberFormatException e) {
				System.out.println(">> 메뉴의 번호를 다시 입력해주세요.");
				continue;
			}
			
			//"0" 입력 시 프로그램 종료
			if("0".equals(inputNum)) {
				System.out.print(">> 프로그램을 종료합니다.");
				System.exit(0);
			}
			
			//changeToClsName() 호출 : request를 클래스이름으로 바꾼 요청 chgRequest
			String chgRequest = changeToClsName(request);
			
			//chgRequest에 맞는 컨트롤러 가져오기
			ComController comController = FrontController.selectMapping(chgRequest);
			
			try {
				//해당 컨트롤러로 화면 가져오기
				comController.selectView(chgRequest);
				
			//chgRequest가 (10,11,12,13 20,21,22,23,30,31) 에 없을 경우
			}catch (Exception e) {
				System.out.println(">> 메뉴의 번호를 다시 입력해주세요.");
			}
			
		}//while end
	}

	/**
	 * 메인 화면의 메인 메뉴
	 * @desc 메인 화면의 메인 메뉴를 출력한다.
	 * 
	 */
	public void selectCmm1000View() {
		System.out.println("\n*--*--*--*--*--*--*--*--*--*--*--*--[헬스장관리 프로젝트]--*--*--*--*--*--*--*--*--*--*--*--*");
		System.out.println("[메뉴]");
		System.out.println("1. 회원 관리");
		System.out.println("1-1) 회원 조회 \t 1-2) 회원 추가 \t 1-3) 회원 수정 \t 1-4) 회원 삭제\n");
		System.out.println("2. 사물함 관리");
		System.out.println("2-1) 사물함 조회 \t 2-2) 사물함 추가 \t 2-3) 사물함 수정 \t 2-4) 사물함 삭제\n");
		System.out.println("3. 통계");
		System.out.println("3-1) 회원 통계 \t 3-2) 회원 목록\n");
		System.out.println("0. 종료");
		System.out.print("* 선택할 메뉴의 번호를 입력하세요. (예: 회원 추가 :: 12, 종료 :: 0) >> ");
	}
	
	/**
	 * 요청에 맞게 클래스 이름으로 요청을 바꾼다.
	 * @desc 1. 요청에 맞게 클래스 이름으로 요청을 바꾼 후, 그 요청을 FrontController의 selectMapping()가 받아 컨트롤러를 가져온다.
	 * 		 2. 없으면 "다시 입력해 주세요." 출력
	 * 
	 * @param request 요청
	 * @return clsName 요청을 바꾼 결과(문자열)
	 */
	public String changeToClsName(String request) {
		String clsName = "";
		switch (request) {
		case "10":
			clsName = "view.usr.usr1000.Usr1000View";
			break;
		case "11":
			clsName = "view.usr.usr1000.Usr1001View";
			break;
		case "12":
			clsName = "view.usr.usr1000.Usr1002View";
			break;
		case "13":
			clsName = "view.usr.usr1000.Usr1003View";
			break;
		case "20":
			clsName = "view.lck.lck1000.Lck1000View";
			break;
		case "21":
			clsName = "view.lck.lck1000.Lck1001View";
			break;
		case "22":
			clsName = "view.lck.lck1000.Lck1002View";
			break;
		case "23":
			clsName = "view.lck.lck1000.Lck1003View";
			break;
		case "30":
			clsName = "view.cht.cht1000.Cht1000View";
			break;
		case "31":
			clsName = "view.cht.cht1000.Cht1001View";
			break;
		default:
			System.out.println(">> 다시 입력해 주세요.");
			break;
		}
		return clsName;
	}
	
}
