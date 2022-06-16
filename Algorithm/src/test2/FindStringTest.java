package test2;

public class FindStringTest {

	public static void main(String[] args) {
		String str = "ㄴㄹㄹf안녕하ㄴㅇ안녕 아러안녕하니아ㅓㅣㅓㅣㅓ아영니ㅣ;;;ㅣㅣ안ㄷㄷ녕 ㄷㅈ 난 ㄴ이ㅣㅓㅣ"
				+ "리ㅣㅓㅣㅣssk안녕 하ㄴㅇ리ㅓㅣ안 ㄴㅇ리ㅓㅣ녀ㅇㅇ이ㅣㅣㅣㅣ"
				+ "ㅁㄴㄴㄴ안녕한하 ㅇㄴ리  안녕하";
		String hi = "안녕하";
		/*
		 * str.indexOf(hi, 0) == 4
		 * str.indexOf(hi, 4+hi.length()) == 14
		 * str.indexOf(hi, 14+hi.length()) == 94
		 */
//		System.out.println(hi.length());
//		System.out.println(str.indexOf(hi, 14+hi.length()));
		int index = 0;
		int count = 0;
		while(index != -1) {
			index = str.indexOf(hi, index+hi.length());
			if(index != -1) {
				count++;
				System.out.println(index);				
			}
		}
	}

//	static int findString(String str, String toFind) {
//		if(str.indexOf(toFind, 0)) {
//			return 0;
//		}else {
//			return findString(str, toFind);
//		}
//	}
}
