package usr.usr1000.service.impl;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import usr.usr1000.dao.Usr1000Dao;
import usr.usr1000.dao.impl.Usr1000DaoImpl;
import usr.usr1000.service.Usr1000Service;
import usr.usr1000.vo.Usr1000Vo;
/**
 * @Class Name : Usr1000ServiceImpl.java
 * @Description : Usr1000ServiceImpl Service class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Usr1000ServiceImpl implements Usr1000Service {
	
	private Usr1000Dao usr1000Dao = Usr1000DaoImpl.getInstance();
	//날짜 포맷 2가지
	SimpleDateFormat yMDFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//날짜
	Calendar nowCal;
	Calendar exCal;
	Scanner sc;
	
	//회원 조회
	@Override
	public Map<String, String> selectUsr1000(String usrId) {
		Usr1000Vo returnVo = null;
		try {
			returnVo = usr1000Dao.selectUsr1000(usrId);
		} catch (Exception e) {
			System.out.println("여기는 usr서비스 : 조회");
			e.printStackTrace();
			return null;
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
				System.out.println("usr-조회-필드");
				e.printStackTrace();
			}
			map.put(key, val);
		}
		return map;
	}

	//회원 추가 <- 회원 조회 후
	@Override
	public int insertUsr1001(Map<String, String> inputMap) throws Exception{
		
		//유효성 검사1: Id 체크
		if(validUsr1004(inputMap.get("input"))) {
			//입력 받음
			sc = new Scanner(System.in);
			System.out.println("\n>> 회원 ID : "+inputMap.get("input"));
			System.out.print(">> 회원명 : ");
			String inputName = sc.nextLine();
			System.out.print(">> 회원 성별(남/여) : ");
			String inputGender = sc.nextLine();
			System.out.print(">> 회원 연락처(000-000-0000/000-0000-0000) : ");
			String inputPhoneNum = sc.nextLine();
			System.out.print(">> 회원 주소 : ");
			String inputAddresss = sc.nextLine();
			System.out.print(">> 회원 설명 : ");
			String inputDetail = sc.nextLine();
			System.out.print(">> 만료 일자(yyyy-MM-dd) : ");
			String inputUsrExpireDate = sc.nextLine();
			
			//유효성 검사2: 성별, 연락처, 만료 일자
			if(validUsr1005(inputGender, inputPhoneNum, inputUsrExpireDate)) {
				//유효성 검사3: 입력한 만료일자가 현재날짜보다 이전일 때 -1
				nowCal = Calendar.getInstance();
				exCal = Calendar.getInstance();
				
				Date exDate = yMDFormat.parse(inputUsrExpireDate);
				exCal.setTime(exDate);	//입력한 만료일자
				nowCal = Calendar.getInstance();	//현재
				
				//만료일자 <= 현재날짜 -> -1
				if(exCal.getTime().compareTo(nowCal.getTime()) != 1){
					System.out.println(">> 현재 날짜보다 큰 날짜를 입력하세요");
					return -1;
				}else {
					//만료일자 > 현재날짜
					//더블체크
					if(CheckUsr1000("등록")) {
						LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
						map.put("usrId", inputMap.get("input"));
						map.put("usrName", inputName);
						map.put("usrGender", inputGender);
						map.put("usrPhoneNum", inputPhoneNum);
						map.put("usrAddress", inputAddresss);
						map.put("usrDetail", inputDetail);
						map.put("usrExpireDate", inputUsrExpireDate);
						Usr1000Vo returnVo = new Usr1000Vo.Builder(map.get("usrId"), map.get("usrName"), map.get("usrGender"), map.get("usrPhoneNum"), map.get("usrAddress"), map.get("usrDetail"))
								.joinDate(yMDFormat.format(nowCal.getTime()))
								.usrExpireDate(map.get("usrExpireDate"))
								.enrollTime(dateTimeFormat.format(nowCal.getTime()))
								.editTime(dateTimeFormat.format(nowCal.getTime()))
								.build();
						//회원 추가에 실패하면 -1, 성공하면 1
						return usr1000Dao.insertUsr1001(returnVo);
					}else {
						return -1;
					}
				}
			}else {
				//유효성 검사2 통과 못하면
				System.out.println(">> 성별, 연락처, 만료일자를 형식에 맞춰 입력하세요.");
				return -1;
			}
		}else {
			//유효성 검사1 통과 못하면
			System.out.println(">> 입력한 ID가 유효하지 않습니다.");
			return -1;
		}
	}

	//회원 수정 <- 회원 조회 후
	@Override
	public int updateUsr1002(List<String> newList, String usrId) throws Exception {
		//회원 조회
//		Usr1000Vo returnVo = selectUsr1000(usrId);
		Usr1000Vo returnVo = null;
		//회원이 없으면(null 반환) -> -1
		if(returnVo == null) {
			return -1;
		//회원이 있으면 -> 수정일시까지 다 수정되면 7이 반환됨
		}else {
			return usr1000Dao.updateUsr1002(newList, returnVo);
		}
	}

	//회원 삭제 <- 회원 조회 후
	@Override
	public int deleteUsr1003(String usrId) throws Exception {
		//회원 조회 먼저, vo 반환 후 넘기기
		Usr1000Vo returnVo = usr1000Dao.selectUsr1000(usrId);
		//더블체크
		if(CheckUsr1000("삭제")) {
			//회원 삭제에 실패하면 -1, 성공하면 1
			return usr1000Dao.deleteUsr1003(returnVo);
		}else {
			return -1;
		}
	}

//	유효성 검사1: id
	public boolean validUsr1004(String inputId) {
		//알파벳 소문자 최소한 1개 이상, 숫자 최소한 1개 이상으로 이루어진 최소 5자리
		return Pattern.matches("^(?=.*[a-z])(?=.*\\d)[a-z\\d]{5,}$", inputId);
	}
	
//	유효성 검사2: 성별, 연락처, 만료 일자
	public boolean validUsr1005(String gender, String phnNumber, String inputDate) {
		if("남".equals(gender) || "여".equals(gender)) {
			if(Pattern.matches("^\\d{3}-\\d{3,4}-\\d{4}$", phnNumber)) {
				if(isDateFormat(inputDate, yMDFormat)) {
					return true;
				}
			}
		}
		return false;
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
            //  검증할 날짜 포맷 설정
//            SimpleDateFormat dateFormatParser = new SimpleDateFormat(dateFormat);
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
  	public boolean CheckUsr1000(String str) {
  		sc = new Scanner(System.in);
  		System.out.print("정말로 "+str+"하시겠습니까? (예: Y / 아니요: 아무 키) >> ");
  		String inputYn = sc.nextLine();
  		return ("Y".equalsIgnoreCase(inputYn))? true : false;
  	}
	
}
