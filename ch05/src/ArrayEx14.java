import java.util.Arrays;

public class ArrayEx14 {

	public static void main(String[] args) {
		String src = "ABCDE";
		
//		문자열의 문자 각각을 출력
		for(int i=0; i<src.length(); i++) {
			System.out.printf("src.charAt(%d) : %s\n", i, src.charAt(i));
		}
		
//		String.toCharArray() :: String -> char[] 변환
		char[] chSrc = src.toCharArray();
		System.out.println(Arrays.toString(chSrc));
		
//		new String(char[]) :: char[] -> String 변환
//		char[] 참조변수를 sop로 출력하면 구분자없이 그대로 나오는 거로 이해하자!
		String strSrc = new String(chSrc);
		System.out.println(strSrc);

	}

}
