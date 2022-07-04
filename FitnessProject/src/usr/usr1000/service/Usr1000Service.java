package usr.usr1000.service;

import java.util.List;
import java.util.Map;

import usr.usr1000.vo.Usr1000Vo;

public interface Usr1000Service {

	//회원 조회
//	Usr1000Vo selectUsr1000(String usrId) throws Exception;
	Map<String, String> selectUsr1000(String usrId) throws Exception;
	
	//회원 추가
	int insertUsr1001(Map<String, String> inputMap) throws Exception;
	
	//회원 수정
	int updateUsr1002(List<String> newList, String usrId) throws Exception;
	
	//회원 삭제
	int deleteUsr1003(Map<String, String> inputMap) throws Exception;
	
}
