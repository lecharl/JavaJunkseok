
public class VarEx2 {

	public static void main(String[] args) {
//		상수 :: final 타입
//		예전엔 상수는 선언과 초기화를 같이 해야 했지만, 지금은 안해도 오류가 나지 않는다.
//		그러나 선언과 초기화를 같이 하는 게 좋다.
		final int score;
		score = 200;
		System.out.println(score);
//		리터럴 접미사
//		정수형 : L(long), 0b(2진수), 0(8진수), 0x(16진수)
		int octNum = 010;	//8진수 10, 10진수로 8
		int hexNum = 0x10;	//16진수 10, 10진수로 16
		int biNum = 0b10;	//2진수 10, 10진수로 2
		long l1 = 10_000_000_000L; 	//L 필수!! 생략하면 int타입인데 int 범위를 넘기 때문에
		long l2 = 1000;
//		실수형 : f(float), d(double, 생략가능)
		float f1 = 3.14f;	//f 필수!! 생략하면 double타입이기 때문
		float f2 = 10f;		// 10f == 10.0f
		double d1 = 1e3;	// e == 10의 n제곱 => 10의 3제곱 => 1e3 == 1000.0 (더블)
		
		boolean power = true;
		
		byte by = 127;		// -128 ~ 127
		
		System.out.println(octNum);
		System.out.println(hexNum);
		System.out.println(biNum);
		System.out.println(l1);
		
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(.10);
		System.out.println(d1);
		
		int a = 'A';		// 변수는 -20억~20억, 리터럴은 65 이므로 범위가 변수가 더 크기 때문에 ok
		System.out.println(a);
		
		char ch = 'A';		// 반드시 하나의 문자만!!!!!!!!! 
//		char ch0 = '';		// 아예 비어도 에러!!
		
		String str = "";	// 빈 문자열은 String 만
		String str2 = "ABCD";
		String str3 = "123";
		String str4 = str2+str3;
		System.out.println(str4);
		System.out.println(""+7+7);
		System.out.println(7+7+"");
		

	}

}
