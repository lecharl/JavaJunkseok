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
	
//	private Map<String, ComController> mappingMap = new HashMap<String, ComController>();
	static HandlerMapping handlerMapping = HandlerMapping.getInstance();
	
//	public FrontController(String request, Map<String, String> input) {
//		handlerMapping = HandlerMapping.getInstance(request, input);
//		handlerMapping.selectController(request, input);
//	}
//	
//	public FrontController(String request) {
//		handlerMapping = HandlerMapping.getInstance(request);
//		handlerMapping.selectController(request);
//		List<String> newList = HandlerMapping.mappingList;
//		Iterator<String> it = newList.iterator();
//		while(it.hasNext()) {
//			String targetMapping = it.next();
//			char headMapping = targetMapping.charAt(0);
//			switch (headMapping) {
//			case '1':
//				mappingMap.put(targetMapping, new Usr1000Controller());
//				break;
//			case '2':
//				mappingMap.put(targetMapping, new Lck1000Controller());
//				break;
//			case '3':
//				mappingMap.put(targetMapping, new Cht1000Controller());
//				break;
//			default:
//				mappingMap.put(targetMapping, new Cmm1000Controller());
//				break;
//			}
//		}
//	}
	
	//
	public static ComController selectMapping(String request) {
//		System.out.println("FC111 :: selectMapping");
//		System.out.println("FC :: selectMapping");
		return handlerMapping.selectController(request);
	}
	
	
	
}
