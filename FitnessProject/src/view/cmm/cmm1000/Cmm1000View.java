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
//				continue;
			}
//			switch (inputNum) {
//			case "11":
//				new Usr1000View().selectUsr1000View();
////				showUsrMenu();
//				break;
//			case "12":
//				showLckMenu();
//				break;
//			case "13":
//				showChtMenu();
//				break;
//			case "0":
//				System.out.print("프로그램을 종료합니다.");
//				System.exit(0);
//				break;
//			default:
//				System.out.println("메뉴의 번호를 다시 입력해주세요.");
//				continue;
//			}//switch end
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
//	public void selectCmm1000View() {
//		System.out.println("\n[헬스장관리 프로젝트]");
//		System.out.println("[메뉴]");
//		System.out.println("1. 회원 관리 \t 2. 사물함 관리 \t 3. 통계 \t 0. 종료");
//		System.out.print("선택할 메뉴의 번호를 입력하세요. (예: 회원 관리 :: 1) >> ");
//	}
	
	//회원 관리 소메뉴 출력
	public void showUsrMenu() {
		while(true) {
			System.out.println("\n[회원 관리]");
			System.out.println("1. 회원 조회 \t 2. 회원 등록 \t 3. 회원 수정 \t 4. 회원 삭제 \t 5.뒤로 \t 0.종료");
			System.out.print("선택할 메뉴의 번호를 입력하세요. (예: 회원 조회 :: 1) >> ");
			String inputSmall = sc.next();
			switch (inputSmall) {
//			case "1": case "2": case "3": case "4":
//				int intInput = Integer.valueOf(inputSmall) - 1;
//				request = "0" + intInput;
//				Controller controller = frCtrl.getMatchedMapping(request);
//				
//				break;
			case "1":
				request = "00";
				System.out.print("조회할 회원의 ID를 입력하세요. >> ");
//			회원 조회
				break;
			case "2":
				request = "01";
				System.out.print("등록할 회원의 ID를 입력하세요. >> ");
//			회원 추가S
				break;
			case "3":
				request = "02";
				System.out.print("수정할 회원의 ID를 입력하세요. >> ");
//			회원 수정
				break;
			case "4":
				request = "03";
				System.out.print("삭제할 회원의 ID를 입력하세요. >> ");
//			회원 삭제
				break;
			case "5":
				return;
			case "0":
				System.out.print("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("usrsmll번호를 다시 입력해주세요.");
				continue;
			}//switch end
		}//while end
	}
	
	//사물함 관리 소메뉴 출력
	public void showLckMenu() {
		while(true) {
			System.out.println("\n[사물함 관리]");
			System.out.println("1. 사물함 조회 \t 2. 사물함 추가 \t 3. 사물함 수정 \t 4. 사물함 삭제 \t 5.뒤로 \t 0.종료");
			System.out.print("선택할 메뉴의 번호를 입력하세요. (예: 사물함 조회 :: 1) >> ");
			String inputSmall = sc.next();
			switch (inputSmall) {
			case "1":
				request = "10";
				System.out.print("조회할 사물함의 번호 또는 회원의 ID를 입력하세요. >> ");
//			사물함 조회
				break;
			case "2":
				request = "11";
				System.out.print("등록할 회원의 ID를 입력하세요. >> ");
//			사물함 등록
				break;
			case "3":
				request = "12";
				System.out.print("수정할 사물함의 번호 또는 회원의 ID를 입력하세요. >> ");
//			사물함 수정
				break;
			case "4":
				request = "13";
				System.out.print("삭제할 사물함의 번호를 입력하세요. >> ");
//			사물함 삭제
				break;
			case "5":
				return;
			case "0":
				System.out.print("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("lcksmll번호를 다시 입력해주세요.");
				continue;
			}//switch end
		}//while end
	}
	
	//통계 소메뉴 출력
	public void showChtMenu() {
		while(true) {
			System.out.println("\n[통계]");
			System.out.println("1. 회원 통계 \t 2. 회원 목록 \t 5.뒤로 \t 0.종료");
			System.out.print("선택할 메뉴의 번호를 입력하세요. (예: 회원 통계 :: 1) >> ");
			String inputSmall = sc.next();
			switch (inputSmall) {
			case "1":
				request = "20";
//				회원 수, 임박 회원 수, 만료 회원 수
				System.out.println("회원 수 :: ");
				System.out.println("임박 회원 수 :: ");
				System.out.println("만료 회원 수 :: ");
				break;
			case "2":
				request = "21";
				System.out.println("<회원 목록>");
//				회원 목록 리스트
				break;
			case "5":
				return;
			case "0":
				System.out.print("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("sumsmll번호를 다시 입력해주세요.");
				continue;
			}//switch end
		}//while end
	}
}
