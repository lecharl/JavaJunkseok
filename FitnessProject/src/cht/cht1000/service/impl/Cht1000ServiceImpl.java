package cht.cht1000.service.impl;

import java.util.List;

import cht.cht1000.service.Cht1000Service;
import usr.usr1000.dao.Usr1000Dao;
import usr.usr1000.vo.Usr1000Vo;

public class Cht1000ServiceImpl implements Cht1000Service{

	private Usr1000Dao usr1000Dao;
	//회원 수
	@Override
	public int countCht1000() throws Exception {
		return usr1000Dao.countCht1000();
	}	
	
	//임박, 만료 회원 수
	@Override
	public int countCht1000Stt(String status)  throws Exception{
		return usr1000Dao.countCht1000Stt(status);
	}
	
	//회원 목록
	@Override
	public List<Usr1000Vo> selectCht1001List() throws Exception {
		return usr1000Dao.selectCht1001List();
	}




}
