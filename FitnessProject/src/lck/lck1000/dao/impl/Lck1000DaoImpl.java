package lck.lck1000.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import lck.lck1000.dao.Lck1000Dao;
import lck.lck1000.vo.Lck1000Vo;
import usr.usr1000.dao.Usr1000Dao;
/**
 * @Class Name : Lck1000DaoImpl.java
 * @Description : Lck1000DaoImpl Dao class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Lck1000DaoImpl implements Lck1000Dao {
	
	private static Lck1000DaoImpl lck1000DaoInstance;
	
	private Lck1000DaoImpl() {}
	
	//사물함 정보를 담을 객체
	private static Map<String, Lck1000Vo> lckMap;
	//날짜 포맷 2가지
	SimpleDateFormat yMDFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static Lck1000DaoImpl getInstance() {
		if(lckMap == null) {
			lckMap = new HashMap<String, Lck1000Vo>();
			//1~99, "", "2020-01-01"
			for(int i=1; i<100; i++) {
				Lck1000Vo vo;
				if(i == 8) {
					vo = new Lck1000Vo(i+"", "lsy9680", "2022-12-26");
				}else {
					vo = new Lck1000Vo(i+"", "", "2020-01-01");
				}
				lckMap.put(i+"", vo);
			}
		}
		if(lck1000DaoInstance == null) {
			lck1000DaoInstance = new Lck1000DaoImpl();
		}
		return lck1000DaoInstance;
	}

	//사물함 조회
	@Override
	public Lck1000Vo selectLck1000ByNo(String lckNo) {
		//제대로 된 번호로 검색한 vo 그냥 출력
		return lckMap.get(lckNo);
	}

	@Override
	public Lck1000Vo selectLck1000ById(String usrId) {
		Lck1000Vo returnVo = null;
		//map의 각 요소 entry.getValue() == vo인데, 그 vo.getId 가 usrId와 같으면 -> 사용자 존재
		for (Entry<String, Lck1000Vo> entrySet : lckMap.entrySet()) {
			if(usrId.equals(entrySet.getValue().getUsrId())) {
				returnVo = entrySet.getValue();
			}
		}
		return returnVo;
	}
	
	
	

	//사물함 추가
	@Override
	public int insertLck1001(Lck1000Vo lckVo) {
//		Calendar nowCal;
		int result = 0;
		try {
			lckMap.put(lckVo.getLckNo(), lckVo);
			result++;
		} catch (Exception e) {
			result = -1;
			System.out.println("lck dao 등록insert 에러");
			e.printStackTrace();
		}
		
		return result;
	}
	
	//사물함 수정
	@Override
	public int updateLck1002(List<String> newList, Lck1000Vo targetVo, String input, Usr1000Dao usr1000Dao) {
//		Calendar nowCal;
//		int result = 0;
//		try {
//			//input이 lckNo라면
//			if(targetVo.getLckNo().equals(input)) {
//				targetVo.setUsrId(newList.get(0));
//				result++;
//				targetVo.setLckExpireDate(newList.get(1));
//				result++;
//			//input이 id라면....아 id 체크를 했어야 했구나
//			}else if(targetVo.getUsrId().equals(input)) {
//				targetVo.setLckNo(newList.get(0));
//				result++;
//				targetVo.setLckExpireDate(newList.get(1));
//				result++;
//			}
//			//수정일시 변경 set(현재시간)
//			nowCal = Calendar.getInstance();
////			System.out.println(targetVo+"target");
//			Usr1000Vo usrVo = usr1000Dao.selectUsr1000(targetVo.getUsrId());
////			System.out.println(usrVo+"ggg");
//			usrVo.setEditTime(dateTimeFormat.format(nowCal.getTime()));
////			System.out.println(usrVo.getEditTime());
//			result++;
//			//**usrVo의 lckNo도 변경
//			usrVo.setLckNo(targetVo.getLckNo());
//			result++;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return 0;
	}

	//사물함 삭제
	@Override
	public int deleteLck1003(Lck1000Vo lckVo) {
		String key = lckVo.getLckNo();
		int result = 0;
		
		try {
			lckVo.setUsrId("");
			result++;
		} catch (Exception e) {
			System.out.println("result = "+result);
			result = -1;
			e.printStackTrace();
		}
		return result;
	}
	
}
