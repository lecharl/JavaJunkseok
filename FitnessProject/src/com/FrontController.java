package com;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cht.cht1000.web.Cht1000Controller;
import cmm.cmm1000.web.Cmm1000Controller;
import lck.lck1000.web.Lck1000Controller;
import usr.usr1000.web.Usr1000Controller;

public class FrontController {
	
	private Map<String, ComController> mappingMap = new HashMap<String, ComController>();
	
	public FrontController() {
		List<String> newList = HandlerMapping.mappingList;
		Iterator<String> it = newList.iterator();
		while(it.hasNext()) {
			String targetMapping = it.next();
			char headMapping = targetMapping.charAt(0);
			switch (headMapping) {
			case '1':
				mappingMap.put(targetMapping, new Usr1000Controller());
				break;
			case '2':
				mappingMap.put(targetMapping, new Lck1000Controller());
				break;
			case '3':
				mappingMap.put(targetMapping, new Cht1000Controller());
				break;
			default:
				mappingMap.put(targetMapping, new Cmm1000Controller());
				break;
			}
		}
	}
	
	//
	public void selectController(String request) {
//		String headRequest = String.valueOf(request.charAt(0));
		ComController controller = mappingMap.get(request);
		controller.selectView(request);
	}
	
	public List<String> selectMapList() {
		return HandlerMapping.mappingList;
	}
	
	
//	//HandlerMapping 에서 매치되면 해당 컨트롤러 가져오기
//	private HandlerMapping hMapping;
//	public FrontController() {
//		hMapping = new HandlerMapping();
//	}
//	
//	//입력한 번호가 map에 key로 존재하는지 확인한다.
//	//있으면 해당 컨트롤러 반환, 없으면 null? 
//	public Controller getMatchedMapping(String key) {
//		if(hMapping.hndlMap.containsKey(key)) {
//			return hMapping.hndlMap.get(key);
//		}else {
//			return null;
//		}
//	}
}
