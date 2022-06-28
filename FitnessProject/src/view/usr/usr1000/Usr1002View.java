package view.usr.usr1000;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

import usr.usr1000.vo.Usr1000Vo;

/*
 * 회원 수정
 */

public class Usr1002View {
	Scanner sc = new Scanner(System.in);
	//날짜 포맷 2가지
	SimpleDateFormat yMDFormat = new SimpleDateFormat("YYYY-MM-DD");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	//날짜
	Calendar nowCal = Calendar.getInstance();

	public void updateUsr1002View() {
		System.out.println("\n[회원 수정]");
		while(true) {
			System.out.println("수정할 회원의 ID를 입력합니다. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
			String inputId = sc.nextLine();
			
			//메뉴 이동 먼저
			if("999".equals(inputId)) {
				break;
			}else if("0".equals(inputId)) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			//회원 조회로 존재 여부 확인
			}else {
				//존재하지 않으면(null) 반복문 계속
//				컨트롤러~ 회원 조회
				if(!validUsr1001View(inputId)) {
					System.out.println("존재하지 않는 회원입니다.");
					continue;
//				존재하면 회원 조회로 vo가져와서 보여준 뒤 수정하기????
				}else {
//				컨트롤러~
					System.out.println("\n회원ID : "+inputId);
					System.out.print("회원명 : ");
					String inputName = sc.nextLine();
					System.out.print("회원 성별 : ");
					String inputGender = sc.nextLine();
					System.out.print("회원 연락처 : ");
					String inputPhoneNum = sc.nextLine();
					System.out.print("회원 주소 : ");
					String inputAddresss = sc.nextLine();
					System.out.print("회원 설명 : ");
					String inputDetail = sc.nextLine();
					System.out.print("만료 일자(YYYY-MM-dd) : ");
					String inputUsrExpireDate = sc.nextLine();
//					더블체크????
					//vo를 생성해 담아서 보내기~
					HashMap<String, Usr1000Vo> newUsrMap = new HashMap<String, Usr1000Vo>();
					Usr1000Vo newUsrVo = new Usr1000Vo.Builder(inputId, inputName, inputGender, inputPhoneNum, inputAddresss, inputDetail)
							.joinDate(yMDFormat.format(nowCal))
							.usrExpireDate(inputUsrExpireDate)
							.enrollTime(dateTimeFormat.format(nowCal))
							.editTime(dateTimeFormat.format(nowCal))
							.build();
					newUsrMap.put(inputId, newUsrVo);
					System.out.println("회원 등록이 정상적으로 완료되었습니다.");
				}
			}
		}//while end
		
	}//updateUsr1002View() end
}
