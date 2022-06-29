package usr.usr1000.vo;

public class Usr1000Vo {
	private String usrId;
	private String usrName;
	private String usrGender;
	private String usrPhoneNum;
	private String usrAddress;
	private String usrDetail;	//회원 설명
	private String usrStatus;	//회원 상태(정산/만료/임박)
	private String joinDate;	//가입 일자
	private String usrExpireDate;	//만료 일자
	private String useYn;	//Y/N, 회원추가 시 자동 Y
	private String enrollTime;	//등록 일시
	private String editTime;	//수정 일시
	
	private String lckNo;	// **String? int?

//	public Usr1000Vo(String usrId, String usrName, String usrGender, String usrPhoneNum, String usrAddress,
//			String usrDetail, String joinDate, String usrExpireDate, String enrollTime,
//			String editTime) {
//		super();
//		this.usrId = usrId;
//		this.usrName = usrName;
//		this.usrGender = usrGender;
//		this.usrPhoneNum = usrPhoneNum;
//		this.usrAddress = usrAddress;
//		this.usrDetail = usrDetail;
//		this.usrStatus = "정산";	//자동
//		this.joinDate = joinDate;	//자동??
//		this.usrExpireDate = usrExpireDate;	//내가 입력
//		this.useYn = "Y";	//자동
//		this.enrollTime = enrollTime;	//자동??
//		this.editTime = editTime;	//자동??
//		this.lckNo = "";	//(자동)
//	}
	
	private Usr1000Vo(Builder builder){
		usrId = builder.usrId;
		usrName = builder.usrName;
		usrGender = builder.usrGender;
		usrPhoneNum = builder.usrPhoneNum;
		usrAddress = builder.usrAddress;
		usrDetail = builder.usrDetail;
		usrStatus = builder.usrStatus;
		joinDate = builder.joinDate;
		usrExpireDate = builder.usrExpireDate;
		useYn = builder.useYn;
		enrollTime = builder.enrollTime;
		editTime = builder.editTime;
		lckNo = builder.lckNo;
	}
	
	public static class Builder{
		private String usrId;
		private String usrName;
		private String usrGender;
		private String usrPhoneNum;
		private String usrAddress;
		private String usrDetail;	//회원 설명
		private String usrStatus;	//회원 상태(정산/만료/임박)
		private String joinDate;	//가입 일자
		private String usrExpireDate;	//만료 일자
		private String useYn;	//Y/N, 회원추가 시 자동 Y
		private String enrollTime;	//등록 일시
		private String editTime;	//수정 일시
		
		private String lckNo;	// **String? int?

		public Builder(String usrId, String usrName, String usrGender, String usrPhoneNum, String usrAddress,
				String usrDetail) {
			super();
			this.usrId = usrId;
			this.usrName = usrName;
			this.usrGender = usrGender;
			this.usrPhoneNum = usrPhoneNum;
			this.usrAddress = usrAddress;
			this.usrDetail = usrDetail;
			this.usrStatus = "정산";
			this.useYn = "Y";
			this.lckNo = "없음";
		}
		
		public Builder joinDate(String val) {
			joinDate = val;
			return this;
		}
		
		public Builder usrExpireDate(String val) {
			usrExpireDate = val;
			return this;
		}
		
		public Builder enrollTime(String val) {
			enrollTime = val;
			return this;
		}
		
		public Builder editTime(String val) {
			editTime = val;
			return this;
		}
		
		public Usr1000Vo build() {
			return new Usr1000Vo(this);
		}

	}
	
//		 getter, setter
	public String getUsrId() {
		return usrId;
	}
	
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	public String getUsrName() {
		return usrName;
	}
	
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	
	public String getUsrGender() {
		return usrGender;
	}
	
	public void setUsrGender(String usrGender) {
		this.usrGender = usrGender;
	}
	
	public String getUsrPhoneNum() {
		return usrPhoneNum;
	}
	
	public void setUsrPhoneNum(String usrPhoneNum) {
		this.usrPhoneNum = usrPhoneNum;
	}
	
	public String getUsrAddress() {
		return usrAddress;
	}
	
	public void setUsrAddress(String usrAddress) {
		this.usrAddress = usrAddress;
	}
	
	public String getUsrDetail() {
		return usrDetail;
	}
	
	public void setUsrDetail(String usrDetail) {
		this.usrDetail = usrDetail;
	}
	
	public String getUsrStatus() {
		return usrStatus;
	}
	
	public void setUsrStatus(String usrStatus) {
		this.usrStatus = usrStatus;
	}
	
	public String getJoinDate() {
		return joinDate;
	}
	
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	public String getUsrExpireDate() {
		return usrExpireDate;
	}
	
	public void setUsrExpireDate(String usrExpireDate) {
		this.usrExpireDate = usrExpireDate;
	}
	
	public String getUseYn() {
		return useYn;
	}
	
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	
	public String getEnrollTime() {
		return enrollTime;
	}
	
	public void setEnrollTime(String enrollTime) {
		this.enrollTime = enrollTime;
	}
	
	public String getEditTime() {
		return editTime;
	}
	
	public void setEditTime(String editTime) {
		this.editTime = editTime;
	}
	
	public String getLckNo() {
		return lckNo;
	}
	
	public void setLckNo(String lckNo) {
		this.lckNo = lckNo;
	}

//		toString()
	@Override
	public String toString() {
		return "- 회원 ID : " + usrId + "\n- 회원명 : " + usrName + "\n- 회원 성별 : " + usrGender + "\n- 회원 연락처 : ="
				+ usrPhoneNum + "\n- 회원 주소 : " + usrAddress + "\n- 회원 설명 : " + usrDetail + "\n- 회원 상태 : " + usrStatus
				+ "\n- 가입 일자 : " + joinDate + "\n- 만료 일자 : " + usrExpireDate + "\n- 사용 유무 : " + useYn + "\n- 등록 일시 : "
				+ enrollTime + "\n- 수정 일시 : " + editTime + "\n- 사물함 번호 : " + lckNo + "]";
	}
	

}
