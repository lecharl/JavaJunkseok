package com;

public class FitnessMain {

	public static void main(String[] args) throws Exception {
		FrontController frontController = new FrontController();
		String request = "00";
		frontController.selectController(request);

	}

}
