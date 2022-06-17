package test2;

import java.util.Arrays;

public class FindStringTest {

	public static void main(String[] args) {
		String str = "안녕하ㄴㄹㄹf안녕하ㄴㅇ안녕 아러안녕하니아ㅓㅣㅓㅣㅓ아영니ㅣ;;;ㅣㅣ안ㄷㄷ녕 ㄷㅈ 난 ㄴ이ㅣㅓㅣ"
				+ "리ㅣㅓㅣㅣssk안녕 하ㄴㅇ리ㅓㅣ안 ㄴㅇ리ㅓㅣ녀ㅇㅇ이ㅣㅣㅣㅣ"
				+ "ㅁㄴㄴㄴ안녕한하 ㅇㄴ리  안녕하ddd";
		String hi = "안녕하";
		/*
		 * str.indexOf(hi, 0) == 4
		 * str.indexOf(hi, 0+hi.length()) == 4
		 * str.indexOf(hi, 4+hi.length()) == 14
		 * str.indexOf(hi, 14+hi.length()) == 94
		 * ...
		 * str.lastIndexOf(hi) == 94
		 */
		System.out.println(str.length());
		int index = 0;
		int count = 0;
		
//		if(str.indexOf(hi, 0) == 0){
//			count++;
//			System.out.println("인덱스 : "+0);
//		}
//		while(index != -1) {
//			index = str.indexOf(hi, index+hi.length());	
//			if(index != -1) {
//				count++;
//				System.out.println("인덱스 : "+index);				
//			}
//		}
		
		while(index != -1) {
			index = str.indexOf(hi, index);
			if(index!=-1) {
				count++;
				index = index + hi.length();
				System.out.println("인덱스 : "+index);
			}
		}
		
		System.out.println("개수 : "+count);
		
//		두번째 split()
		String[] sArr = str.split(hi);
		System.out.println(Arrays.toString(sArr));
		System.out.println(sArr.length);
		
		int cnt = (str.lastIndexOf(hi) + hi.length() != str.length() || sArr.length == 1)? sArr.length - 1 : sArr.length;
		System.out.println("개수 : "+cnt);
		
		/*
		 * 주의1) 마지막에 hi로 끝나지 않으면 -1
		 * str.lastIndexOf(hi) + hi.length() != str.length()
		 * 주의2) 하나도 없다면(sArr.length == 1) -1
		 */
	}

}
