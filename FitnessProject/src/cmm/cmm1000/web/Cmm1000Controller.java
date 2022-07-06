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
	
	/**
	 * 요청에 맞는 화면 선택
	 * @desc 요청("00", 메인 화면)에 맞는 화면 Cmm1000View를 생성해서 메인 메뉴를 계속 보여준다.
	 * 
	 * @param request 요청("00", 메인 화면)
	 * @return 
	 */
	@Override
	public void selectView(String request) {
		Cmm1000View view = new Cmm1000View();
		view.menuLoop();
	}
	
	/**
	 * 요청에 맞는 메소드 선택
	 * @desc 필요없지만 공통 메서드이기에 구현만 함
	 * 
	 * @param request	요청
	 * @param inputMap	화면에서 보낸 정보를 담은 Map
	 */
	@Override
	public Object selectMethod(String request, Map<String, String> inputMap) {
		return null;
	}
	
	
}
