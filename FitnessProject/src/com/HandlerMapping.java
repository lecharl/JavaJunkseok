package com;

import java.util.HashMap;
import java.util.Map;

import cht.cht1000.web.Cht1000Controller;
import cmm.cmm1000.web.Cmm1000Controller;
import lck.lck1000.web.Lck1000Controller;
import usr.usr1000.web.Usr1000Controller;
/**
 * @Class Name : HandlerMapping.java
 * @Description : HandlerMapping class, 매핑 모음과 매핑을 선택하는 메소드가 존재
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
	
	/* HandlerMapping 싱글톤 */
	private static HandlerMapping handlerMapping;
	private HandlerMapping() {}
	
	//매핑 모음
	private static Map<String, ComController> map = new HashMap<String, ComController>();
	
	/**
	 * HandlerMapping 객체를 생성하는 메소드
	 * @desc 1. HandlerMapping 객체가 없으면 생성하고, 있으면 해당 객체 공유
	 * 		 2. 요청과 컨트롤러를 담는 map 생성
	 * @param request 요청
	 * @return HandlerMapping 
	 */
	public static HandlerMapping getInstance() {
		if(handlerMapping == null) {
			handlerMapping = new HandlerMapping();
		}
		
		/* 메인 화면 */
		map.put("00", Cmm1000Controller.getInstance());
		
		/* 회원 화면 */
		map.put("view.usr.usr1000.Usr1000View", Usr1000Controller.getInstance());
		map.put("view.usr.usr1000.Usr1001View", Usr1000Controller.getInstance());
		map.put("view.usr.usr1000.Usr1002View", Usr1000Controller.getInstance());
		map.put("view.usr.usr1000.Usr1003View", Usr1000Controller.getInstance());
		
		/* 회원 조회, 등록, 수정, 삭제 */
		map.put("selectUsr1000", Usr1000Controller.getInstance());
		map.put("insertUsr1001", Usr1000Controller.getInstance());
		map.put("updateUsr1002", Usr1000Controller.getInstance());
		map.put("deleteUsr1003", Usr1000Controller.getInstance());
		
		/* 사물함 화면 */
		map.put("view.lck.lck1000.Lck1000View", Lck1000Controller.getInstance());
		map.put("view.lck.lck1000.Lck1001View", Lck1000Controller.getInstance());
		map.put("view.lck.lck1000.Lck1002View", Lck1000Controller.getInstance());
		map.put("view.lck.lck1000.Lck1003View", Lck1000Controller.getInstance());
		
		/* 사물함 조회, 등록, 수정, 삭제 */
		map.put("selectLck1000", Lck1000Controller.getInstance());
		map.put("insertLck1001", Lck1000Controller.getInstance());
		map.put("updateLck1002", Lck1000Controller.getInstance());
		map.put("deleteLck1003", Lck1000Controller.getInstance());
		
		/* 통계 화면 */
		map.put("view.cht.cht1000.Cht1000View", Cht1000Controller.getInstance());
		map.put("view.cht.cht1000.Cht1001View", Cht1000Controller.getInstance());
		
		/* 통계 회원 수, 만료/임박 회원 수, 회원 목록 */
		map.put("countCht1000", Cht1000Controller.getInstance());
		map.put("countCht1000Stt", Cht1000Controller.getInstance());
		map.put("selectCht1001List",Cht1000Controller.getInstance());
		
		return handlerMapping;
	}
	
	/**
	 * 요청을 받아서 컨트롤러 선택
	 * @desc HandlerMapping에 요청에 맞는 컨트롤러 생성
	 * 
	 * @param request 요청
	 * @return HandlerMapping에 매핑모음 중 요청에 맞는 컨트롤러 반환, ComController는 Controller의 공통 인터페이스
	 */
	public static ComController selectController(String request) {
		return HandlerMapping.map.get(request);
	}

}
