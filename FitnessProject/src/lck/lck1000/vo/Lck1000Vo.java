package lck.lck1000.vo;

/**
 * @Class Name : Lck1000Vo.java
 * @Description : Lck1000Vo Vo class
 * 
 * @author 이승연
 * @Sincce 2022.06.24.
 * @Versionn 1.0
 * @see
 * 
 * Copyright (C) All right reserved.
 *
 */
public class Lck1000Vo {
	private String lckNo;	//**String
	private String usrId;	//**
	private String lckExpireDate;	//만료 일자
	
	public Lck1000Vo(String lckNo, String usrId, String lckExpireDate) {
		super();
		this.lckNo = lckNo;
		this.usrId = usrId;
		this.lckExpireDate = lckExpireDate;
	}

	public String getLckNo() {
		return lckNo;
	}

	public void setLckNo(String lckNo) {
		this.lckNo = lckNo;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getLckExpireDate() {
		return lckExpireDate;
	}

	public void setLckExpireDate(String lckExpireDate) {
		this.lckExpireDate = lckExpireDate;
	}

	@Override
	public String toString() {
		return "- 사물함 번호 : " + lckNo + "\n- 회원 ID : " + usrId + "\n- 만료 일자 : " + lckExpireDate;
	}
	
	
}
