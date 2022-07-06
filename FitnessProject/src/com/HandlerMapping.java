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
		map.put("00", new Cmm1000Controller());
		
		/* 회원 화면 */
		map.put("view.usr.usr1000.Usr1000View", new Usr1000Controller());
		map.put("view.usr.usr1000.Usr1001View", new Usr1000Controller());
		map.put("view.usr.usr1000.Usr1002View", new Usr1000Controller());
		map.put("view.usr.usr1000.Usr1003View", new Usr1000Controller());
		
		/* 회원 조회, 등록, 수정, 삭제 */
		map.put("selectUsr1000", new Usr1000Controller());
		map.put("insertUsr1001", new Usr1000Controller());
		map.put("updateUsr1002", new Usr1000Controller());
		map.put("deleteUsr1003", new Usr1000Controller());
		
		/* 사물함 화면 */
		map.put("view.lck.lck1000.Lck1000View", new Lck1000Controller());
		map.put("view.lck.lck1000.Lck1001View", new Lck1000Controller());
		map.put("view.lck.lck1000.Lck1002View", new Lck1000Controller());
		map.put("view.lck.lck1000.Lck1003View", new Lck1000Controller());
		
		/* 사물함 조회, 등록, 수정, 삭제 */
		map.put("selectLck1000", new Lck1000Controller());
		map.put("insertLck1001", new Lck1000Controller());
		map.put("updateLck1002", new Lck1000Controller());
		map.put("deleteLck1003", new Lck1000Controller());
		
		/* 통계 화면 */
		map.put("view.cht.cht1000.Cht1000View", new Cht1000Controller());
		map.put("view.cht.cht1000.Cht1001View", new Cht1000Controller());
		
		/* 통계 회원 수, 만료/임박 회원 수, 회원 목록 */
		map.put("countCht1000", new Cht1000Controller());
		map.put("countCht1000Stt", new Cht1000Controller());
		map.put("selectCht1001List", new Cht1000Controller());
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
