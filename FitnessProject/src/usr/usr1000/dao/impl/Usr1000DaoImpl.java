package usr.usr1000.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import usr.usr1000.dao.Usr1000Dao;
import usr.usr1000.vo.Usr1000Vo;
/**
 * @Class Name : Usr1000DaoImpl.java
 * @Description : Usr1000DaoImpl Dao class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Usr1000DaoImpl implements Usr1000Dao{
	
	private static Usr1000DaoImpl usr1000DaoInstance;
	
	private Usr1000DaoImpl() {}

	//회원 정보를 담을 객체
	private static Map<String, Usr1000Vo> usrMap;
	Usr1000Vo vo;
	//날짜 포맷 2가지
	SimpleDateFormat yMDFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//날짜
	Calendar nowCal;
	Calendar exCal;
	
	public static Usr1000DaoImpl getInstance() {
		if(usrMap == null) {
			usrMap = new HashMap<String, Usr1000Vo>(); 
			Usr1000Vo vo1 = new Usr1000Vo.Builder("lsy9680", "ㅇㅅㅇ", "여성", "010-1234-1234", "관악구 보라매로", "근육 1도 없음")
					.joinDate("2022-01-03")
					.usrExpireDate("2022-12-28")
					.enrollTime("2022-01-03 16:50:11")
					.editTime("2022-02-04 16:22:00")
					.build();
			Usr1000Vo vo2 = new Usr1000Vo.Builder("lecharlhi", "llchh", "남성", "010-1234-1234", "관악구 보라매로", "지방 많음")
					.joinDate("2022-02-10")
					.usrExpireDate("2022-07-07")
					.enrollTime("2022-02-10 15:50:11")
					.editTime("2022-02-20 09:10:40")
					.build();
			usrMap.put(vo1.getUsrId(), vo1);
			usrMap.put(vo2.getUsrId(), vo2);
		}
		if(usr1000DaoInstance == null) {
			usr1000DaoInstance = new Usr1000DaoImpl();
		}
		
		return usr1000DaoInstance;
		
	}

	//회원 조회(추가, 수정 및 삭제하기 전에 사전 검사)
	@Override
	public Usr1000Vo selectUsr1000(String usrId) throws Exception{
		Usr1000Vo returnVo = null;
		//회원 존재, 사용 여부 == "Y"
		if(usrMap.containsKey(usrId) && "Y".equals(usrMap.get(usrId).getUseYn())) {
			returnVo = usrMap.get(usrId);
			//회원 상태 업뎃**
			nowCal = Calendar.getInstance();	//현재
			exCal = Calendar.getInstance();
			Date exDate = yMDFormat.parse(returnVo.getUsrExpireDate());
			exCal.setTime(exDate);	//만료일자
			
			long diffSec = (exCal.getTimeInMillis() - nowCal.getTimeInMillis())/1000;
			double diffDay = (double)diffSec/(24*60*60);
			if(diffDay <= 0) {
				returnVo.setUsrStatus("만료");
			}else if(0 < diffDay && diffDay <= 5){
				returnVo.setUsrStatus("임박");
			}else {
				returnVo.setUsrStatus("정상");
			}
		}
		return returnVo;
	}
	

	//회원 추가 <- 서비스에서 회원 조회 후
	@Override
	public int insertUsr1001(Usr1000Vo usrVo) {
		//회원이 없을 경우 회원 추가 후 1 반환
		int result = 0;
		try {
			usrMap.put(usrVo.getUsrId(), usrVo);
			result++;
		} catch (Exception e) {
			result = -1;
			e.printStackTrace();
		}
		return result;
	}

	//회원 수정 - 서비스에서 회원 조회 후
	//id를 제외 후 기존정보를 보여주고 나서
//	@Override
//	public int updateUsr1002(Usr1000Vo updatedUsrVo) {	//id를 제외한 새정보를 넘겨받음
//		//회원이 있을 경우 정보 수정 :: id로 기존vo를 가져와서 setter(새vo.getter()) 
//		Usr1000Vo oldUsrVo = usrMap.get(updatedUsrVo.getUsrId());
//		return 0;
//	}
	
	//회원 수정 <- 서비스에서 회원 조회 후
	@Override
	public int updateUsr1002(List<String> newList, Usr1000Vo usrVo) {
		Calendar nowCal;
//		Usr1000Vo returnVo = usrMap.get(usrId);
		int result = 0;
		//newList의 요소로 각각 set
		try {
			usrVo.setUsrName(newList.get(0));
			result++;
			usrVo.setUsrGender(newList.get(1));
			result++;
			usrVo.setUsrPhoneNum(newList.get(2));
			result++;
			usrVo.setUsrAddress(newList.get(3));
			result++;
			usrVo.setUsrDetail(newList.get(4));
			result++;
			usrVo.setUsrExpireDate(newList.get(5));
			result++;
			//수정일시 set(현재 시간)
			nowCal = Calendar.getInstance();
			usrVo.setEditTime(dateTimeFormat.format(nowCal.getTime()));
			result++;
		} catch (Exception e) {
//			System.out.println("result = "+result);
			e.printStackTrace();
		}
		return result;
	}
	
	//회원 삭제 <- 서비스에서 회원 조회 후
	@Override
	public int deleteUsr1003(Usr1000Vo usrVo) {
		String key = usrVo.getUsrId();
		int result = 0;
		//사용 유무 = "N" 로 변경
		try {
			usrVo.setUseYn("N");
			result++;
		} catch (Exception e) {
			System.out.println("result = "+result);
			result = -1;
			e.printStackTrace();
		}
		return result;
	}

	
	
	//회원 수
	@Override
	public int countCht1000()  {
		List<Usr1000Vo> returnList = selectCht1001List();
		return returnList.size();
	}

	//임박, 만료 회원 수
	@Override
	public int countCht1000Stt(String status) {
		List<Usr1000Vo> returnList = new ArrayList<Usr1000Vo>();
		try {
			for(Entry<String, Usr1000Vo> ele : usrMap.entrySet()) {
//				System.out.println(ele.getValue());
				//회원 상태 업뎃**
				nowCal = Calendar.getInstance();	//현재
				exCal = Calendar.getInstance();
				Date exDate = yMDFormat.parse(ele.getValue().getUsrExpireDate());
				exCal.setTime(exDate);	//만료일자
				
				long diffSec = (exCal.getTimeInMillis() - nowCal.getTimeInMillis())/1000;
				double diffDay = (double)diffSec/(24*60*60);
				if(diffDay <= 0) {
					ele.getValue().setUsrStatus("만료");
				}else if(0 < diffDay && diffDay <= 5){
					ele.getValue().setUsrStatus("임박");
				}else {
					ele.getValue().setUsrStatus("정상");
				}
				
				if("Y".equals(ele.getValue().getUseYn()) && status.equals(ele.getValue().getUsrStatus())) {
					returnList.add(ele.getValue());
				}
			}
		} catch (Exception e) {
			System.out.println("usrDao,, 회원목록cht :: 없어서?길이0?");
			e.printStackTrace();
		}
		return returnList.size();
	}

	
	//회원 목록
	@Override
	public List<Usr1000Vo> selectCht1001List() {
		List<Usr1000Vo> returnList = new ArrayList<Usr1000Vo>();
		try {
			for(Entry<String, Usr1000Vo> ele : usrMap.entrySet()) {
				//회원 상태 업뎃**
				nowCal = Calendar.getInstance();	//현재
				exCal = Calendar.getInstance();
				Date exDate = yMDFormat.parse(ele.getValue().getUsrExpireDate());
				exCal.setTime(exDate);	//만료일자
				
				long diffSec = (exCal.getTimeInMillis() - nowCal.getTimeInMillis())/1000;
				double diffDay = (double)diffSec/(24*60*60);
				if(diffDay <= 0) {
					ele.getValue().setUsrStatus("만료");
				}else if(0 < diffDay && diffDay <= 5){
					ele.getValue().setUsrStatus("임박");
				}else {
					ele.getValue().setUsrStatus("정상");
				}
				
				if("Y".equals(ele.getValue().getUseYn())) {
					returnList.add(ele.getValue());
				}
			}
		} catch (Exception e) {
			System.out.println("usrDao,, 회원목록cht :: 없어서?길이0?");
			e.printStackTrace();
		}
		return returnList;
	}
	
}
