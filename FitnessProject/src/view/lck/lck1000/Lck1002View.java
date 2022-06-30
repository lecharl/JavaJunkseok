package view.lck.lck1000;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import lck.lck1000.vo.Lck1000Vo;
import lck.lck1000.web.Lck1000Controller;

/*
 * 사물함 수정
 */

public class Lck1002View {
	Scanner sc = new Scanner(System.in);
	Lck1000Controller controller = new Lck1000Controller();
	
	public void selectLck1002View() {
		System.out.println("\n[사물함 수정]======================================================================");
		while(true) {
			System.out.println("* 삭제할 사물함의 번호(1~99) 또는 회원의 ID를 입력하세요. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
			String input = sc.nextLine();
			
			//메뉴 이동 먼저
			if("999".equals(input)) {
				break;
			}else if("0".equals(input)) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}else {
				//사물함 조회로 존재 여부 확인
				Lck1000Vo returnVo = controller.selectLck1000(input);
				//null == input을 제대로 안하거나, 입력한 id에 배정된 사물함 존재 안함
				if(returnVo == null) {
					System.out.println("해당하는 사물함이 존재하지 않습니다. 다시 입력해주세요.");
//					continue;
				}else {
					//input이 lckNo라면
					if(1<= Integer.valueOf(input) && Integer.valueOf(input) <= 99) {
						System.out.println("\n- 사물함 번호 : "+input);
						System.out.print("- 회원 ID : "+returnVo.getUsrId()+" >> ");
						String inputId = sc.nextLine();
						System.out.print("- 만료 일자(yyyy-MM-dd) : "+returnVo.getLckExpireDate()+" >> ");
						String inputLckExpireDate = sc.nextLine();
//						수정안하면 기존 정보로, 수정하면 수정한 거로 변경
						List<String> newList = Arrays.asList(inputId, inputLckExpireDate);
						List<String> oldList = Arrays.asList(returnVo.getUsrId(), returnVo.getLckExpireDate());
						final int LIST_SIZE = newList.size();
						for(int i=0; i<LIST_SIZE; i++) {
							chgInput1002View(oldList.get(i), newList.get(i));
						}
//						더블 체크
						if(!dblCheck1002View()) {
							return;
						//더블체크 통과하면 사물함 수정
						}else {
							System.out.println(controller.updateLck1002(newList, input));
						}
					//input이 id라면
					}else {
						System.out.println("\n- 회원 ID : "+input);
						System.out.print("- 사물함 번호 : "+returnVo.getLckNo()+" >> ");
						String inputLckNo = sc.nextLine();
						System.out.print("- 만료 일자(yyyy-MM-dd) : "+returnVo.getLckExpireDate()+" >> ");
						String inputLckExpireDate = sc.nextLine();
//						수정안하면 기존 정보로, 수정하면 수정한 거로 변경
						List<String> newList = Arrays.asList(inputLckNo, inputLckExpireDate);
						List<String> oldList = Arrays.asList(returnVo.getLckNo(), returnVo.getLckExpireDate());
						final int LIST_SIZE = newList.size();
						for(int i=0; i<LIST_SIZE; i++) {
							chgInput1002View(oldList.get(i), newList.get(i));
						}
//						더블 체크
						if(!dblCheck1002View()) {
							return;
							//더블체크 통과하면 사물함 수정
						}else {
							System.out.println(controller.updateLck1002(newList, input));
						}
					}
				}
			}
		}//while end
	}//selectLck1002View() end

	//정보 바꾸기
	private void chgInput1002View(String oldInfo, String newInfo) {
		if("".equals(newInfo)) {
			newInfo = oldInfo;
		}
	}//chgInput1002View() end

	//더블 체크
	public boolean dblCheck1002View() {
		System.out.print("정말로 삭제하시겠습니까? (Y/N) >> ");
		String inputYn = sc.nextLine();
		return ("Y".equalsIgnoreCase(inputYn))? true : false;
	}//dblCheck1002View() end
}
