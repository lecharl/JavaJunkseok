package ch05;

import java.util.Arrays;

public class Ex5_8 {

	public static void main(String[] args) {
//		2차원 배열
		int[][] score = {
				{100,100,100},
				{20,20,20, 88},
				{30,30,30},
				{40,40,40}
		};
		int sum = 0;
//		출력 1
		for(int i=0; i<score.length; i++) {
			System.out.println(Arrays.toString(score[i]));			
		}
//		출력 2
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				System.out.printf("score[%d][%d] = %d\n", i, j, score[i][j]);
				sum += score[i][j];
			}
		}
		System.out.println("합계 : "+sum);
		
		int sum2 = 0;
//		향상된 포문으로
//		출력 1
		for (int[] is : score) {
			System.out.println(Arrays.toString(is));
		}
//		출력 2
		for (int[] is : score) {
			for (int is2 : is) {
				System.out.println(is2);
				sum2 += is2;
			}
		}
		System.out.println("합계 : "+sum2);

	}

}
