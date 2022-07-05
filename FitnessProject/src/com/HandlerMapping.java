package com;

import java.util.HashMap;
import java.util.Map;

import cht.cht1000.web.Cht1000Controller;
import cmm.cmm1000.web.Cmm1000Controller;
import lck.lck1000.web.Lck1000Controller;
import usr.usr1000.web.Usr1000Controller;
/**
 * @Class Name : HandlerMapping.java
 * @Description : HandlerMapping class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class HandlerMapping {
	
	private static HandlerMapping handlerMapping;
	private HandlerMapping() {}
	//매핑 모음
	private static Map<String, ComController> map = new HashMap<String, ComController>();

	static Cmm1000Controller cmmCtrl;
	
	
	//뷰
	public static HandlerMapping getInstance() {
		if(handlerMapping == null) {
			handlerMapping = new HandlerMapping();
		}
		map.put("00", new Cmm1000Controller());
		map.put("view.usr.usr1000.Usr1000View", new Usr1000Controller());
		map.put("view.usr.usr1000.Usr1001View", new Usr1000Controller());
		map.put("view.usr.usr1000.Usr1002View", new Usr1000Controller());
		map.put("view.usr.usr1000.Usr1003View", new Usr1000Controller());
		map.put("selectUsr1000", new Usr1000Controller());
		map.put("deleteUsr1003", new Usr1000Controller());
		map.put("insertUsr1001", new Usr1000Controller());
		map.put("updateUsr1002", new Usr1000Controller());
		map.put("view.lck.lck1000.Lck1000View", new Lck1000Controller());
		map.put("view.lck.lck1000.Lck1001View", new Lck1000Controller());
		map.put("view.lck.lck1000.Lck1002View", new Lck1000Controller());
		map.put("view.lck.lck1000.Lck1003View", new Lck1000Controller());
		map.put("selectLck1000", new Lck1000Controller());
		map.put("insertLck1001", new Lck1000Controller());
		map.put("updateLck1002", new Lck1000Controller());
		map.put("deleteLck1003", new Lck1000Controller());
		map.put("view.cht.cht1000.Cht1000View", new Cht1000Controller());
		map.put("view.cht.cht1000.Cht1001View", new Cht1000Controller());
		map.put("countCht1000", new Cht1000Controller());
		map.put("countCht1000Stt", new Cht1000Controller());
		map.put("selectCht1001List", new Cht1000Controller());
		return handlerMapping;
	}
	
	public ComController selectController(String request) {
		return HandlerMapping.map.get(request);
	}

}
