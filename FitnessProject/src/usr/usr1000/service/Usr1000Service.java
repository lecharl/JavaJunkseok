package usr.usr1000.service;

import java.util.List;
import java.util.Map;

/**
 * @Class Name : Usr1000Service.java
 * @Description : Usr1000Service Service interface
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public interface Usr1000Service {

	//회원 조회
	Map<String, String> selectUsr1000(String usrId) throws Exception;
	
	//회원 추가
	int insertUsr1001(Map<String, String> inputMap) throws Exception;
	
	//회원 수정
	int updateUsr1002(Map<String, String> inputMap) throws Exception;
	
	//회원 삭제
	int deleteUsr1003(String usrId) throws Exception;
	
}
