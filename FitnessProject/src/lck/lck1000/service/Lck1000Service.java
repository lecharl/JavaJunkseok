package lck.lck1000.service;

import java.util.List;
import java.util.Map;

/**
 * @Class Name : Lck1000Service.java
 * @Description : Lck1000Service Service interface
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public interface Lck1000Service {
	
	//사물함 조회
	Map<String, String> selectLck1000ByNo(String input) throws Exception;
	Map<String, String> selectLck1000ById(String input) throws Exception;

	//사물함 추가
	int insertLck1001(Map<String, String> inputMap, Map<String, String> oldMap) throws Exception;
	int insertLck1001(Map<String, String> inputMap) throws Exception;

	//사물함 수정
	int updateLck1002(List<String> newList, String input);
	
	//사물함 삭제
	int deleteLck1003(String lckNo) throws Exception;

}
