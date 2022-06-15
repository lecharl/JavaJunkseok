package ch08;

public class Ex8_6 {

	public static void main(String[] args) {
		try {
			Exception ee = new Exception("예외 발생시킴");
			throw ee;
//			throw new Exception("고의로 예외 발생시킴");
		} catch (Exception e) {
			System.out.println("에러 메시지: "+e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램이 정상 종료되었음");

	}

}
