package cht.cht1000.web;

import java.util.List;

import com.ComController;

import cht.cht1000.service.Cht1000Service;
import usr.usr1000.vo.Usr1000Vo;
import view.cht.cht1000.Cht1000View;
import view.cht.cht1000.Cht1001View;

public class Cht1000Controller implements ComController {
	
	private Cht1000Service cht1000Service;

	@Override
	public void selectView(String request) throws Exception {
		char tailRequest = request.charAt(1);
		switch (tailRequest) {
		case '0':
			new Cht1000View().selectCht1000View();
			break;
		case '1':
			new Cht1001View().selectCht1001View();
			break;
		default:
			break;
		}		
	}
	
	//회원 수
	public int countCht1000()  throws Exception{
		return cht1000Service.countCht1000();
	}	
	
	//임박, 만료 회원 수
	public int countCht1000Stt(String status)  throws Exception{
		return cht1000Service.countCht1000Stt(status);
	}
	
	//만료 회원 수
	
	//회원 목록
	public List<Usr1000Vo> selectCht1001List() throws Exception{
		return cht1000Service.selectCht1001List();
	}

}
