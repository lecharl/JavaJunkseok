package usr.usr1000.dao;

import java.util.HashMap;
import java.util.List;

import usr.usr1000.vo.Usr1000Vo;

public interface Usr1000Dao {
	
	//중복 검사, 이건 나중에 지워
	boolean existUsr1000(HashMap<String, Usr1000Vo> map, String usrId);
	
	//회원 조회, id중복체크에도 쓰이나??
	Usr1000Vo selectUsr1000(String usrId);
//	Usr1000Vo selectUsr1000(Usr1000Vo usrVo);
	
	//회원 추가
	int insertUsr1001(Usr1000Vo usrVo);
//	
//	//회원 수정
//	int updateUsr1002(Usr1000Vo updatedUsrVo);
//	
//	//회원 삭제
	int deleteUsr1003(String usrId);
//	
//	//상태 업데이트
//	int updateUsrStts(String usrStatus);
//	
//	//수정 일시 업데이트
//	int updateEdtTime(String editTime);
	
}
