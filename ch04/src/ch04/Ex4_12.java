package ch04;

public class Ex4_12 {

	public static void main(String[] args) {
		int i = 5;
//		조건식이 평가된 후에!!i 값이 감소된다!!
//		1)i == 5 > 0 참이 되니까 넘어가고
//		2)... i == 1 > 0 참
//		3)i == 0 > 0 거짓!!
		while (i-- > 0) {
//		1)	감소되고 i == 4 -> 4 출력
//		2)	... 감소되고 i == 0 -> 0 출력
			System.out.println(i + " + "+ "I can Do it!");
		}
		int j = 5;
		System.out.println();
//		먼저 감소한 후에!! 평가!!
//		j == 4 > 0 참 -> 4출력
//		... j == 1 > 0 참 -> 1 출력
//		j == 0 > 0 거짓!!
		while (--j > 0) {
			System.out.println(j + " + "+ "I can Do it!");
		}

	}

}
