package ch09;

public class Ex9_10 {

	public static void main(String[] args) {
		int i1 = 100;
		double i2 = 200.0;
		
//		숫자 -> 문자열
//		1) + ""
		String str1 = i1+ "";
//		2) String.valueOf(?)
		String str2 = String.valueOf(i2);
//		String str2 = i2 +"";
		
		System.out.println("str1 = "+str1);
		System.out.println("str2 = "+str2);
		
//		아래 "+"는 부호임. "-"로 하면 -100 + 200.0 = -100.0 이 됨
		double sum1 = Integer.parseInt("+"+str1) + Double.parseDouble(str2);
		double sum2 = Integer.valueOf(str1) + Double.valueOf(str2);
		
		System.out.println(sum1);
		System.out.println(sum2);
		
//		String.join("구분자", 문자열 가변인자...)
		String j1 = String.join("#", str1, "+", str2, "=") + sum1;
		String j2 = String.join("", str1, "+", str2, "=") + sum1;
		System.out.println(j1);
		System.out.println(j2);
	}

}
