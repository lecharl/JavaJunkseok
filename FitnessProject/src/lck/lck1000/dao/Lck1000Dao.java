package lck.lck1000.dao;

import java.util.List;

import lck.lck1000.vo.Lck1000Vo;
import usr.usr1000.dao.Usr1000Dao;
import usr.usr1000.vo.Usr1000Vo;
/**
 * @Class Name : Lck1000Dao.java
 * @Description : Lck1000Dao Dao interface
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public interface Lck1000Dao {
	
	//사물함 조회
	Lck1000Vo selectLck1000ByNo(String lckNo);
	Lck1000Vo selectLck1000ById(String usrId);
	
	//사물함 추가
	int insertLck1001(Lck1000Vo lckVo);
	
	//사물함 수정
	int updateLck1002(Lck1000Vo lckVo, Lck1000Vo oldVo);
	
	//사물함 삭제
	int deleteLck1003(Lck1000Vo targetVo);

}
