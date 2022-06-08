
public class PrintfEx1 {

	public static void main(String[] args) {
//		나눌 때 실수로 값을 얻고 싶다면 둘 중 하나를 실수로
		System.out.println(10.0/3);
		
		System.out.printf("%d\n", 15);
		System.out.printf("%o\n", 15);	//10진수 15를 8진수로 표현하면 -> 17
		System.out.printf("%x\n", 15);	//10진수 15를 16진수로 표현하면 -> f
		System.out.printf("%s\n", Integer.toBinaryString(15));	//10진수 15를 2진수로 표현하면 -> 1111
		
//		%f ::  소수점 아래 6자리
		float f = 123.456789f;
		System.out.printf("%f\n", f);		//123.456787
//		float는 정밀도가 7자리기 때문에 123.4567 까지만 정확하고 나머지는 의미없다.
		double d = 123.456789;
		System.out.printf("%f\n", d);		//123.456789
		
//		%e :: 지수형식
		System.out.printf("%e\n", f);		//1.234568e+02, 뒤는 반올림해서 보여줌, e+02 : 10의 2제곱
		
//		%g :: 간략한 형식, 소수점 포함 7자리
		System.out.printf("%g\n", f);		//123.457, 뒤는 반올림해서 보여줌
		
		System.out.println();
		System.out.printf("[%5d]\n", 10);	//[   10], 나머진 빈칸으로
		System.out.printf("[%5d]\n", 1234567);	//[1234567], 그대로
		System.out.printf("[%-5d]\n", 10);	//[10   ], 왼쪽정렬
		
		double d1 = 1.23456789;
		System.out.printf("[%14f]\n", d1);		//[      1.234568]
		System.out.printf("[%14.10f]\n", d1); 	//[  1.2345678900]
		System.out.printf("[%14.6f]\n", d1); 	//[      1.234568]
		
		String s1 = "www.codechobo.com";
		System.out.printf("[%s]\n", s1);		//[www.codechobo.com]
		System.out.printf("[%20s]\n", s1);		//[   www.codechobo.com]
		System.out.printf("[%-20s]\n", s1);		//[www.codechobo.com   ]
		System.out.printf("[%.10s]\n", s1);		//[www.codech]
		

	}

}
