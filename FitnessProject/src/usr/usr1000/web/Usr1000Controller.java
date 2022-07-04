package usr.usr1000.web;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ComController;

import usr.usr1000.service.Usr1000Service;
import usr.usr1000.service.impl.Usr1000ServiceImpl;
import usr.usr1000.vo.Usr1000Vo;
import view.usr.usr1000.Usr1000View;

public class Usr1000Controller implements ComController {

	private Usr1000Service usr1000Service = new Usr1000ServiceImpl();
//	//날짜 포맷 2가지
//	SimpleDateFormat yMDFormat = new SimpleDateFormat("yyyy-MM-dd");
//	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	//날짜
//	Calendar nowCal;
	
	//회원 조회
	public Map<String, String> selectUsr1000(Map<String, String> inputMap) {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		try {
			map = (LinkedHashMap<String, String>) usr1000Service.selectUsr1000(inputMap.get("usrId"));
		} catch (Exception e) {
			//조회한 vo가 없으면 
			System.out.println("존재하지 않는 회원입니다.");
			map = null;
		}
		return map;
	}
	
	//회원 추가
	public String insertUsr1001(Map<String, String> inputMap) {
		
		int result = 0;
		try {
			result = usr1000Service.insertUsr1001(inputMap);
		} catch (Exception e) {
			System.out.println("usr컨: insert 0????");
			e.printStackTrace();
		}
		//추가 성공하면(1 반환)
		//추가 실패하면(-1 반환)
		return (result == 1)? result+"회원 등록에 성공하였습니다." : result+"회원 등록에 실패하였습니다.";
	}
	
	//회원 수정
	public String updateUsr1002(List<String> newList, String usrId)  throws Exception{
		int result = usr1000Service.updateUsr1002(newList, usrId);
		//수정 성공하면(7 반환)
		return (result == 7)? "회원 수정에 성공하였습니다." : "회원 수정에 실패하였습니다.";
	}

	//회원 삭제
	public String deleteUsr1003(Map<String, String> inputMap) {
		int result = 0;
		try {
			result = usr1000Service.deleteUsr1003(inputMap);
		} catch (Exception e) {
			System.out.println("usr컨: delete 0???");
			e.printStackTrace();
		}
		//삭제 성공하면(1 반환)
		//삭제 실패하면(-1 반환)
		return (result == 1)? result+"회원 삭제에 성공하였습니다." : result+"회원 삭제에 실패하였습니다.";
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
//			e.printStackTrace();
		}
	}

	//기능
	@Override
	public Object selectMethod(String request, Map<String, String> inputMap) {
		Object obj = new Usr1000Controller();
		Object newObj = null;
		try {
			Class<?> cls = Class.forName(obj.getClass().getName());
//			Method m = cls.getDeclaredMethod(request, String.class);
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
//			e.printStackTrace();
		}
		return newObj;		
	}

	//조회, 삭제
//	@Override
//	public Object selectMethod(String request, String input) {
//		Object obj = new Usr1000Controller();
//		Object newObj = null;
//		try {
//			Class<?> cls = Class.forName(obj.getClass().getName());
////			Method m = cls.getDeclaredMethod(request, String.class);
//			Method m = cls.getMethod(request, String.class);
//			newObj = m.invoke(obj, input);
//		} catch (ClassNotFoundException e) {
//			System.out.println("usr컨트롤 :: 클래스 못찾음");
//			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			System.out.println("usr컨트롤 :: 메소드 못찾음");
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			System.out.println("usr컨트롤 :: 보안??");
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			System.out.println("usr컨트롤 :: 존재하지 않는 회원입니다.");
////			e.printStackTrace();
//		}
//		return newObj;
//	}

}
