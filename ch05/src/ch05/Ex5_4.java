package ch05;

import java.util.Arrays;

public class Ex5_4 {

	public static void main(String[] args) {
//		배열 요소 섞기
		int[] numArr = {10,20,30,40,50,60,70,80,90};
		System.out.println(Arrays.toString(numArr));
//		길이 9
		
//		100번 반복
		for(int i=0; i<100; i++) {
//			인덱스 0~8 맞추기 위해
			int n = (int)(Math.random()*9);
			int tmp = numArr[0];
			numArr[0] = numArr[n];
			numArr[n] = tmp; 
		}
		
//		배열 길이만큼 반복
		for(int i=0; i<numArr.length; i++) {
			int n = (int)(Math.random()*numArr.length);
			int tmp = numArr[i];
			numArr[i] = numArr[n]; 
			numArr[n] = tmp;
		}
		System.out.println(Arrays.toString(numArr));
		

	}

}
