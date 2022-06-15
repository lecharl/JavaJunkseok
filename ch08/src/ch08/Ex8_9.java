package ch08;

public class Ex8_9 {

	// 결국 main()도 JVM에 떠넘겨서 JVM이 처리, 기본 예외처리가 출력
	public static void main(String[] args) throws Exception{	//6. 떠넘기기 -> JVM 기본 예외처리
		method1();//5. 예외 옴 -> 캐치블럭 없음 -> 메소드 예외 선언
	}
	
	static void method1() throws Exception{	//4. 떠넘기기 -> 호출한 곳으로
		method2();	//3. 예외 옴 -> 캐치블럭 없음 -> 메소드 예외 선언
	}
	
	static void method2() throws Exception{	//2. 떠넘기기-> 호출한 곳으로
		throw new Exception();	//1. 예외 발생시킴. 캐치블럭 없다? -> 메소드 예외 선언
	}

}

// ** 결국 마지막에라도 캐치블럭이 있어야 한다!!