package cmm.cmm1000.web;

import java.util.Map;

import com.ComController;

import view.cmm.cmm1000.Cmm1000View;

public class Cmm1000Controller implements ComController {
	
	//뷰
	public Cmm1000Controller() {
	}
	
	@Override
	public void selectView(String request) {
		Cmm1000View view = new Cmm1000View();
		view.menuLoop();
	}
	@Override
	public Object selectMethod(String request, Map<String, String> tempMap) {
		return null;
	}
	
	
}
