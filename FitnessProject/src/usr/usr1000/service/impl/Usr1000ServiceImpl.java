package usr.usr1000.service.impl;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import usr.usr1000.dao.Usr1000Dao;
import usr.usr1000.dao.impl.Usr1000DaoImpl;
import usr.usr1000.service.Usr1000Service;
import usr.usr1000.vo.Usr1000Vo;

public class Usr1000ServiceImpl implements Usr1000Service {
	
	private Usr1000Dao usr1000Dao = Usr1000DaoImpl.getInstance();
	//날짜 포맷 2가지
	SimpleDateFormat yMDFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//날짜
	Calendar nowCal;
	
	//회원 조회
	@Override
	public Map<String, String> selectUsr1000(String usrId) {
		Usr1000Vo returnVo = null;
		try {
			returnVo = usr1000Dao.selectUsr1000(usrId);
//			if(returnVo == null) {
//				return null;
//			}
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
//		return usr1000Dao.selectUsr1000(usrId);
	}

	//회원 추가 <- 회원 조회 후
	@Override
	public int insertUsr1001(Map<String, String> inputMap) throws Exception {
		nowCal = Calendar.getInstance();
		Usr1000Vo returnVo = new Usr1000Vo.Builder(inputMap.get("usrId"), inputMap.get("usrName"), inputMap.get("usrGender"), inputMap.get("usrPhoneNum"), inputMap.get("usrAddress"), inputMap.get("usrDetail"))
				.joinDate(yMDFormat.format(nowCal.getTime()))
				.usrExpireDate(inputMap.get("usrExpireDate"))
				.enrollTime(dateTimeFormat.format(nowCal.getTime()))
				.editTime(dateTimeFormat.format(nowCal.getTime()))
				.build();
		//회원추가에 실패하면 -1, 성공하면 1
		return usr1000Dao.insertUsr1001(returnVo);
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
	public int deleteUsr1003(Map<String, String> inputMap) throws Exception {
		//회원 조회 먼저, vo 반환 후 넘기기
		Usr1000Vo returnVo = usr1000Dao.selectUsr1000(inputMap.get("usrId"));
		//회원 삭제에 실패하면 -1, 성공하면 1
		return usr1000Dao.deleteUsr1003(returnVo);

		//		usr1000Dao.deleteUsr1003(inputMap.get("usrId"));
//		Usr1000Vo returnVo = selectUsr1000(usrId);
//		Usr1000Vo returnVo = null;
//		//회원이 없으면(null 반환) -> -1 반환
//		if(returnVo == null) {
//			return -1;
//		//회원이 있으면(vo 반환) -> 삭제되면 1이 반환됨
//		}else {
//			return usr1000Dao.deleteUsr1003(returnVo);
//		}
	}


}
