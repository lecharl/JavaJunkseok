package lck.lck1000.service;

import java.util.List;

import lck.lck1000.vo.Lck1000Vo;

public interface Lck1000Service {
	
	//사물함 조회
	Lck1000Vo selectLck1000(String input);

	//사물함 추가
	int insertLck1001(Lck1000Vo inputVo);

	//사물함 수정
	int updateLck1002(List<String> newList, String input);
	
	//사물함 삭제
	int deleteLck1003(String lckNo);
}
