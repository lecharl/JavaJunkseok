package com;

import view.cmm.cmm1000.Cmm1000View;

public class FitnessMain {

	public static void main(String[] args) {
		FrontController frontController = new FrontController();
		String request = "00";
		frontController.selectController(request);
//		Cmm1000View view = new Cmm1000View();
//		view.menuLoop();

	}

}
