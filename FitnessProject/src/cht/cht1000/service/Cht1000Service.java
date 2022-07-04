package cht.cht1000.service;

import java.util.List;
import java.util.Map;

import usr.usr1000.vo.Usr1000Vo;

public interface Cht1000Service {
	//회원 수
	int countCht1000() throws Exception;
	
	//임박, 만료 회원 수
	int countCht1000Stt(String status) throws Exception;
	
	//회원 목록
	List<Map<String, String>> selectCht1001List() throws Exception;
}
