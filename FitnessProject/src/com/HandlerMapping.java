package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cht.cht1000.web.Cht1000Controller;
import cmm.cmm1000.web.Cmm1000Controller;
import lck.lck1000.web.Lck1000Controller;
import usr.usr1000.web.Usr1000Controller;

public class HandlerMapping {
	
	private static HandlerMapping handlerMapping;
	private HandlerMapping() {}
	//매핑 모음
	private static Map<String, ComController> map = new HashMap<String, ComController>();

	static Cmm1000Controller cmmCtrl;
//	static Usr1000Controller usrCtrl = new Usr1000Controller();
//	static Lck1000Controller lckCtrl = new Lck1000Controller();
//	static Cht1000Controller chtCtrl = new Cht1000Controller();
	
	
	//뷰
	public static HandlerMapping getInstance() {
		if(handlerMapping == null) {
			handlerMapping = new HandlerMapping();
		}
//		map = new HashMap<String, ComController>();
		map.put("00", new Cmm1000Controller());
		map.put("view.usr.usr1000.Usr1000View", new Usr1000Controller());
		map.put("view.usr.usr1000.Usr1001View", new Usr1000Controller());
		map.put("view.usr.usr1000.Usr1002View", new Usr1000Controller());
		map.put("view.usr.usr1000.Usr1003View", new Usr1000Controller());
		map.put("selectUsr1000", new Usr1000Controller());
		map.put("deleteUsr1003", new Usr1000Controller());
		map.put("insertUsr1001", new Usr1000Controller());
		map.put("updateUsr1002", new Usr1000Controller());
//		map.put("20", new Lck1000Controller(request));
//		map.put("21", new Lck1000Controller(request));
//		map.put("22", new Lck1000Controller(request));
//		map.put("23", new Lck1000Controller(request));
		map.put("view.cht.cht1000.Cht1000View", new Cht1000Controller());
		map.put("view.cht.cht1000.Cht1001View", new Cht1000Controller());
		map.put("selectCht1000Chrt", new Cht1000Controller());
		map.put("selectCht1001List", new Cht1000Controller());
		return handlerMapping;
	}
	
	//조회, 삭제
//	public static HandlerMapping getInstance(String request, String input) {
//		if(handlerMapping1 == null) {
//			handlerMapping1 = new HandlerMapping(request, input);
//		}
//		map.put("selectUsr1000", new Usr1000Controller(request, input));
//		map.put("deleteUsr1003", new Usr1000Controller(request, input));
//		map.put("selectLck1000", new Lck1000Controller(request, input));
//		map.put("deleteLck1003", new Lck1000Controller(request, input));
//		return handlerMapping1;
//	}
	
	//추가, 수정
//	public static HandlerMapping getInstance(String request, Map<String, String> input) {
//		if(handlerMapping2 == null) {
//			handlerMapping2 = new HandlerMapping(request, input);
//		}
//		map.put("insertUsr1001", new Usr1000Controller(request, input));
//		map.put("updateUsr1002", new Usr1000Controller(request, input));
//		map.put("insertLck1001", new Lck1000Controller(request, input));
//		map.put("updateLck1002", new Lck1000Controller(request, input));
//		return handlerMapping2;
//	}
	
	
	public ComController selectController(String request) {
		ComController controller = HandlerMapping.map.get(request);
		return controller;
	}

	
	
}
