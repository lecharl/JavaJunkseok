package lck.lck1000.web;

import java.util.List;

import com.ComController;

import lck.lck1000.service.Lck1000Service;
import lck.lck1000.vo.Lck1000Vo;
import view.lck.lck1000.Lck1000View;
import view.lck.lck1000.Lck1001View;
import view.lck.lck1000.Lck1002View;
import view.lck.lck1000.Lck1003View;

public class Lck1000Controller implements ComController {
	
	private Lck1000Service lck1000Service;

	@Override
	public void selectView(String request) throws Exception {
		char tailRequest = request.charAt(1);
		switch (tailRequest) {
		case '0':
			new Lck1000View().selectLck1000View();;
			break;
		case '1':
			new Lck1001View().selectLck1001View();
			break;
		case '2':
			new Lck1002View().selectLck1002View();
			break;
		case '3':
			new Lck1003View().selectLck1003View();
			break;
		default:
			break;
		}
	}
	
	//사물함 조회
	public Lck1000Vo selectLck1000(String input) {
		return lck1000Service.selectLck1000(input);
	}
	
	//사물함 추가
	public String insertLck1001(Lck1000Vo inputVo) {
		int result = lck1000Service.insertLck1001(inputVo);
		String msg = "";
		if(result == -1)
			msg = "입력하신 ID는 사물함이 배정되어 있습니다. 다른 ID로 시도해주세요.";
		if(result == -2)
			msg = "입력하신 사물함 번호가 올바른 형식이 아닙니다.";
		if(result == 1)
			msg = "사물함이 성공적으로 배정되었습니다.";
		return msg;
	}
	//사물함 수정
	public String updateLck1002(List<String> newList, String input) {
		int result = lck1000Service.updateLck1002(newList, input);
		String msg = "";
		//나중에 삼항연산자로 수정~~~~~~~~~~~~
		if(result == 4) {
			msg = "사물함이 성공적으로 수정되었습니다.";
		}else {
			msg = result+"사물함을 수정하는 데 실패하였습니다.";
		}
		return msg;
	}
	
	//사물함 삭제
	public String deleteLck1003(String lckNo) {
		int result = lck1000Service.deleteLck1003(lckNo);
		//나중에 삼항연산자로 수정~~~~~~~~~~~~
		String msg = "";
		if(result == -1)
			msg = "입력하신 사물함 번호는 사용자가 존재하지 않습니다. 다른 번호로 시도해주세요.";
		if(result == 4)
			msg = "사물함이 성공적으로 삭제되었습니다.";
		return msg;
		
	}
}
