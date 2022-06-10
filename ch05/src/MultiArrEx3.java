import java.util.Arrays;

public class MultiArrEx3 {

	public static void main(String[] args) {
//		두 행렬의 곱 구하기
//		행렬의 곱 조건 :: m1의 열의 길이 == m2의 행의 길이
//		행렬의 곱 결과 :: m3의 행의 길이 == m1의 행의 길이, m3의 열의 길이 == m2의 열의 길이
		
//		2행 3열
		int[][] m1 = {
				{1, 2, 3},
				{4, 5, 6}
		};
//		3행 2열
		int [][] m2 = {
				{1, 2},
				{3, 4},
				{5, 6}
		};
		
		final int ROW = m1.length;	//m1의 행 길이, 2
		final int COL = m2[0].length;	//m2의 열 길이, 2
//		이건 왜?
		final int M2_ROW = m2.length;	//m2의 행 길이, 3
		
//		2행 2열
		int[][] m3 = new int[ROW][COL];
		
//		m3 = m1 * m2
		for(int i=0; i<ROW; i++) {		//m3의 행
			for(int j=0; j<COL; j++) {	//m3의 열
				for(int k=0; k<M2_ROW; k++) {	//m2의 열
					m3[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		
//		m3 출력
		for (int[] is : m3) {
			System.out.println(Arrays.toString(is));
		}
		for(int i=0; i<m3.length; i++) {
			for(int j=0; j<m3[i].length; j++) {
				System.out.printf("%3d ", m3[i][j]);
			}
			System.out.println();
		}
		
	}

}
