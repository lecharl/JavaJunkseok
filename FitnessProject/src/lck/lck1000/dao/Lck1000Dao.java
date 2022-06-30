package lck.lck1000.dao;

import java.util.List;

import lck.lck1000.vo.Lck1000Vo;
import usr.usr1000.dao.Usr1000Dao;

public interface Lck1000Dao {
	
	//사물함 조회
	Lck1000Vo selectLck1000(String input);
	
	//사물함 추가
	int insertLck1001(Lck1000Vo inputVo, Lck1000Vo targetVo, Usr1000Dao usr1000Dao);
	
	//사물함 수정
	int updateLck1002(List<String> newList, Lck1000Vo targetVo, String input, Usr1000Dao usr1000Dao);
	
	//사물함 삭제
	int deleteLck1003(Lck1000Vo targetVo, Usr1000Dao usr1000Dao);

}
