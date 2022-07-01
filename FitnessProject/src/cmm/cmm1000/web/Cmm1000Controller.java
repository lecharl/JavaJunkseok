package cmm.cmm1000.web;

import com.ComController;

import view.cmm.cmm1000.Cmm1000View;

public class Cmm1000Controller implements ComController {
	
	@Override
	public void selectView(String request) throws Exception {
		Cmm1000View view = new Cmm1000View();
		view.menuLoop();
	}
}
