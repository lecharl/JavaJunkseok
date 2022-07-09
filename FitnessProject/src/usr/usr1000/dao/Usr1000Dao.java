package usr.usr1000.dao;

import java.util.List;

import usr.usr1000.vo.Usr1000Vo;
/**
 * @Class Name : Usr1000Dao.java
 * @Description : Usr1000Dao Dao class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public interface Usr1000Dao {
	
	
	//회원 조회
	Usr1000Vo selectUsr1000(String usrId) throws Exception;
	
	//회원 추가
	int insertUsr1001(Usr1000Vo usrVo);
	
	//회원 수정
	int updateUsr1002(Usr1000Vo usrVo) throws Exception;
	
	//회원 삭제
	int deleteUsr1003(Usr1000Vo usrVo);
	
	//회원 수
	int countCht1000() ;
	
	//임박, 만료 회원 수
	int countCht1000Stt(String status) ;
	
	//회원 목록
	List<Usr1000Vo> selectCht1001List() ;

	
}
