package lck.lck1000.service.impl;

import java.util.List;

import lck.lck1000.dao.Lck1000Dao;
import lck.lck1000.dao.impl.Lck1000DaoImpl;
import lck.lck1000.service.Lck1000Service;
import lck.lck1000.vo.Lck1000Vo;
import usr.usr1000.dao.Usr1000Dao;
import usr.usr1000.dao.impl.Usr1000DaoImpl;
import usr.usr1000.vo.Usr1000Vo;

public class Lck1000ServiceImpl implements Lck1000Service{
	
	private Lck1000Dao lck1000Dao = Lck1000DaoImpl.getInstance();
	private Usr1000Dao usr1000Dao = Usr1000DaoImpl.getInstance();

	//사물함 조회
	@Override
	public Lck1000Vo selectLck1000(String input) {
		return lck1000Dao.selectLck1000(input);
	}

	//사물함 추가 <- 사물함 조회 후
	@Override
	public int insertLck1001(Lck1000Vo inputVo) {
		//사물함 조회, id로 먼저 조회
		Lck1000Vo returnVo = selectLck1000(inputVo.getUsrId());
		//(null이 아님, Lck1000Vo 반환 && id !="" ) == 사물함이 이미 배정되어 있음
		if(returnVo != null && !"".equals(returnVo.getUsrId())) {
			return -1;
		}else {
			//lckNo로 조회
			returnVo = selectLck1000(inputVo.getLckNo());
			//null 반환 == 사물함번호를 올바르게 입력을 하지 않음
			if(returnVo == null) {
				return -2;
			}
			//id가 배정되지 않은 사물함, 4가 반환돼야 정상
			return lck1000Dao.insertLck1001(inputVo, returnVo, usr1000Dao);
		}
	}
	
	//사물함 수정 <- id조회하고 사물함 조회 후
	@Override
	public int updateLck1002(List<String> newList, String input) {
		//아예 메서드를 나눠야 겠다.
		//id 조회
		
		//사물함 조회
		Lck1000Vo returnVo = selectLck1000(input);
		if(returnVo == null) {
			return -1;
		}else {
			//4가 정상
			return lck1000Dao.updateLck1002(newList, returnVo, input, usr1000Dao);			
		}
	}
	
	//사물함 삭제 <- 사물함 조회 후
	@Override
	public int deleteLck1003(String lckNo) {
		//사물함 조회, lckNo로 조회
		Lck1000Vo returnVo = selectLck1000(lckNo);
		//null 반환 == 잘못 입력해서
		if(returnVo == null) {
			return -1;
		}else {
			//3이 반환돼야 정상
			return lck1000Dao.deleteLck1003(returnVo, usr1000Dao);
		}
	}


}
