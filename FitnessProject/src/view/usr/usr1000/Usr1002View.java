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
//			else {
//				//회원 조회로 존재 여부 확인
////				컨트롤러~ 회원 조회
//				Usr1000Vo returnVo = controller.selectUsr1000(inputId);
//				//회원 존재안하면 아래 출력 후, 반복문 돌기
//				if(returnVo == null) {
//					System.out.println("존재하지 않는 회원입니다.");
////					continue;
//				}else {
//					//존재하면 회원 조회로 vo가져와서 보여준 뒤 수정하기????
////					System.out.println(returnVo);
//					System.out.println("\n- 회원ID : "+inputId);
//					System.out.print("- 회원명 : "+returnVo.getUsrName()+" >> ");
//					String inputName = sc.nextLine();
//					System.out.print("- 회원 성별 : "+returnVo.getUsrGender()+" >> ");
//					String inputGender = sc.nextLine();
//					System.out.print("- 회원 연락처 : "+returnVo.getUsrPhoneNum()+" >> ");
//					String inputPhoneNum = sc.nextLine();
//					System.out.print("- 회원 주소 : "+returnVo.getUsrAddress()+" >> ");
//					String inputAddress = sc.nextLine();
//					System.out.print("- 회원 설명 : "+returnVo.getUsrDetail()+" >> ");
//					String inputDetail = sc.nextLine();
//					System.out.print("- 만료 일자(yyyy-MM-dd) : "+returnVo.getUsrExpireDate()+" >> ");
//					String inputUsrExpireDate = sc.nextLine();
////					수정안하면 기존 정보로, 수정하면 수정한 거로 변경
//					List<String> newList = Arrays.asList(inputName, inputGender, inputPhoneNum, inputAddress, inputDetail, inputUsrExpireDate);
//					List<String> oldList = Arrays.asList(returnVo.getUsrName(), returnVo.getUsrGender(), returnVo.getUsrPhoneNum(), returnVo.getUsrAddress(), returnVo.getUsrDetail(), returnVo.getUsrExpireDate());
//					List<String> newList2 = new ArrayList<String>();
//					final int LIST_SIZE = newList.size();
//					for(int i=0; i<LIST_SIZE; i++) {
//						if(newList.get(i).length() == 0) {
//							newList2.add(oldList.get(i));
//						}else {
//							newList2.add(newList.get(i));
//						}
//					}
////					System.out.println(newList2);
////					더블체크
//					if(!dblCheck1002View()) {
//						return;
//					//더블체크 통과하면 회원 수정 후, 반복문 돌기
//					}else {
////						컨트롤러~
//						System.out.println(controller.updateUsr1002(newList2, inputId));
//					}
//				}//if returnVo 존재 여부 end 
//			}//if id정확히 입력 여부 end
		}//while end
		
	}//updateUsr1002View() end
	
	
	//더블 체크
	public boolean dblCheck1002View() {
		System.out.print("정말로 수정하시겠습니까? (Y/N) >> ");
		String inputYn = sc.nextLine();
		return ("Y".equalsIgnoreCase(inputYn))? true : false;
	}//dblCheck1002View() end
}
