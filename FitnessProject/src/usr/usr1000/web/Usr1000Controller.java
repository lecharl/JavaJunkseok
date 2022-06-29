package usr.usr1000.web;

import com.ComController;

import usr.usr1000.service.Usr1000Service;
import usr.usr1000.vo.Usr1000Vo;
import view.usr.usr1000.Usr1000View;
import view.usr.usr1000.Usr1001View;
import view.usr.usr1000.Usr1002View;
import view.usr.usr1000.Usr1003View;

public class Usr1000Controller implements ComController {

	private Usr1000Service usr1000Service;
//	static이 붙을지 안붙을지 고민해보자
//	void 도
	
	@Override
	public void selectView(String request) {	//10,11,12,13, 나머지 에러는 view에서 잡아줬나?
		char tailRequest = request.charAt(1);
		switch (tailRequest) {
		case '0':
			new Usr1000View().selectUsr1000View();;
			break;
		case '1':
			new Usr1001View();
			break;
		case '2':
			new Usr1002View();
			break;
		case '3':
			new Usr1003View();
			break;
		default:
			break;
		}
	}
	
	//회원 조회 요청,, void??
	public Usr1000Vo selectUsr1000(String usrId) {
		return usr1000Service.selectUsr1000(usrId);
//		Usr1000Vo returnVo = usr1000Service.selectUsr1000(usrId);
//		//없으면(null) ..뭐하지?
//		if(returnVo == null) {
//			//"해당 회원이 존재하지 않습니다."
//		//있으면(vo)
//		}else {
//			//"조회 결과 입니다."
//		}
	}
	
	//회원 추가 요청
	public String insertUsr1001(Usr1000Vo usrVo) {
		int result = usr1000Service.insertUsr1001(usrVo);
		//추가 성공하면(1 반환)
		if(result == 1) {
			return "회원 등록이 정상적으로 완료되었습니다.";
		//추가 실패하면(-1 반환)
		}else {
			return "회원 등록에 실패하였습니다.";
		}
	}
	
	//회원 수정

	//회원 삭제
	public String deleteUsr1003(String usrId) {
		int result = usr1000Service.deleteUsr1003(usrId);
		//삭제 성공하면(1 반환)
		if(result == 1) {
			return "회원 삭제가 정상적으로 완료되었습니다.";
		//삭제 실패하면(-1 반환)
		}else {
			return "회원 삭제에 실패하였습니다.";
		}
	}
}
