package view.usr.usr1000;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

import usr.usr1000.vo.Usr1000Vo;

/*
 * 회원 추가
 */

public class Usr1001View {
	Scanner sc = new Scanner(System.in);
	//날짜 포맷 2가지
	SimpleDateFormat yMDFormat = new SimpleDateFormat("YYYY-MM-DD");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	//날짜
	Calendar nowCal = Calendar.getInstance();

	public void insertUsr1001View() {
		System.out.println("\n[회원 추가]");
		while(true) {
			System.out.println("추가할 회원의 ID를 입력합니다.");
			System.out.print("알파벳 소문자와 숫자가 각각 최소 1개 이상인 최소 5자리를 입력하세요. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
			String inputId = sc.nextLine();
			
			//메뉴 이동 먼저
			if("999".equals(inputId)) {
				break;
			}else if("0".equals(inputId)) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			//유효성 체크
			}else {
				//유효하지 않으면 반복문 계속
				if(!validUsr1001View(inputId)) {
					System.out.println("입력한 ID가 유효하지 않습니다.");
					continue;
				//유효하면 추가하기
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
		
	}//insertUsr1001View() end
	
	//	유효성 검사
	public boolean validUsr1001View(String inputId) {
		//알파벳 소문자 최소한 1개 이상, 숫자 최소한 1개 이상으로 이루어진 최소 5자리
		return Pattern.matches("^(?=.*[a-z])(?=.*\\d)[a-z\\d]{5,}$", inputId);
	}//validUsr1001View() end
}