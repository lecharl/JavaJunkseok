package view.lck.lck1000;

import java.util.LinkedHashMap;
import java.util.Scanner;

import com.ComController;
import com.FrontController;

/*
 * 사물함 수정
 */
/**
 * @Class Name : Lck1002View.java
 * @Description : Lck1002View View class
 * 
 * @author 이승연
 * @Since 2022.06.24.
 * @Version 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Lck1002View {
	Scanner sc = new Scanner(System.in);
	
	public void callView() {
		selectLck1002View();
	}
	
	public void selectLck1002View() {
		System.out.println("\n[사물함 수정]======================================================================");
		while(true) {
			System.out.print("\n* 수정할 사물함의 번호(1~99) 또는 회원의 ID를 입력하세요. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
			String input = sc.nextLine().trim();
			
			//메뉴 이동 먼저
			if("999".equals(input)) {
				break;
			}else if("0".equals(input)) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}else {
				LinkedHashMap<String, String> inputMap = new LinkedHashMap<String, String>();
				inputMap.put("input", input);
				ComController controller = FrontController.selectMapping("updateLck1002");
				String result =  (String) controller.selectMethod("updateLck1002", inputMap);
				System.out.println(result);
			}
//			else {
//				//사물함 조회로 존재 여부 확인
//				Lck1000Vo returnVo = controller.selectLck1000(input);
//				//null == input을 제대로 안하거나, 입력한 id에 배정된 사물함 존재 안함
//				if(returnVo == null) {
//					System.out.print("해당하는 사물함이 존재하지 않습니다. 다시 입력해주세요.");
////					continue;
//				}else {
//					//input이 lckNo라면
//					try {
//						if(1<= Integer.valueOf(input) && Integer.valueOf(input) <= 99) {
//							System.out.println("\n- 사물함 번호 : "+input);
//							System.out.print("- 회원 ID : "+returnVo.getUsrId()+" >> ");
//							String inputId = sc.nextLine();
//							System.out.print("- 만료 일자(yyyy-MM-dd) : "+returnVo.getLckExpireDate()+" >> ");
//							String inputLckExpireDate = sc.nextLine();
////						수정안하면 기존 정보로, 수정하면 수정한 거로 변경
//							List<String> newList = Arrays.asList(inputId, inputLckExpireDate);
//							List<String> oldList = Arrays.asList(returnVo.getUsrId(), returnVo.getLckExpireDate());
//							List<String> newList2 = new ArrayList<String>();
//							final int LIST_SIZE = newList.size();
//							for(int i=0; i<LIST_SIZE; i++) {
//								if(newList.get(i).length() == 0) {
//									newList2.add(oldList.get(i));
//								}else {
//									newList2.add(newList.get(i));
//								}
//							}
////						더블 체크
//							if(!dblCheck1002View()) {
//								return;
//								//더블체크 통과하면 사물함 수정
//							}else {
//								System.out.println(controller.updateLck1002(newList2, input));
//							}
//							//input이 id라면
//						}
//					} catch (Exception e) {
////						else {
//							System.out.println("\n- 회원 ID : "+input);
//							System.out.print("- 사물함 번호 : "+returnVo.getLckNo()+" >> ");
//							String inputLckNo = sc.nextLine();
//							System.out.print("- 만료 일자(yyyy-MM-dd) : "+returnVo.getLckExpireDate()+" >> ");
//							String inputLckExpireDate = sc.nextLine();
////						수정안하면 기존 정보로, 수정하면 수정한 거로 변경
//							List<String> newList = Arrays.asList(inputLckNo, inputLckExpireDate);
//							List<String> oldList = Arrays.asList(returnVo.getLckNo(), returnVo.getLckExpireDate());
//							List<String> newList2 = new ArrayList<String>();
//							final int LIST_SIZE = newList.size();
//							for(int i=0; i<LIST_SIZE; i++) {
//								if(newList.get(i).length() == 0) {
//									newList2.add(oldList.get(i));
//								}else {
//									newList2.add(newList.get(i));
//								}
//							}
////						더블 체크
//							if(!dblCheck1002View()) {
//								return;
//								//더블체크 통과하면 사물함 수정
//							}else {
//								System.out.println(controller.updateLck1002(newList2, input));
//							}
////						}
//						
//					}//catch end
//				}
//			}
		}//while end
	}//selectLck1002View() end

}
