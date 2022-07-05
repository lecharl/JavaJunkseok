package cht.cht1000.service;

import java.util.List;
import java.util.Map;

/**
 * @Class Name : Cht1000Service.java
 * @Description : Cht1000Service Service Interface
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */

public interface Cht1000Service {
	//회원 수
	int countCht1000();
	
	//임박, 만료 회원 수
	int countCht1000Stt(String status) throws Exception;
	
	//회원 목록
	List<Map<String, String>> selectCht1001List() throws Exception;
}
