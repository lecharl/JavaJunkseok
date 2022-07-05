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

	void selectView(String request);

	Object selectMethod(String request, Map<String, String> inputMap);
	
}
