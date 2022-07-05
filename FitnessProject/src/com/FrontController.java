package com;

/**
 * @Class Name : FrontController.java
 * @Description : FrontController class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class FrontController {
	
	static HandlerMapping handlerMapping = HandlerMapping.getInstance();
	
	public static ComController selectMapping(String request) {
		return handlerMapping.selectController(request);
	}
	
	
	
}
