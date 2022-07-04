package view.usr.usr1000;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.ComController;
import com.FrontController;

import usr.usr1000.vo.Usr1000Vo;
import usr.usr1000.web.Usr1000Controller;

/*
 * 회원 추가
 */

public class Usr1001View {
	static Scanner sc = new Scanner(System.in);
	//날짜 포맷 2가지
	SimpleDateFormat yMDFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//날짜
	Calendar nowCal;
	
	public static void callView() {
		selectUsr1001View();
	}

	public static void selectUsr1001View() {
		System.out.println("\n[회원 추가]======================================================================");
		while(true) {
			System.out.println("\n* 추가할 회원의 ID를 입력합니다.");
			System.out.print("* 알파벳 소문자와 숫자가 각각 최소 1개 이상인 최소 5자리를 입력하세요. (뒤로는 999, 종료하려면 0을 입력하세요.) >> ");
			String inputId = sc.nextLine().trim();
			
			//메뉴 이동 먼저
			if("999".equals(inputId)) {
				break;
			}else if("0".equals(inputId)) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			//id 조회하기 먼저 
			}else {
				LinkedHashMap<String, String> inputIdMap = new LinkedHashMap<String, String>();
				inputIdMap.put("usrId", inputId);
				ComController selectController = FrontController.selectMapping("insertUsr1001");
				LinkedHashMap<String, String> returnMap = (LinkedHashMap<String, String>) selectController.selectMethod("selectUsr1000", inputIdMap);
				//회원 존재하면
				if(returnMap != null) {
					System.out.println("1001이미 존재하는 회원입니다.");
					continue;
				//회원 없으면 유효성 검사
				}else {
					//유효하지 않으면 반복문 계속
					if(!validUsr1001View(inputId)) {
						System.out.println("입력한 ID가 유효하지 않습니다.");
						continue;
					//유효하면 
					}else {
						LinkedHashMap<String, String> inputMap = new LinkedHashMap<String, String>();
						System.out.println("\n회원 ID : "+inputId);
						inputMap.put("usrId", inputId);
						System.out.print("회원명 : ");
						String inputName = sc.nextLine();
						inputMap.put("usrName", inputName);
						System.out.print("회원 성별 : ");
						String inputGender = sc.nextLine();
						inputMap.put("usrGender", inputGender);
						System.out.print("회원 연락처 : ");
						String inputPhoneNum = sc.nextLine();
						inputMap.put("usrPhoneNum", inputPhoneNum);
						System.out.print("회원 주소 : ");
						String inputAddresss = sc.nextLine();
						inputMap.put("usrAddress", inputAddresss);
						System.out.print("회원 설명 : ");
						String inputDetail = sc.nextLine();
						inputMap.put("usrDetail", inputDetail);
						System.out.print("만료 일자(yyyy-MM-dd) : ");
						String inputUsrExpireDate = sc.nextLine();
						inputMap.put("usrExpireDate", inputUsrExpireDate);
//					더블체크
						if(!dblCheck1001View()) {
							return;
						}else {
//							더블체크 통과하면 회원 추가 후, 반복문 돌기
							ComController insertController = FrontController.selectMapping("insertUsr1001");
							String result = (String) insertController.selectMethod("insertUsr1001", inputMap);
							System.out.println(result);
						}
						continue;
					}
				}//유효하면 체크하기 else end
			}//메뉴 이동 제외 else end
		}//while end
		
	}//insertUsr1001View() end
	
	//	유효성 검사
	public static boolean validUsr1001View(String inputId) {
		//알파벳 소문자 최소한 1개 이상, 숫자 최소한 1개 이상으로 이루어진 최소 5자리
		return Pattern.matches("^(?=.*[a-z])(?=.*\\d)[a-z\\d]{5,}$", inputId);
	}//validUsr1001View() end
	
	//더블 체크
	public static boolean dblCheck1001View() {
		System.out.print("정말로 등록하시겠습니까? (Y/N) >> ");
		String inputYn = sc.nextLine();
		return ("Y".equalsIgnoreCase(inputYn))? true : false;
	}//dblCheck1001View() end
}
