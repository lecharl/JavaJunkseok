package view.cht.cht1000;

import java.util.Scanner;

import cht.cht1000.web.Cht1000Controller;

/*
 * 회원 수
 * 임박 회원 수
 * 만료 회원 수
 */

public class Cht1000View {
	Scanner sc = new Scanner(System.in);
	Cht1000Controller controller = new Cht1000Controller();
	
	public void selectCht1000View()  throws Exception{
		System.out.println("\n[회원 통계]======================================================================");
//		컨트롤러
		System.out.println("1) 회원 수 : "+controller.countCht1000()+"명");
//		컨트롤러
		System.out.println("2) 임박 회원 수 : "+controller.countCht1000Stt("임박")+"명");
//		컨트롤러
		System.out.println("3) 만료 회원 수 : "+controller.countCht1000Stt("만료")+"명");
	}
}
