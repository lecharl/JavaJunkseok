package lck.lck1000.service.impl;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import lck.lck1000.dao.Lck1000Dao;
import lck.lck1000.dao.impl.Lck1000DaoImpl;
import lck.lck1000.service.Lck1000Service;
import lck.lck1000.vo.Lck1000Vo;
import usr.usr1000.dao.Usr1000Dao;
import usr.usr1000.dao.impl.Usr1000DaoImpl;
/**
 * @Class Name : Lck1000ServiceImpl.java
 * @Description : Lck1000ServiceImpl Service class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Lck1000ServiceImpl implements Lck1000Service{
	
	private Lck1000Dao lck1000Dao = Lck1000DaoImpl.getInstance();
	private Usr1000Dao usr1000Dao = Usr1000DaoImpl.getInstance();
	//날짜 포맷 2가지
	SimpleDateFormat yMDFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//날짜
	Calendar nowCal;
	Calendar exCal;
	//입력
	Scanner sc;

	//사물함 조회
	@Override
	public Map<String, String> selectLck1000ByNo(String input) throws Exception{
		Lck1000Vo returnVo = null;
		try {
			returnVo = lck1000Dao.selectLck1000ByNo(input);
		} catch (Exception e) {
			System.out.println("lck서비스 : 조회byNo");
			e.printStackTrace();
			return null;
		}
		nowCal = Calendar.getInstance();	//현재
		exCal = Calendar.getInstance();
		Date exDate = yMDFormat.parse(returnVo.getLckExpireDate());
		exCal.setTime(exDate);	//만료일자
		//만료일자 <= 현재날짜 -> 업뎃**하고
		if(exCal.getTime().compareTo(nowCal.getTime()) != 1) {
			returnVo.setUsrId("");
		}
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		Field[] fieldArr = returnVo.getClass().getDeclaredFields();
		for (Field field : fieldArr) {
			field.setAccessible(true);
			String key = field.getName();
			String val = "";
			try {
				val = (String) field.get(returnVo);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				System.out.println("lck-조회-필드");
				e.printStackTrace();
			}
			map.put(key, val);
		}
		return map;
	}

	@Override
	public Map<String, String> selectLck1000ById(String input) throws Exception{
		Lck1000Vo returnVo = null;
		try {
			returnVo = lck1000Dao.selectLck1000ById(input);
		} catch (Exception e) {
			System.out.println("lck서비스 : 조회byID");
			e.printStackTrace();
			return null;
		}
		nowCal = Calendar.getInstance();	//현재
		exCal = Calendar.getInstance();
		Date exDate = yMDFormat.parse(returnVo.getLckExpireDate());
		exCal.setTime(exDate);	//만료일자
		//만료일자 <= 현재날짜 -> 업뎃**하고
		if(exCal.getTime().compareTo(nowCal.getTime()) != 1) {
			returnVo.setUsrId("");
		}
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		Field[] fieldArr = returnVo.getClass().getDeclaredFields();
		for (Field field : fieldArr) {
			field.setAccessible(true);
			String key = field.getName();
			String val = "";
			try {
				val = (String) field.get(returnVo);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				System.out.println("lck-조회-필드");
				e.printStackTrace();
			}
			map.put(key, val);
		}
		return map;
	}

	//사물함 추가 <- 사물함 조회 후
	@Override
	public int insertLck1001(Map<String, String> inputMap, Map<String, String> oldMap) throws Exception{
		System.out.println("\n>> 회원 ID : "+inputMap.get("input"));
		//입력받음
		sc = new Scanner(System.in);
		System.out.print(">> 사물함 번호(1~99) : ");
		String inputLckNo = sc.nextLine();
		System.out.print(">> 만료 일자(yyyy-MM-dd) : ");
		String inputLckExpireDate = sc.nextLine();
		
		try {
			//숫자 유효성체크 통과하면 
			int intLckNo = Integer.valueOf(inputLckNo);
			//유효성체크 통과하면
			if((1 <= intLckNo && intLckNo <= 99) && isDateFormat(inputLckExpireDate, yMDFormat)) {
				//입력한 만료일자가 현재날짜보다 이전일 때 -1
				nowCal = Calendar.getInstance();
				exCal = Calendar.getInstance();
				
				Date exDate = yMDFormat.parse(inputLckExpireDate);
				exCal.setTime(exDate);	//입력한 만료일자
				nowCal = Calendar.getInstance();	//현재
				
				//만료일자 <= 현재날짜 -> -1
				if(exCal.getTime().compareTo(nowCal.getTime()) != 1){
					System.out.println("현재 날짜보다 큰 날짜를 입력하세요");
					return -1;
				}else {
					//만료일자 > 현재날짜
					//더블체크
					if(CheckLck1004("등록")) {
						//oldMap 업뎃
						Lck1000Vo returnOldVo = new Lck1000Vo(oldMap.get("lckNo"), oldMap.get("input"), oldMap.get("LckExpireDate"));
						int result = lck1000Dao.insertLck1001(returnOldVo);
						if(result != 1) {
							System.out.println("result oldMap 못바꿈 : "+result);
							return -1;
						}
						Lck1000Vo returnVo = new Lck1000Vo(inputLckNo, inputMap.get("input"), inputLckExpireDate);
						//사물함 추가에 실패하면 -1, 성공하면 1
						return lck1000Dao.insertLck1001(returnVo);
					}else {
						return -1;
					}
				}
			}else {
				//유효성체크 통과 못하면
				System.out.println(">> 형식에 맞춰 입력하세요.");
				return -1;
			}
			
		} catch (Exception e) {
			//숫자 유효성 체크 통과 못하면
			System.out.println(">> 형식에 맞춰 입력하세요.");
			return -1;
		}
	}
	
	
	@Override
	public int insertLck1001(Map<String, String> inputMap) throws Exception {
		System.out.println("\n>> 회원 ID : "+inputMap.get("input"));
		//입력받음
		sc = new Scanner(System.in);
		System.out.print(">> 사물함 번호(1~99) : ");
		String inputLckNo = sc.nextLine();
		System.out.print(">> 만료 일자(yyyy-MM-dd) : ");
		String inputLckExpireDate = sc.nextLine();
		
		try {
			//숫자 유효성체크 통과하면 
			int intLckNo = Integer.valueOf(inputLckNo);
			//유효성체크 통과하면
			if((1 <= intLckNo && intLckNo <= 99) && isDateFormat(inputLckExpireDate, yMDFormat) ) {
				//입력한 만료일자가 현재날짜보다 이전일 때 -1
				nowCal = Calendar.getInstance();
				exCal = Calendar.getInstance();
				
				Date exDate = yMDFormat.parse(inputLckExpireDate);
				exCal.setTime(exDate);	//입력한 만료일자
				nowCal = Calendar.getInstance();	//현재
				
				//만료일자 <= 현재날짜 -> -1
				if(exCal.getTime().compareTo(nowCal.getTime()) != 1){
					System.out.println("현재 날짜보다 큰 날짜를 입력하세요");
					return -1;
				}else {
					//만료일자 > 현재날짜
					//더블체크
					if(CheckLck1004("등록")) {
						Lck1000Vo returnVo = new Lck1000Vo(inputLckNo, inputMap.get("input"), inputLckExpireDate);
						//사물함 추가에 실패하면 -1, 성공하면 1
						return lck1000Dao.insertLck1001(returnVo);
					}else {
						return -1;
					}
				}
			}else {
				//유효성체크 통과 못하면
				System.out.println("형식에 맞춰 입력하세요.");
				return -1;
			}
		}catch (Exception e) {
			//숫자 유효성 체크 통과 못하면
			System.out.println("숫자를 입력하세요.");
			return -1;
		}
		
	}

	
	
	//사물함 수정 <- id조회하고 사물함 조회 후
	@Override
	public int updateLck1002(Map<String, String> lckMap, String input) {
		
		sc = new Scanner(System.in);
		//따로 변수에 저장
		Map<String, String> oldMap = new LinkedHashMap<String, String>();
		for (Entry<String, String> ele : lckMap.entrySet()) {
			oldMap.put(ele.getKey(), ele.getValue());
		}
		
		//입력한 값이 회원 ID냐, 사물함 번호냐
		//사물함번호 : 길이가 1~2인 문자열을 입력했을 경우 == 사물함번호 1~99 자동으로
		if(1 <= input.length() && input.length() <= 2) {
			System.out.println("- 사물함 번호 : "+lckMap.get("lckNo"));
			System.out.print("- 회원 ID : "+lckMap.get("usrId")+" >> ");
			String inputId = sc.nextLine();
			System.out.print("- 만료 일자 : "+lckMap.get("lckExpireDate")+" >> ");
			String inputExtDate = sc.nextLine();
			
			//공백입력 예외 때문에 회원조회와 유효성검사 전에 Map에 담고 cmpInput1005()을 한다.
			LinkedHashMap<String, String> newMap = new LinkedHashMap<String, String>();
			newMap.put("lckNo", lckMap.get("lckNo"));
			newMap.put("usrId", inputId);
			newMap.put("lckExpireDate", inputExtDate);
			
			//수정하지 않을 경우 기존의 값으로 대체
			Map<String, String> realMap = cmpInput1005(lckMap, newMap);
			
			//회원조회
			try {
				usr1000Dao.selectUsr1000(realMap.get("usrId"));
				
				//유효성 검사: 만료 일자
				String rmExpDate = realMap.get("lckExpireDate");
				if(isDateFormat(rmExpDate, yMDFormat)) {
					//입력한 만료일자가 현재날짜보다 이전일 때 -1
					nowCal = Calendar.getInstance();
					exCal = Calendar.getInstance();
					
					Date exDate = yMDFormat.parse(rmExpDate);
					exCal.setTime(exDate);	//입력한 만료일자
					nowCal = Calendar.getInstance();	//현재
					
					//만료일자 <= 현재날짜 -> -1
					if(exCal.getTime().compareTo(nowCal.getTime()) != 1){
						System.out.println("현재 날짜보다 큰 날짜를 입력하세요");
						return -1;
					}else {
						//만료일자 > 현재날짜
						//더블체크
						if(CheckLck1004("수정")) {
							//새롭게 저장할 vo
							Lck1000Vo returnVo = new Lck1000Vo(realMap.get("lckNo"), realMap.get("usrId"), rmExpDate);
							//이전걸 수정할 vo (수정할 lckVo의 usrId == ""로 만들기 위해)
							Lck1000Vo oldVo = new Lck1000Vo(oldMap.get("lckNo"), oldMap.get("usrId"), oldMap.get("lckExpireDate"));
							//사물함 수정에 실패하면 -1, 성공하면 1
							return lck1000Dao.updateLck1002(returnVo, oldVo);
						}else {
							return -1;
						}
					}
				}else {
					System.out.println(">> 만료 일자를 정확히 입력하세요.");
				}
				
			} catch (Exception e) {
				//null 이면
				System.out.println("존재하지 않는 회원입니다.");
//				e.printStackTrace();
			}
			
		}else {
			//나머지(id)
			System.out.println("- 회원 ID : "+lckMap.get("usrId"));
			System.out.print("- 사물함 번호 : "+lckMap.get("lckNo")+" >> ");
			String inputNo = sc.nextLine();
			System.out.print("- 만료 일자 : "+lckMap.get("lckExpireDate")+" >> ");
			String inputExtDate = sc.nextLine();
			
			//공백입력 예외 때문에 유효성검사 전에 Map에 담고 cmpInput1005()을 한다.
			LinkedHashMap<String, String> newMap = new LinkedHashMap<String, String>();
			newMap.put("lckNo", inputNo);
			newMap.put("usrId", lckMap.get("usrId"));
			newMap.put("lckExpireDate", inputExtDate);
			
			//수정하지 않을 경우 기존의 값으로 대체
			Map<String, String> realMap = cmpInput1005(lckMap, newMap);

			
			//유효성 검사: no
			try {
				int rmNo = (int) Integer.valueOf((realMap.get("lckNo")));
				
				if(1 <= rmNo && rmNo <= 99) {
					//유효성 검사: 만료 일자, no
					String rmExpDate = realMap.get("lckExpireDate");
					
					if(isDateFormat(rmExpDate, yMDFormat)) {
						//입력한 만료일자가 현재날짜보다 이전일 때 -1
						nowCal = Calendar.getInstance();
						exCal = Calendar.getInstance();
						
						Date exDate = yMDFormat.parse(rmExpDate);
						exCal.setTime(exDate);	//입력한 만료일자
						nowCal = Calendar.getInstance();	//현재
						
						//만료일자 <= 현재날짜 -> -1
						if(exCal.getTime().compareTo(nowCal.getTime()) != 1){
							System.out.println("현재 날짜보다 큰 날짜를 입력하세요");
							return -1;
						}else {
							//만료일자 > 현재날짜
							//더블체크
							if(CheckLck1004("수정")) {
								Lck1000Vo returnVo = new Lck1000Vo(realMap.get("lckNo"), realMap.get("usrId"), rmExpDate);
								//이전걸 수정할 vo (수정할 lckVo의 usrId == ""로 만들기 위해)
								Lck1000Vo oldVo = new Lck1000Vo(oldMap.get("lckNo"), oldMap.get("usrId"), oldMap.get("lckExpireDate"));
								//사물함 수정에 실패하면 -1, 성공하면 1
								return lck1000Dao.updateLck1002(returnVo, oldVo);
							}else {
								return -1;
							}
						}
					}else {
						System.out.println(">> 만료 일자를 정확히 입력하세요.");
					}
					
				}else {
					System.out.println(">> 1~99 에 해당하는 사물함 번호를 입력하세요.");
				}
			} catch (NumberFormatException e) {
				//no를 숫자로 입력하지 않았을 경우
				System.out.println(">> 사물함 번호에 숫자를 입력하세요.");
			} catch (Exception e) {
				System.out.println("?????????");
				e.printStackTrace();
			}
		}
		return 0;
	}
	


	//사물함 삭제 <- 사물함 조회 후
	@Override
	public int deleteLck1003(String lckNo) throws Exception {
		//사물함 조회, lckNo로 조회
		Lck1000Vo returnVo = lck1000Dao.selectLck1000ByNo(lckNo);
//		더블 체크
		if(CheckLck1004("삭제")) {
			//더블체크 통과하면 사물함 삭제
			return lck1000Dao.deleteLck1003(returnVo);
		}else {
			return -1;
		}
	}

    /**
     * 입력받은 문자열이 날짜형식으로 변환이 가능한지 확인한다.
     *
     * @param str    날짜형식 변환 가능여부 확인 대상
     * @param dateFormat 비교할 날짜 형식
     * @return
     */
    public boolean isDateFormat(String str, SimpleDateFormat dateFormat) {
        try {
            //  parse()에 잘못된 값이 들어오면 Exception을 리턴하도록 setLenient(false) 설정
        	dateFormat.setLenient(false);
            // 대상 인자 검증
        	dateFormat.parse(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

  //더블 체크
  	public boolean CheckLck1004(String str) {
  		sc = new Scanner(System.in);
  		System.out.print("정말로 "+str+"하시겠습니까? (예: Y / 아니요: 아무 키) >> ");
  		String inputYn = sc.nextLine();
  		return ("Y".equalsIgnoreCase(inputYn))? true : false;
  	}

  //새로 입력한 값이 ""이냐 아니냐에 따른 값 저장
	private Map<String, String> cmpInput1005(Map<String, String> lckMap, LinkedHashMap<String, String> newMap) {
		for (Entry<String, String> ele : newMap.entrySet()) {
			if(!("".equals(ele.getValue()))) {
				lckMap.put(ele.getKey(), ele.getValue());
			}
		}
		return lckMap;
	}
	
	

}
