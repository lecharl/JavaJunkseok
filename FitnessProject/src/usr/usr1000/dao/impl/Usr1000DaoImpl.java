package usr.usr1000.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import usr.usr1000.dao.Usr1000Dao;
import usr.usr1000.vo.Usr1000Vo;

public class Usr1000DaoImpl implements Usr1000Dao{

	//회원 정보를 담을 객체
	Map<String, Usr1000Vo> usrMap;
	List<Map<String, Usr1000Vo>> usrMaplist = new ArrayList<Map<String,Usr1000Vo>>();
	//날짜 포맷 2가지
	SimpleDateFormat yMDFormat = new SimpleDateFormat("YYYY-MM-DD");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	//날짜
	Calendar nowCal = Calendar.getInstance();
	
	public Usr1000DaoImpl() {
		this.usrMap = new HashMap<String, Usr1000Vo>();
		Usr1000Vo vo1 = new Usr1000Vo.Builder("lsy9680", "ㅇㅅㅇ", "여성", "010-1234-1234", "관악구 보라매로", "근육 1도 없음")
				.joinDate("2022-01-03")
				.usrExpireDate("2022-12-28")
				.enrollTime("2022-01-03 16:50:11")
				.editTime("2022-02-04 16:22:00")
				.build();
		usrMap.put(vo1.getUsrId(), vo1);
		usrMaplist.add(usrMap);
		//map 객체 생성 -> map에 put -> list에 add 반복
		this.usrMap = new HashMap<String, Usr1000Vo>();
		Usr1000Vo vo2 = new Usr1000Vo.Builder("lecharlhi", "llchh", "남성", "010-1234-1234", "관악구 보라매로", "지방 많음")
				.joinDate("2022-02-10")
				.usrExpireDate("2023-02-28")
				.enrollTime("2022-02-10 15:50:11")
				.editTime("2022-02-20 09:10:40")
				.build();
		usrMap.put(vo2.getUsrId(), vo2);
		usrMaplist.add(usrMap);
	}

//	회원이 있는지 알아내는 메서드는 서비스로 분리하자@@@@@@
	
	@Override
	public boolean existUsr1000(HashMap<String, Usr1000Vo> hmap, String usrId) {
		//id가 존재하면서 사용유무 == "Y"인 경우 true
		return (hmap.containsKey(usrId) && hmap.get(usrId).getUseYn() == "Y")? true : false;
	}

	//회원 조회/ 추가, 수정 및 삭제하기 전에 사전 검사
	@Override
	public Usr1000Vo selectUsr1000(String usrId) {
		List<Map<String, Usr1000Vo>> showList = usrMaplist;
		final int listSize = showList.size();
		Usr1000Vo returnVo = null;
		for(int i=0; i<listSize; i++) {
			HashMap<String, Usr1000Vo> hMap = new HashMap<String, Usr1000Vo>(showList.get(i));
			//회원이 없을 경우 null 반환
			if(!existUsr1000(hMap, usrId)) {
				returnVo = null;
			//회원이 있을 경우 vo 반환
			}else {
				returnVo = hMap.get(usrId);
			}
		}
		return returnVo;
	}

	//회원 추가 - 서비스에서 회원 조회 후
	@Override
	public int insertUsr1000(Usr1000Vo usrVo) {
//		//회원이 있을 경우 -1 반환
//		if(usrMap.containsKey(usrVo.getUsrId())) {
//			return -1;
//		}
		//회원이 없을 경우 회원 추가 후 1 반환
		usrMap.put(usrVo.getUsrId(), usrVo);
		usrMaplist.add(usrMap);
		return 1;
	}

	//회원 수정 - 서비스에서 회원 조회 후
	//id를 제외 후 기존정보를 보여주고 나서
//	@Override
//	public int updateUsr1000(Usr1000Vo updatedUsrVo) {	//id를 제외한 새정보를 넘겨받음
//		//회원이 있을 경우 정보 수정 :: id로 기존vo를 가져와서 setter(새vo.getter()) 
//		Usr1000Vo oldUsrVo = usrMap.get(updatedUsrVo.getUsrId());
//		return 0;
//	}
	
	//회원 삭제 - 서비스에서 회원 조회 후
	@Override
	public int deleteUsr(String usrId) {
		//사용 유무 = "N" 로 변경
		usrMap.get(usrId).getUseYn();
		return 0;
	}

	
	
}
