package view.cht.cht1000;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ComController;
import com.FrontController;

import cht.cht1000.web.Cht1000Controller;
import usr.usr1000.vo.Usr1000Vo;

/*
 * 회원 목록
 */
public class Cht1001View {
	static Scanner sc = new Scanner(System.in);

	public static void callView() {
		selectCht1001View();
	}
	
	public static void selectCht1001View() {
		System.out.println("\n[회원 목록]======================================================================");
//		컨트롤러~~
		ComController controller = FrontController.selectMapping("selectCht1001List");
		List<Map<String, String>> returnList = (List<Map<String, String>>) ((Cht1000Controller)controller).selectMethod("selectCht1001List");
		//회원이 0명이 아니라면
		for (Map<String, String> map : returnList) {
			map.forEach((key, value) -> {
				System.out.printf("- %s : %s\n", key, value);
			});
			System.out.println("---------------------------------------------------");
		}
//		if(returnList != null && returnList.size() != 0) {
//			for (Usr1000Vo usr1000Vo : returnList) {
//				System.out.println(usr1000Vo);
//				System.out.println("---------------------------------------------------");
//			}
//		}
	}//selectCht1001View() end
}
