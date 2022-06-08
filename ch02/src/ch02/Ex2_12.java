package ch02;

public class Ex2_12 {

	public static void main(String[] args) {
		String str = "3";
		
//		문자열 -> 문자 :: str.charAt(0)
		System.out.println(str.charAt(0));
//		문자 -> 숫자 :: 문자 - '0'
		System.out.println('3' - '0');
		System.out.println('3' - '0' + 2);
		System.out.println('3' + 1);	// '0' == 48 -> 48+3 = 51
		System.out.println('3' + '1');	// '1' == 48+1 -> = 51 + 49
		System.out.println((char)(3 + '0'));
		

	}

}
