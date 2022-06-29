package usr.usr1000.service.impl;

import usr.usr1000.dao.Usr1000Dao;
import usr.usr1000.service.Usr1000Service;
import usr.usr1000.vo.Usr1000Vo;

public class Usr1000ServiceImpl implements Usr1000Service {
	
	private Usr1000Dao usr1000Dao;
	
	//회원 조회
	@Override
	public Usr1000Vo selectUsr1000(String usrId) {
		return usr1000Dao.selectUsr1000(usrId);
	}

	//회원 추가 <- 회원 조회 후
	@Override
	public int insertUsr1001(Usr1000Vo usrVo) {
		//회원 조회
		Usr1000Vo returnVo = selectUsr1000(usrVo.getUsrId());
		//회원이 없으면(null 반환) 회원 추가
		if(returnVo == null) {
			return usr1000Dao.insertUsr1001(usrVo);
		//회원이 있으면(vo 반환) 추가하지 않고 -1 반환
		}else {
			return -1;
		}
	}

	//회원 수정 <- 회원 조회 후
	
	//회원 삭제 <- 회원 조회 후
	@Override
	public int deleteUsr1003(String usrId) {
		Usr1000Vo returnVo = selectUsr1000(usrId);
		//회원이 없으면(null 반환)
		if(returnVo == null) {
			return -1;
		//회원이 있으면(vo 반환)
		}else {
			return usr1000Dao.deleteUsr1003(returnVo.getUsrId());
		}
	}

}
