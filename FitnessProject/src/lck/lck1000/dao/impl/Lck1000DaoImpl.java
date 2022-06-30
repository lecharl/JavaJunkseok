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
import usr.usr1000.vo.Usr1000Vo;

public class Lck1000DaoImpl implements Lck1000Dao {
	
	//사물함 정보를 담을 객체
	Map<String, Lck1000Vo> lckMap;
	//날짜 포맷 2가지
	SimpleDateFormat yMDFormat = new SimpleDateFormat("yyyy-MM-DD");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public Lck1000DaoImpl() {
		this.lckMap = new HashMap<String, Lck1000Vo>();
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

	//사물함 조회
	@Override
	public Lck1000Vo selectLck1000(String input) {
		Lck1000Vo returnVo = null;
		//길이가 1~2인 문자열을 입력했을 경우
		if(1 <= input.length() && input.length() <= 2) {
			//1~99를 입력했을 경우
			if(1 <= Integer.valueOf(input) && Integer.valueOf(input) <= 99) {
				//**만료일자 업뎃
				updateLck1004UsrId(input);
				//만료되면(== 배정된 id 없음) 따로 하는 줄 알았는데 필요없네. 없는 채로 출력
//				if(!"".equals(lckMap.get(input).getUsrId())) {
					returnVo = lckMap.get(input);
//				}
			}
		//길이가 3이상인 문자열을 입력했을 경우 id와 일치하는지
		}else {
			for (Entry<String, Lck1000Vo> ele: lckMap.entrySet()) {
				String key = ele.getKey();
				Lck1000Vo val = ele.getValue();
				//**만료일자 업뎃
				updateLck1004UsrId(key);
				if(val.getUsrId().equals(input)) {
					returnVo = val;
				}
			}
		}
		return returnVo;
	}

	//사물함 추가
	@Override
	public int insertLck1001(Lck1000Vo inputVo, Lck1000Vo targetVo, Usr1000Dao usr1000Dao) {
		Calendar nowCal;
		int result = 0;
		String chgId = "";
		try {
//			lckMap.replace(targetVo.getLckNo(), inputVo);
			targetVo.setUsrId(inputVo.getUsrId());
			chgId = inputVo.getUsrId();
			result++;
			targetVo.setLckExpireDate(inputVo.getLckExpireDate());
			result++;
			//**usrVo의 lckNo도 변경 
			usr1000Dao.selectUsr1000(chgId).setLckNo(targetVo.getLckNo());
			result++;
			//수정일시 변경 set(현재시간)
			nowCal = Calendar.getInstance();
			Usr1000Vo usrVo = usr1000Dao.selectUsr1000(chgId);
			usrVo.setEditTime(dateTimeFormat.format(nowCal.getTime()));
			result++;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//사물함 수정
	@Override
	public int updateLck1002(List<String> newList, Lck1000Vo targetVo, String input, Usr1000Dao usr1000Dao) {
		Calendar nowCal;
		int result = 0;
		try {
			//input이 lckNo라면
			if(targetVo.getLckNo().equals(input)) {
				targetVo.setUsrId(newList.get(0));
				result++;
				targetVo.setLckExpireDate(newList.get(1));
				result++;
			//input이 id라면
			}else if(targetVo.getUsrId().equals(input)) {
				targetVo.setLckNo(newList.get(0));
				result++;
				targetVo.setLckExpireDate(newList.get(1));
				result++;
			}
			//수정일시 변경 set(현재시간)
			nowCal = Calendar.getInstance();
			Usr1000Vo usrVo = usr1000Dao.selectUsr1000(targetVo.getUsrId());
			usrVo.setEditTime(dateTimeFormat.format(nowCal.getTime()));
			result++;
			//**usrVo의 lckNo도 변경
			usrVo.setLckNo(targetVo.getLckNo());
			result++;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//사물함 삭제
	@Override
	public int deleteLck1003(Lck1000Vo targetVo, Usr1000Dao usr1000Dao) {
		String oldId = targetVo.getUsrId();
		int result = 0;
		try {
			targetVo.setUsrId("");
			result++;
			targetVo.setLckExpireDate("2020-01-01");
			result++;
			//**usrVo반영
			usr1000Dao.selectUsr1000(oldId).setLckNo("");
			result++;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//만료일자 업데이트(조회할 때마다)
	public void updateLck1004UsrId(String lckNo) {
		Lck1000Vo returnVo = lckMap.get(lckNo);
		Calendar calExp = Calendar.getInstance();
		Calendar nowCal = Calendar.getInstance();
		try {
			Date dateExp = yMDFormat.parse(returnVo.getLckExpireDate());
			calExp.setTime(dateExp);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//날짜 차이 계산 -> 만료되면 id == ""
		long diffMllSec = calExp.getTimeInMillis() - nowCal.getTimeInMillis();
		if(diffMllSec <= 0) {
			returnVo.setUsrId("");
		}
	}



}
