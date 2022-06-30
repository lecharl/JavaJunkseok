package view.cht.cht1000;

import java.util.List;
import java.util.Scanner;

import cht.cht1000.web.Cht1000Controller;
import usr.usr1000.vo.Usr1000Vo;

public class Cht1001View {
	Scanner sc = new Scanner(System.in);
	Cht1000Controller controller = new Cht1000Controller();
	
	public void selectCht1001View()  throws Exception{
		System.out.println("\n[회원 목록]======================================================================");
//		컨트롤러~~
		List<Usr1000Vo> returnList = controller.selectCht1001List();
		//회원이 0명이 아니라면
		if(returnList != null && returnList.size() != 0) {
			for (Usr1000Vo usr1000Vo : returnList) {
				System.out.println(usr1000Vo);
				System.out.println("---------------------------------------------------");
			}
		}
	}//selectCht1001View() end
}
