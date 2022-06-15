package ch08;

public class Ex8_4 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);	//x
		} catch (ArithmeticException ae) {
			if(ae instanceof ArithmeticException) {
//				예외 발생 당시의 호출스택에 있었던 메서드의 정보와 예외 메시지를 화면에 출력한다.
				ae.printStackTrace();
				System.out.println("예외 메시지 : "+ae.getMessage());
			}
			System.out.println("...ArithmeticException");
			System.out.println(5);
		} catch (Exception e) {
			System.out.println("Exception");
		}
		System.out.println(6);

	}

}
