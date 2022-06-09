package ch05;

public class Ex5_3 {

	public static void main(String[] args) {
		int[] score = {79, 88, 91, 33, 100, 55, 95};
		
//		max, min을 배열의 첫번째 값으로 초기화
		int max = score[0];
		int min = score[0];
		
//		[0]으로 정해놨으니 1부터 시작
		for(int i=1; i<score.length; i++) {
			if(score[i]>max) {
				max = score[i];
			}else if(score[i]<min) {
				min = score[i];
			}
		}
		System.out.println("최댓값 : "+max);
		System.out.println("최솟값 : "+min);

	}

}
