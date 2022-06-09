package ch05;

import java.util.Arrays;

public class Ex5_2 {

	public static void main(String[] args) {
		int[] score = {100, 88, 100, 100, 90};
		int sum = 0;
		double average = 0.0;
		
//		출력
		System.out.println(Arrays.toString(score));
		
//		총점
		for(int i=0; i<score.length; i++) {
			sum += score[i];
		}
//		for (int i : score) {
//			sum += i;
//		}
		System.out.println("총점 : "+sum);
		
//		평균
//		!!둘 중 하나를 float나 double로 하는 거 잊지 말기!!
		average = sum / (double)score.length;
		System.out.println("평균 : "+average);
		

	}

}
