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
		HandlerMapping.getInstance();
		String request = "00";
		try {
			FrontController.selectMapping(request).selectView(request);
		} catch (Exception e) {
			System.out.println("\n프로그램을 종료합니다.");
		}
	}

}
