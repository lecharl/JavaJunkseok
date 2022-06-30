package usr.usr1000.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
	SimpleDateFormat yMDFormat = new SimpleDateFormat("yyyy-MM-DD");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//날짜
//	Calendar nowCal = Calendar.getInstance();
	
	
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
				.usrExpireDate("2022-06-28")
				.enrollTime("2022-02-10 15:50:11")
				.editTime("2022-02-20 09:10:40")
				.build();
		usrMap.put(vo2.getUsrId(), vo2);
		usrMaplist.add(usrMap);
	}

//	아래 메서드는 나중에 삭제ㅔㅔㅔㅔ
	@Override
	public boolean existUsr1000(HashMap<String, Usr1000Vo> hMap, String usrId) {
		//id가 존재하면서 사용유무 == "Y"인 경우 true
		return (hMap.containsKey(usrId) && "Y".equals(hMap.get(usrId).getUseYn()))? true : false;
	}

	//회원 조회(추가, 수정 및 삭제하기 전에 사전 검사)
	@Override
	public Usr1000Vo selectUsr1000(String usrId)  throws Exception{
		List<Map<String, Usr1000Vo>> showList = usrMaplist;
		final int LIST_SIZE = showList.size();
		Usr1000Vo returnVo = null;
		for(int i=0; i<LIST_SIZE; i++) {
			HashMap<String, Usr1000Vo> hMap = new HashMap<String, Usr1000Vo>(showList.get(i));
			//회원이 없을 경우 null 반환
			if(!existUsr1000(hMap, usrId)) {
//				returnVo = null;
				continue;
			//회원이 있을 경우 vo 반환
			}else {
				//**조회 시 회원 상태 업데이트
				updateCht1000Stt(usrId);
				returnVo = hMap.get(usrId);
				break;
			}
		}
		return returnVo;
	}

	//회원 추가 <- 서비스에서 회원 조회 후
	@Override
	public int insertUsr1001(Usr1000Vo usrVo) {
//		//회원이 있을 경우 -1 반환
//		if(usrMap.containsKey(usrVo.getUsrId())) {
//			return -1;
//		}
		//회원이 없을 경우 회원 추가 후 1 반환
		int result = 0;
		try {
			usrMap.put(usrVo.getUsrId(), usrVo);
			usrMaplist.add(usrMap);
			result++;
		} catch (Exception e) {
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
			System.out.println("result = "+result);
			e.printStackTrace();
		}
		return result;
	}
	
	//회원 삭제 <- 서비스에서 회원 조회 후
	@Override
	public int deleteUsr1003(Usr1000Vo usrVo) {
		int result = 0;
		//사용 유무 = "N" 로 변경
		try {
			usrVo.setUseYn("N");
			result++;
		} catch (Exception e) {
			System.out.println("result = "+result);
			e.printStackTrace();
		}
		return result;
	}

	
	
	//회원 수 <- 여기서 회원 목록 후
	@Override
	public int countCht1000() throws Exception {
		List<Usr1000Vo> returnList = selectCht1001List();
		return returnList.size();
	}

	//상태 업데이트 <- 여기서 회원 조회 후
	@Override
	public int updateCht1000Stt(String usrId) throws Exception {
		Usr1000Vo returnVo = selectUsr1000(usrId);
		//만료 일자 : String -> Calendar
		Calendar calExp = Calendar.getInstance();
		Calendar nowCal = Calendar.getInstance();
		try {
			Date dateExp = yMDFormat.parse(returnVo.getUsrExpireDate());
			calExp.setTime(dateExp);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//회원 상태 계산
		long diffSec = (calExp.getTimeInMillis() - nowCal.getTimeInMillis()) / 1000;
		long diffDay = diffSec/(60*60*24);
		//회원 상태 set
		if(0 < diffDay && diffDay <= 5) {
			returnVo.setUsrStatus("임박");
		}else if(diffDay <= 0){
			returnVo.setUsrStatus("만료");			
		}else {
			returnVo.setUsrStatus("정상");						
		}
		return 1;
	}

	
	//임박, 만료 회원 수 <- 여기서 회원 상태 업데이트 후
	@Override
	public int countCht1000Stt(String status) throws Exception {
		List<Map<String, Usr1000Vo>> showList = usrMaplist;
		final int LIST_SIZE = showList.size();
		int count = 0;
//		Usr1000Vo returnVo = null;
//		List<Usr1000Vo> returnList = new ArrayList<Usr1000Vo>();
		for(int i=0; i<LIST_SIZE; i++) {
			HashMap<String, Usr1000Vo> hMap = new HashMap<String, Usr1000Vo>(showList.get(i));
			Collection<Usr1000Vo> valueVo = hMap.values();
			Iterator<Usr1000Vo> it = valueVo.iterator();
			while(it.hasNext()) {	//1번만 돌림
				Usr1000Vo nextVo = it.next();
				//**회원 상태 업데이트 하고
				updateCht1000Stt(nextVo.getUsrId());
				//**사용 유무 == "Y" && 상태 == "임박"
				if("Y".equals(nextVo.getUseYn()) && status.equals(nextVo.getUsrStatus())) {
//					returnVo = nextVo;
//					returnList.add(nextVo);
					count++;
				}
			}
			
		}//for end
		return count;
	}

	
	//회원 목록 <- 여기서 회원 상태 업데이트 후
	@Override
	public List<Usr1000Vo> selectCht1001List() throws Exception {
		List<Map<String, Usr1000Vo>> showList = usrMaplist;
		final int LIST_SIZE = showList.size();
//		Usr1000Vo returnVo = null;
		List<Usr1000Vo> returnList = new ArrayList<Usr1000Vo>();
		for(int i=0; i<LIST_SIZE; i++) {
			HashMap<String, Usr1000Vo> hMap = new HashMap<String, Usr1000Vo>(showList.get(i));
			Collection<Usr1000Vo> valueVo = hMap.values();
			Iterator<Usr1000Vo> it = valueVo.iterator();
			while(it.hasNext()) {	//1번만 돌림
				Usr1000Vo nextVo = it.next();
				//**회원 상태 업데이트 하고
				updateCht1000Stt(nextVo.getUsrId());
				if("Y".equals(nextVo.getUseYn())) {
//					returnVo = nextVo;
					returnList.add(nextVo);
				}
			}
			
//			for(Entry<String, Usr1000Vo> ele : hMap.entrySet()) {
//				if(ele.getValue().getUseYn() == "Y") {
//					returnVo = ele.getValue();
//					returnList.add(returnVo);
//				}
//			}
			
		}//for end
		return returnList;
	}

	
	
}
