package view.cmm.cmm1000;

import java.util.Scanner;

import com.FrontController;

import view.usr.usr1000.Usr1000View;

public class Cmm1000View {
	FrontController frontController = new FrontController();
	Scanner sc = new Scanner(System.in);
	String request = "";	//사용자 요청
	
	//메뉴 루프 돌리기
	public void menuLoop() throws Exception {
		while(true) {
			selectCmm1000View();
			String inputNum = sc.nextLine().trim();
			//inputNum = 0,11,12,13,14,21,22,23,24,31,32, 그외
			String request = "";
			try {
				request = String.valueOf((Integer.valueOf(inputNum)-1));
				//request = 0,10,11,12,13 20,21,22,23 30,31, 그외는 예외처리
			} catch (NumberFormatException e) {
				System.out.println("메뉴의 번호를 다시 입력해주세요.");
				continue;
			}
			if("0".equals(inputNum)) {
				System.out.print("프로그램을 종료합니다.");
				System.exit(0);
			}
			if(frontController.selectMapList().indexOf(request) != -1){	
				frontController.selectController(request);
			}else {
				System.out.println("메뉴의 번호를 다시 입력해주세요ㅇㅇㅇ.");
			}
//			switch (inputNum) {
		}//while end
	}

	//대메뉴 출력
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
		System.out.print("선택할 메뉴의 번호를 입력하세요. (예: 회원 추가 :: 12, 종료 :: 0) >> ");
	}
	
}
