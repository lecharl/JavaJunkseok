package test1;

public class FindSevenTest {

	public static void main(String[] args) {
		int count = 0;
		for(int i=1; i<77778; i++) {
			int tmp=i;
//			System.out.print("i= "+i);
			while(tmp != 0) {
				if(tmp%10%7 == 0 && tmp%10 != 0) {
					count++;
//					System.out.print(", 짝 "+count);
				}
				tmp /= 10;
			}
//			System.out.println();
		}
		System.out.println("7의 개수 : "+count);
		
//		두번째 방법
		int cnt = 0;
		for(int i=1; i<77778; i++) {
//			1) char배열로 만들기
			String iStr = i+"";	//이거 대신 String.valueOf(i) 이 더 
			char[] charArr = iStr.toCharArray();
//			2) char배열의 요소 각각이 일치하는지
			for(int j=0; j<charArr.length; j++) {
				if(charArr[j] == '7') {
					cnt++;
				}
			}
		}
		System.out.println("7의 개수 : "+cnt);
	}

}
