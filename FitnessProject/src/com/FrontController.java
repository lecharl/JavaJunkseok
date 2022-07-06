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
	
	/**
	 * 요청을 받아서 매핑을 선택
	 * @desc HandlerMapping에 요청에 맞는 컨트롤러 생성해서 반환
	 * 
	 * @param request 요청
	 * @return 요청에 맞는 컨트롤러 반환(handlerMapping의 selectController() 호출), ComController는 Controller의 공통 인터페이스
	 */
	public static ComController selectMapping(String request) {
		return HandlerMapping.selectController(request);
	}
	
	
	
}
