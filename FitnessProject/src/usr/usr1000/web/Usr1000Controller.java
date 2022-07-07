package usr.usr1000.web;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ComController;

import usr.usr1000.service.Usr1000Service;
import usr.usr1000.service.impl.Usr1000ServiceImpl;
/**
 * @Class Name : Usr1000Controller.java
 * @Description : Usr1000Controller Controller class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Usr1000Controller implements ComController {
	
	/* 싱글톤 */
	private static Usr1000Controller usr1000Controller;
	private Usr1000Controller() {}
	
	public static Usr1000Controller getInstance() {
		if(usr1000Controller == null) {
			usr1000Controller = new Usr1000Controller();
		}
		return usr1000Controller;
	}

	private Usr1000Service usr1000Service = new Usr1000ServiceImpl();
	
	//회원 조회
	public Map<String, String> selectUsr1000(Map<String, String> inputMap) {
		LinkedHashMap<String, String> map = null;
		try {
			map = new LinkedHashMap<String, String>();
			map = (LinkedHashMap<String, String>) usr1000Service.selectUsr1000(inputMap.get("input"));
		} catch (Exception e) {
			//조회한 vo가 없으면 
			System.out.println(">> 존재하지 않는 회원입니다.");
			map = null;
		}
		return map;
	}
	
	//회원 추가
	public String insertUsr1001(Map<String, String> inputMap) {
		String msg = "";
		int result = 0;
		
		//회원 먼저 조회
		try {
			LinkedHashMap<String, String> usrMap = (LinkedHashMap<String, String>) usr1000Service.selectUsr1000(inputMap.get("input"));
			msg = ">> 이미 존재하는 회원입니다.";
		} catch (Exception e1) {
			// 회원 없음
			try {
				result = usr1000Service.insertUsr1001(inputMap);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("** 회원을 등록하는 과정에서 오류가 났습니다. 다시 시도해주세요.");
			}
		}
		
		if(result == -1) {
			msg = ">> 회원 등록에 실패했습니다.";
		}else if(result == 1) {
			msg = ">> 회원 등록에 성공했습니다.";
		}
		return msg;	
	}
	
	//회원 수정
	public String updateUsr1002(List<String> newList, String usrId)  throws Exception{
		int result = usr1000Service.updateUsr1002(newList, usrId);
		//수정 성공하면(7 반환)
		return (result == 7)? "회원 수정에 성공하였습니다." : "회원 수정에 실패하였습니다.";
	}

	//회원 삭제
	public String deleteUsr1003(Map<String, String> inputMap) {
		String msg = "";
		int result = 0;
		
		//회원 먼저 조회
		try {
			LinkedHashMap<String, String> usrMap = (LinkedHashMap<String, String>) usr1000Service.selectUsr1000(inputMap.get("input"));
			result = usr1000Service.deleteUsr1003(inputMap.get("input"));
		} catch (Exception e1) {
			// 회원 없음, usrMap == null
			msg = ">> 존재하지 않는 회원입니다.";
		}
		
		if(result == -1) {
			msg = ">> 회원 삭제에 실패했습니다.";
		}else if(result == 1) {
			msg = ">> 회원 삭제에 성공했습니다.";
		}
		return msg;	
		
	}

	//뷰
	@Override
	public void selectView(String request) {
		try {
			Class<?> cls = Class.forName(request);
			Object obj = cls.newInstance();
			Method m = cls.getDeclaredMethod("callView");
			m.invoke(obj);
		} catch (ClassNotFoundException e) {
			System.out.println("usr컨 :: 뷰 클래스 못찾음");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			System.out.println("usr 컨 : invo");
			e.getTargetException().printStackTrace();
		}
	}

	//기능
	@Override
	public Object selectMethod(String request, Map<String, String> inputMap) {
		Object obj = new Usr1000Controller();
		Object newObj = null;
		try {
			Class<?> cls = Class.forName(obj.getClass().getName());
			Method m = cls.getMethod(request, Map.class);
			newObj = m.invoke(obj, inputMap);
		} catch (ClassNotFoundException e) {
			System.out.println("usr컨트롤 :: 클래스 못찾음");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println("usr컨트롤 :: 메소드 못찾음sssss");
			e.printStackTrace();
		} catch (SecurityException e) {
			System.out.println("usr컨트롤 :: 보안??");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.getTargetException().printStackTrace();
			System.out.println("usr컨트롤 :: 존재하지 않는 회원입니다.");
		}
		return newObj;		
	}


}
