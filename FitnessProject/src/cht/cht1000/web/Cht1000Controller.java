package cht.cht1000.web;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import com.ComController;

import cht.cht1000.service.Cht1000Service;
import cht.cht1000.service.impl.Cht1000ServiceImpl;
/**
 * @Class Name : Cht1000Controller.java
 * @Description : Cht1000Controller Controller class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Cht1000Controller implements ComController {
	
	private Cht1000Service cht1000Service = new Cht1000ServiceImpl();

	//회원 수
	public int countCht1000() {
		return cht1000Service.countCht1000();
	}	
	
	//임박, 만료 회원 수
	public int countCht1000Stt(String status)  {
		int result = 0;
		try {
			result = cht1000Service.countCht1000Stt(status);
		} catch (Exception e) {
			System.out.println("회원 수를 체크하는 데 오류가 발생했습니다.");
//			e.printStackTrace();
		}
		return result;
	}
	
	//회원 목록
	public List<Map<String, String>> selectCht1001List() {
		List<Map<String, String>> returnList = null;
		try {
			returnList = cht1000Service.selectCht1001List();
		} catch (Exception e) {
			System.out.println("회원 목록 조회에 오류가 생겼습니다.");
		}
		return returnList;
	}

	@Override
	public void selectView(String request) {
		try {
			Class<?> cls = Class.forName(request);
			Object obj = cls.newInstance();
			Method m = cls.getDeclaredMethod("callView");
			m.invoke(obj);
		} catch (ClassNotFoundException e) {
			System.out.println("cht컨 :: 뷰 클래스 못찾음");
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
			System.out.println("cht컨 : invo");
			e.getTargetException().printStackTrace();
//			e.printStackTrace();
		}
		
	}

	@Override
	public Object selectMethod(String request, Map<String, String> inputMap) {
		Object obj = new Cht1000Controller();
		Object newObj = null;
		try {
			Class<?> cls = Class.forName(obj.getClass().getName());
//			Method m = cls.getDeclaredMethod(request, String.class);
			Method m = cls.getMethod(request, Map.class);
			newObj = m.invoke(obj, inputMap);
		} catch (ClassNotFoundException e) {
			System.out.println("cht컨트롤 :: 클래스 못찾음");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println("cht컨트롤 :: 메소드 못찾음sssss");
			e.printStackTrace();
		} catch (SecurityException e) {
			System.out.println("cht컨트롤 :: 보안??");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.getTargetException().printStackTrace();
			System.out.println("cht컨트롤 :: 존재하지 않는 사물입니다.");
//			e.printStackTrace();
		}
		return newObj;		
	}
	
	public Object selectMethod(String request, String stt) {
		Object obj = new Cht1000Controller();
		Object newObj = null;
		try {
			Class<?> cls = Class.forName(obj.getClass().getName());
			Method m = cls.getMethod(request, String.class);
			newObj = m.invoke(obj, stt);
		} catch (ClassNotFoundException e) {
			System.out.println("cht컨트롤 :: 클래스 못찾음");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println("cht컨트롤 :: 메소드 못찾음sssss");
			e.printStackTrace();
		} catch (SecurityException e) {
			System.out.println("cht컨트롤 :: 보안??");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.getTargetException().printStackTrace();
			System.out.println("cht컨트롤 :: 존재하지 않는 사뭃입니다.");
//			e.printStackTrace();
		}
		return newObj;		
	}
	
	public Object selectMethod(String request) {
		Object obj = new Cht1000Controller();
		Object newObj = null;
		try {
			Class<?> cls = Class.forName(obj.getClass().getName());
			Method m = cls.getMethod(request);
			newObj = m.invoke(obj);
		} catch (ClassNotFoundException e) {
			System.out.println("cht컨트롤 :: 클래스 못찾음");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println("cht컨트롤 :: 메소드 못찾음sssss");
			e.printStackTrace();
		} catch (SecurityException e) {
			System.out.println("cht컨트롤 :: 보안??");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.getTargetException().printStackTrace();
			System.out.println("cht컨트롤 :: 존재하지 않는 사뭃입니다.");
//			e.printStackTrace();
		}
		return newObj;		
	}

}
