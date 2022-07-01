package usr.usr1000.web;

import java.util.List;

import com.ComController;

import usr.usr1000.service.Usr1000Service;
import usr.usr1000.service.impl.Usr1000ServiceImpl;
import usr.usr1000.vo.Usr1000Vo;
import view.usr.usr1000.Usr1000View;
import view.usr.usr1000.Usr1001View;
import view.usr.usr1000.Usr1002View;
import view.usr.usr1000.Usr1003View;

public class Usr1000Controller implements ComController {

	private Usr1000Service usr1000Service = new Usr1000ServiceImpl();
	
	@Override
	public void selectView(String request) throws Exception {	//10,11,12,13, 나머지 에러는 view에서 잡아줬나?
		char tailRequest = request.charAt(1);
		switch (tailRequest) {
		case '0':
			new Usr1000View().selectUsr1000View();
			break;
		case '1':
			new Usr1001View().selectUsr1001View();
			break;
		case '2':
			new Usr1002View().selectUsr1002View();
			break;
		case '3':
			new Usr1003View().selectUsr1003View();
			break;
		default:
			break;
		}
	}
	
	//회원 조회
	public Usr1000Vo selectUsr1000(String usrId)  throws Exception{
		return usr1000Service.selectUsr1000(usrId);
	}
	
	//회원 추가
	public String insertUsr1001(Usr1000Vo usrVo)  throws Exception{
		int result = usr1000Service.insertUsr1001(usrVo);
		//추가 성공하면(1 반환)
		//추가 실패하면(-1 반환)
		return (result == 1)? result+"회원 등록에 성공하였습니다." : result+"회원 등록에 실패하였습니다.";
	}
	
	//회원 수정
	public String updateUsr1002(List<String> newList, String usrId)  throws Exception{
		int result = usr1000Service.updateUsr1002(newList, usrId);
		//수정 성공하면(7 반환)
		return (result == 7)? "회원 수정에 성공하였습니다." : "회원 수정에 실패하였습니다.";
	}

	//회원 삭제
	public String deleteUsr1003(String usrId)  throws Exception{
		int result = usr1000Service.deleteUsr1003(usrId);
		//삭제 성공하면(1 반환)
		//삭제 실패하면(-1 반환)
		return (result == 1)? "회원 삭제에 성공하였습니다." : "회원 삭제에 실패하였습니다.";
	}
}
