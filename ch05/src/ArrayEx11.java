import java.util.Arrays;

public class ArrayEx11 {

	public static void main(String[] args) {
//		빈도수 구하기
		int[] nArr = new int[10];
//		1. 빈도수 배열*** 만들기
		int[] count = new int[10];
		
//		2. 채우기
		for(int i=0; i<nArr.length; i++) {
//			0~9
			nArr[i] = (int)(Math.random()*nArr.length); 
		}
		System.out.println(Arrays.toString(nArr));
		
//		3. count
		for(int i=0; i<nArr.length; i++) {
			count[nArr[i]]++;
		}
		
//		출력
		for(int i=0; i<count.length; i++) {
			System.out.printf("%d의 개수 : %d\n",i, count[i]);
		}

	}

}
