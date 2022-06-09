package ch04;

public class Ex4_13 {

	public static void main(String[] args) {
//		0부터 x까지 더하는데, 100을 넘지 않는 최댓값 x 구하기
		int i = 0;
		int sum = 0;
//		i를 1씩 증가시켜서 sum에 계속 더해나간다.
		/*
		 * 0 - 0
		 * 1 - 1
		 * 2 - 3
		 */
		while(sum<=100) {
			System.out.printf("%d - %d\n", i, sum);
//			sum += ++i;
			i++;
			sum += i;
		}
		

	}

}
