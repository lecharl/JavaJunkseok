package lck.lck1000.web;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ComController;

import lck.lck1000.service.Lck1000Service;
import lck.lck1000.service.impl.Lck1000ServiceImpl;
import usr.usr1000.service.Usr1000Service;
import usr.usr1000.service.impl.Usr1000ServiceImpl;
/**
 * @Class Name : Lck1000Controller.java
 * @Description : Lck1000Controller Controller class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Lck1000Controller implements ComController {
	
	private Lck1000Service lck1000Service = new Lck1000ServiceImpl();
	private Usr1000Service usr1000Service = new Usr1000ServiceImpl();
	//날짜 포맷 2가지
	SimpleDateFormat yMDFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//날짜
	Calendar nowCal;
	Calendar exCal;

	//사물함 조회
	public Map<String, String> selectLck1000(Map<String, String> inputMap) {
		LinkedHashMap<String, String> map = null;
		String input = inputMap.get("input");
		try {
			//사물함번호 : 길이가 1~2인 문자열을 입력했을 경우
			if(1 <= input.length() && input.length() <= 2) {
				//1~99를 입력했을 경우
				if(1 <= Integer.valueOf(input) && Integer.valueOf(input) <= 99) {
					map = new LinkedHashMap<String, String>();
					map = (LinkedHashMap<String, String>) lck1000Service.selectLck1000ByNo(input);
				}
				//나머지(id 포함)
			}else {
				map = new LinkedHashMap<String, String>();
				map = (LinkedHashMap<String, String>) lck1000Service.selectLck1000ById(input);
			}
		} catch (Exception e) {
			System.out.println(">> 사물함이 존재하지 않습니다.");
			map = null;
		}
		return map;
	}
	
	//사물함 추가
	public String insertLck1001(Map<String, String> inputMap) {
		String msg = "";
		int result = 0;
		
		exCal = Calendar.getInstance();
		String input = inputMap.get("input");
		LinkedHashMap<String, String> lckMap;
		//회원 먼저 조회
		try {
			LinkedHashMap<String, String> usrMap = (LinkedHashMap<String, String>) usr1000Service.selectUsr1000(inputMap.get("input"));
			//회원의 상태가 만료면
			if("만료".equals(usrMap.get("usrStatus"))) {
				msg = "만료된 회원은 사물함을 등록할 수 없습니다.";
			//회원의 상태가 만료가 아니면(정상/임박)
			}else {
				//lck 조회(입력한 id로 배정된 사물함이 있는지 확인)
				try {
					lckMap = (LinkedHashMap<String, String>) lck1000Service.selectLck1000ById(input);
					//있는데	
					nowCal = Calendar.getInstance();	//현재
					Date exDate = yMDFormat.parse(lckMap.get("lckExpireDate"));
					exCal.setTime(exDate);	//만료일자
//					//만료일자 <= 현재날짜 -> 업뎃**하고 -> 배정
					if(exCal.getTime().compareTo(nowCal.getTime()) != 1){
						lckMap.put("usrId", "");
						//이 업뎃한 건(텅빈 사물함) 다시 저장
						result = lck1000Service.insertLck1001(inputMap, lckMap);	//id만 날리고
					}else{
						msg = "현재 "+lckMap.get("lckNo")+"번에 배정되어 있습니다. 다른 ID를 입력하세요.";
					}
				}catch (Exception e) {
					//lckMap == null 없으면 -> 배정
					System.out.println("select해봤는데 없대~~ 추가가능~~");
//					e.printStackTrace();
					result = lck1000Service.insertLck1001(inputMap);	//id만 날리고
				}
			}
		} catch (Exception e) {
			msg = ">> 존재하지 않는 회원입니다.";
//			e.printStackTrace();
		}
		if(result == -1) {
			msg = ">> 사물함 등록에 실패했습니다.";
		}else if(result == 1) {
			msg = ">> 사물함 등록에 성공했습니다.";
		}
		return msg;
	}
	
	
	
	//사물함 수정
//	public String updateLck1002(List<String> newList, String input) {
//		int result = 0; 
//		result = lck1000Service.updateLck1002(newList, input);
//		String msg = "";
//		//나중에 삼항연산자로 수정~~~~~~~~~~~~
//		if(result == 4) {
//			msg = "사물함이 성공적으로 수정되었습니다.";
//		}else {
//			msg = result+"사물함을 수정하는 데 실패하였습니다.";
//		}
//		return msg;
//	}
	
	//사물함 삭제
	public String deleteLck1003(Map<String, String> inputMap) {
		String msg = "";
		int result = 0; 
		
		//no조회
		LinkedHashMap<String, String> map = null; 
		try {
			map = (LinkedHashMap<String, String>) selectLck1000(inputMap);
			System.out.println(map);
			//null이 아니면
			//map의 usrId를 공백""과 비교
			//id가 배정되지 않은 아예 비어있는 사물함이라면
			if("".equals(map.get("usrId"))) {
				msg = ">> 비어있는 사물함입니다.";
			}else {
				//배정된 사물함이면
				try {
					result = lck1000Service.deleteLck1003(map.get("lckNo"));
				}catch (Exception e) {
					System.out.println("lck컨- delete중");
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			// null이면
			msg = ">> 사물함 번호를 정확하게 입력하세요.";
		}
		
		if(result == -1) {
			msg = "사물함 삭제에 실패했습니다.";
		}else if(result == 1) {
			msg = "사물함 삭제에 성공했습니다.";
		}
		return msg;
	}


	@Override
	public void selectView(String request) {
		try {
			Class<?> cls = Class.forName(request);
			Object obj = cls.newInstance();
			Method m = cls.getDeclaredMethod("callView");
			m.invoke(obj);
		} catch (ClassNotFoundException e) {
			System.out.println("lck컨 :: 뷰 클래스 못찾음");
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

	@Override
	public Object selectMethod(String request, Map<String, String> inputMap) {
		Object obj = new Lck1000Controller();
		Object newObj = null;
		try {
			Class<?> cls = Class.forName(obj.getClass().getName());
			Method m = cls.getMethod(request, Map.class);
			newObj = m.invoke(obj, inputMap);
		} catch (ClassNotFoundException e) {
			System.out.println("lck컨트롤 :: 클래스 못찾음");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println("lck컨트롤 :: 메소드 못찾음sssss");
			e.printStackTrace();
		} catch (SecurityException e) {
			System.out.println("lck컨트롤 :: 보안??");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.getTargetException().printStackTrace();
			System.out.println("lck컨트롤 :: 존재하지 않는 회원입니다.");
		}
		return newObj;
	}
}
