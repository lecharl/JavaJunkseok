package view.lck.lck1000;

import java.util.LinkedHashMap;
import java.util.Scanner;

import com.ComController;
import com.FrontController;

/*
 * 사물함 삭제
 */
/**
 * @Class Name : Lck1003View.java
 * @Description : Lck1003View View class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Lck1003View {
	static Scanner sc = new Scanner(System.in);
	
	public static void callView() {
		selectLck1003View();
	}
	
	public static void selectLck1003View() {
		System.out.println("\n[사물함 삭제]======================================================================");
		while(true) {
			System.out.print("\n* 삭제할 사물함의 번호(1~99)를 입력하세요. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
			String inputNo = sc.nextLine().trim();
			//메뉴 이동 먼저
			if("999".equals(inputNo)) {
				break;
			}else if("0".equals(inputNo)) {
				System.out.println(">> 프로그램을 종료합니다.");
				System.exit(0);
			//no 조회하기 먼저
			}else {
				LinkedHashMap<String, String> inputMap = new LinkedHashMap<String, String>();
				inputMap.put("input", inputNo);
				
				ComController controller = FrontController.selectMapping("deleteLck1003");
				String result = (String) controller.selectMethod("deleteLck1003", inputMap);
				System.out.println(result);
				
//				ComController selectController = FrontController.selectMapping("selectLck1000");
//				try {
//					LinkedHashMap<String, String> returnMap = (LinkedHashMap<String, String>) selectController.selectMethod("selectLck1000", inputMap);
//					//returnMap의 usrId를 공백""과 비교
//					//id가 배정되지 않은 아예 비어있는 사물함이라면
//					if("".equals(returnMap.get("usrId"))) {
//						System.out.println(">> 비어있는 사물함입니다.");
//						continue;
//					}else {
//						//배정된 사물함이면
////						더블 체크
//						if(!dblCheck1003View()) {
//							return;
//						}else {
//							//더블체크 통과하면 사물함 삭제
//							ComController controller = FrontController.selectMapping("deleteLck1003");
//							String result = (String) controller.selectMethod("deleteLck1003", inputMap);
//							
//							System.out.println(result);
//						}
//					}
//				} catch (Exception e) {
//					System.out.println(">> 다시 입력해주세요");
////					e.printStackTrace();
//				}
				
				
			}
		}
	}

	//더블 체크
	public static boolean dblCheck1003View() {
		System.out.print("정말로 삭제하시겠습니까? (Y/N) >> ");
		String inputYn = sc.nextLine();
		return ("Y".equalsIgnoreCase(inputYn))? true : false;
	}//dblCheck1003View() end
}
