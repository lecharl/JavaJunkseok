package ch05;

import java.util.Arrays;

public class Ex5_6 {

	public static void main(String[] args) {
//		가위바위보 랜덤하게 출력
		String[] strArr = {"가위", "바위", "보"};
		System.out.println(Arrays.toString(strArr));
		for(int i=0; i<10; i++) {
//			0~2
			int n = (int)(Math.random()*3);
			System.out.println(strArr[n]);
		}

	}

}
