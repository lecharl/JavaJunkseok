package com;

public class FitnessMain {

	public static void main(String[] args) throws Exception {
		HandlerMapping handlerMapping = HandlerMapping.getInstance();
//		HandlerMapping handlerMapping = new HandlerMapping();
		String request = "00";
//		FrontController frontController = new FrontController(request);
		FrontController.selectMapping(request).selectView(request);
	}

}
