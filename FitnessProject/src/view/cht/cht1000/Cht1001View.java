package view.cht.cht1000;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ComController;
import com.FrontController;

import cht.cht1000.web.Cht1000Controller;

/*
 * 회원 목록
 */
/**
 * @Class Name : Cht1001View.java
 * @Description : Cht1001View View class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Cht1001View {
	static Scanner sc = new Scanner(System.in);

	public static void callView() {
		selectCht1001View();
	}
	
	public static void selectCht1001View() {
		System.out.println("\n[회원 목록]======================================================================");
		ComController controller = FrontController.selectMapping("selectCht1001List");
		List<Map<String, String>> returnList = (List<Map<String, String>>) ((Cht1000Controller)controller).selectMethod("selectCht1001List");
		for (Map<String, String> map : returnList) {
			map.forEach((key, value) -> {
				String keyStr = changeUsr1000Str(key);
				System.out.printf("- %s : %s\n", keyStr, value);
			});
			System.out.println("---------------------------------------------------");
		}
	}//selectCht1001View() end
	
	public static String changeUsr1000Str(String key) {
		String newStr = "회원 ID";
		switch (key) {
		case "usrName":
			newStr = "사물함 번호";
			break;
		case "usrGender":
			newStr = "회원 성별";
			break;
		case "usrPhoneNum":
			newStr = "회원 연락처";
			break;
		case "usrAddress":
			newStr = "회원 주소";
			break;
		case "usrDetail":
			newStr = "회원 설명";
			break;
		case "usrStatus":
			newStr = "회원 상태(정상/만료/임박)";
			break;
		case "joinDate":
			newStr = "가입 일자";
			break;
		case "usrExpireDate":
			newStr = "만료 일자";
			break;
		case "useYn":
			newStr = "사용 유무";
			break;
		case "enrollTime":
			newStr = "등록 일시";
			break;
		case "editTime":
			newStr = "수정 일시";
			break;
		}
		return newStr;
	}
}
