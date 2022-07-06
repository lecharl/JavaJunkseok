package com;

import java.util.Map;

/**
 * @Class Name : ComController.java
 * @Description : ComController Controller interface, Controller의 공통 인터페이스
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public interface ComController {

	/**
	 * 요청에 맞는 화면 선택
	 * @desc 요청에 맞는 화면 선택
	 * 
	 * @param request 요청
	 */
	void selectView(String request);

	/**
	 * 요청에 맞는 메소드 선택
	 * @desc 요청에 맞는 기능(조회/등록/수정/삭제 등) 선택
	 * 
	 * @param request	요청
	 * @param inputMap	화면에서 보낸 정보를 담은 Map
	 */
	Object selectMethod(String request, Map<String, String> inputMap);
	
}
