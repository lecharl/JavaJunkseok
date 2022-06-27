package cmm.cmm1000.web;

public class Cmm1000FrontController {
	//HandlerMapping 에서 매치되면 해당 컨트롤러 가져오기
	private HandlerMapping hMapping;
	public FrontController() {
		hMapping = new HandlerMapping();
	}
	
	//입력한 번호가 map에 key로 존재하는지 확인한다.
	//있으면 해당 컨트롤러 반환, 없으면 null? 
	public Controller getMatchedMapping(String key) {
		if(hMapping.hndlMap.containsKey(key)) {
			return hMapping.hndlMap.get(key);
		}else {
			return null;
		}
	}
}
