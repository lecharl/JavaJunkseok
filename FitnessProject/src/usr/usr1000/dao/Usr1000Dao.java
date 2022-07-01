package usr.usr1000.dao;

import java.util.HashMap;
import java.util.List;

import usr.usr1000.vo.Usr1000Vo;

public interface Usr1000Dao {
	
	
	//회원 조회, id중복체크에도 쓰이나??
	Usr1000Vo selectUsr1000(String usrId) throws Exception;
//	Usr1000Vo selectUsr1000(Usr1000Vo usrVo);
	
	//회원 추가
	int insertUsr1001(Usr1000Vo usrVo);
//	
	//회원 수정
	int updateUsr1002(List<String> newList, Usr1000Vo usrVo);
//	
//	//회원 삭제
	int deleteUsr1003(Usr1000Vo usrVo);
//	
	//상태 업데이트
	int updateCht1000Stt(String usrId, HashMap<String, Usr1000Vo> returnVo) throws Exception;
//	
//	//수정 일시 업데이트
//	int updateEdtTime(String editTime);
	
	//회원 수
	int countCht1000() throws Exception;
	
	//임박, 만료 회원 수
	int countCht1000Stt(String status) throws Exception;
	
	//만료 회원 수
	
	
	//회원 목록
	List<Usr1000Vo> selectCht1001List() throws Exception;

	
}
