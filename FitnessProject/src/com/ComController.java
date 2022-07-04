package com;

import java.util.Map;

public interface ComController {

	void selectView(String request);

	Object selectMethod(String request, Map<String, String> inputMap);
	
//	Object selectMethod(String request, String inputStr);

}
