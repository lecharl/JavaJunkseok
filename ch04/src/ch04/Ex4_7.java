package ch04;

public class Ex4_7 {

	public static void main(String[] args) {
//		Q1. 1~10 사이의 난수를 20개 출력하기
		//10개 -> 10 곱하기, 시작숫자가 1이므로 +1
		//0.0 <= x < 1.0
		//0.0 <= x*10 < 10.0
		//0 <= (int)(x*10) < 10
		//1 <= (int)(x*10) + 1 < 11
//		for(int i=0; i<20; i++) {
//			System.out.println((int)(Math.random()*10) + 1);
//		}
		
		
//		Q2. -5~5사이의 난수 20개 출력하기
		//11개 -> 11 곱하기, 시작숫자가 -5이므로 -5
		//0.0 <= x < 1.0
		//0.0 <= x*11 < 11.0
		//0 <= (int)(x*11) < 11
		//-5 <= (int)(x*11) - 5 < 6
		for(int i=0; i<20; i++) {
			System.out.println((int)(Math.random()*11) - 5);
		}

	}

}
