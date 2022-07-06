package com;
/**
 * @Class Name : FitnessMain.java
 * @Description : FitnessMain main class
 * @Modification Information
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class FitnessMain {

	public static void main(String[] args) {
		
		//HandlerMapping 객체 생성
		HandlerMapping.getInstance();
		
		//요청 "00" : Cmm1000Controller 컨트롤러 호출하는 요청
		String request = "00";
		try {
			//Cmm1000Controller로 메인 화면을 선택
			FrontController.selectMapping(request).selectView(request);
		} catch (Exception e) {
			System.out.println("\n프로그램을 종료합니다.");
		}
	}

}
