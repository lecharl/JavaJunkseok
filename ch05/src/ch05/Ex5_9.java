package ch05;

public class Ex5_9 {

	public static void main(String[] args) {
//		5명의 학생의 세 과목 점수를 더해서 각 학생의 총점과 평균을 구하고
//		과목별 총점 계산
		int[][] score = {
				{100,100,100},
				{20,20,20},
				{30,30,30},
				{40,40,40},
				{50,50,50}
		};
//		과목별 총점
		int korSum = 0;
		int engSum = 0;
		int mathSum = 0;
		
		System.out.println(" 번호  국어  영어  수학   총점   평균 ");
		System.out.println("=====================================");
		for(int i=0; i<score.length; i++) {
//			학생별 총점과 평균 초기화
			int sum = 0;
			double avg = 0.0;
			System.out.printf("%3d", i+1);
			korSum += score[i][0];
			engSum += score[i][1];
			mathSum += score[i][2];
			for(int j=0; j<score[i].length; j++) {
				System.out.printf("%5d", score[i][j]);
				sum += score[i][j];
			}
			avg = sum / (double)score[i].length;
			System.out.printf("%5d %6.1f", sum, avg);
			System.out.println();
		}
		System.out.printf("총점 : %3d %4d %4d", korSum, engSum, mathSum);

	}

}
