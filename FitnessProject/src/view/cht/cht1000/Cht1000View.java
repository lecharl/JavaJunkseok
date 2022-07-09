package view.cht.cht1000;

import com.ComController;
import com.FrontController;

import cht.cht1000.web.Cht1000Controller;

/*
 * 회원 수
 * 임박 회원 수
 * 만료 회원 수
 */
/**
 * @Class Name : Cht1000View.java
 * @Description : Cht1000View View class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Cht1000View {
	
	public void callView() {
		selectCht1000View();
	}
	
	public void selectCht1000View() {
		System.out.println("\n[회원 통계]======================================================================");
		ComController controller = FrontController.selectMapping("countCht1000");
		int cntResult = (int) ((Cht1000Controller)controller).selectMethod("countCht1000");
		System.out.println("1) 회원 수 : "+cntResult+"명");
		int immResult = (int) ((Cht1000Controller)controller).selectMethod("countCht1000Stt", "임박");
		System.out.println("2) 임박 회원 수 : "+immResult+"명");
		int expResult = (int) ((Cht1000Controller)controller).selectMethod("countCht1000Stt", "만료");
		System.out.println("2) 만료 회원 수 : "+expResult+"명");
	}
}
