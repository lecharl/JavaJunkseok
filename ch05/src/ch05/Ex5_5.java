package ch05;

import java.util.Arrays;

public class Ex5_5 {

	public static void main(String[] args) {
//		로또 (총 45개 번호)
		int[] lotto = new int[45];
//		1~45로 채우기
		for(int i=0; i<lotto.length; i++) {
			lotto[i] = i+1; 
		}
		System.out.println(Arrays.toString(lotto));
//		6개만 섞기
		for(int i=0; i<6; i++) {
			int n = (int)(Math.random()*lotto.length);
			int tmp = lotto[i];
			lotto[i] = lotto[n];
			lotto[n] = tmp;
			System.out.println(Arrays.toString(lotto));			
		}
		
//		6개의 번호 출력(index 0~5)
		for(int i=0; i<6; i++) {
			System.out.printf("lotto[%d] = %d\n", i, lotto[i]);
		}
		
	}

}
