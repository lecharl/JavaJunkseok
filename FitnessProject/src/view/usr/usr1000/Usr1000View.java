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
	Scanner sc = new Scanner(System.in);

	/**
	 * Usr1000View 화면 이동
	 * @desc 회원 조회 화면의 회원 조회 메뉴(selectUsr1000View()) 호출
	 * 
	 */
	public void callView() {
		selectUsr1000View();
	}
	
	/**
	 * 회원 조회 메뉴
	 * @desc 1. 조회할 회원 ID를 입력한다.
	 * 		 2. 예외 처리 : "999"는 이전 메뉴로, "0"은 프로그램 종료, 회원 ID가 아닌 입력은 다시 메뉴 출력
	 * 		 3. 회원 조회와 사물함 조회를 요청하여 받아온 컨트롤러로 회원 조회와 사물함 조회, 사물함이 존재한다면 사물함 번호도 함께 출력 
	 * 
	 */
	public void selectUsr1000View() {
		System.out.println("\n[회원 조회]======================================================================");
		
		while(true) {
			System.out.print("\n* 조회할 회원의 ID를 입력하세요. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
			String inputId = sc.nextLine().trim();
			//메뉴 이동 먼저
			if("999".equals(inputId)) {
				break;
			}else if("0".equals(inputId)) {
				System.out.println(">> 프로그램을 종료합니다.");
				System.exit(0);
			//회원 조회
			}else {
				LinkedHashMap<String, String> inputMap = new LinkedHashMap<String, String>();
				inputMap.put("input", inputId);
				ComController controller = FrontController.selectMapping("selectUsr1000");
				ComController lckController = FrontController.selectMapping("selectLck1000");
				try {
					LinkedHashMap<String, String> returnMap = (LinkedHashMap<String, String>) controller.selectMethod("selectUsr1000", inputMap);
					System.out.printf("- 회원 ID : %s\n", returnMap.get("usrId"));
					System.out.printf("- 회원 이름 : %s\n", returnMap.get("usrName"));
					System.out.printf("- 회원 성별 : %s\n", returnMap.get("usrGender"));
					System.out.printf("- 회원 연락처 : %s\n", returnMap.get("usrPhoneNum"));
					System.out.printf("- 회원 주소 : %s\n", returnMap.get("usrAddress"));
					System.out.printf("- 회원 설명 : %s\n", returnMap.get("usrDetail"));
					System.out.printf("- 회원 상태(정상/만료/임박): %s\n", returnMap.get("usrStatus"));
					System.out.printf("- 가입 일자 : %s\n", returnMap.get("joinDate"));
					System.out.printf("- 만료 일자 : %s\n", returnMap.get("usrExpireDate"));
					System.out.printf("- 사용 유무 : %s\n", returnMap.get("useYn"));
					System.out.printf("- 등록 일시 : %s\n", returnMap.get("enrollTime"));
					System.out.printf("- 수정 일시 : %s\n", returnMap.get("editTime"));

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
	
}
