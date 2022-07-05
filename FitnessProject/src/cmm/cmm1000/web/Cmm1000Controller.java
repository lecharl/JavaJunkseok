package cmm.cmm1000.web;

import java.util.Map;

import com.ComController;

import view.cmm.cmm1000.Cmm1000View;
/**
 * @Class Name : Cmm1000Controller.java
 * @Description : Cmm1000Controller Controller class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Cmm1000Controller implements ComController {
	
	@Override
	public void selectView(String request) {
		Cmm1000View view = new Cmm1000View();
		view.menuLoop();
	}
	@Override
	public Object selectMethod(String request, Map<String, String> tempMap) {
		return null;
	}
	
	
}
