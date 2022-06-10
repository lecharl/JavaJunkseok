package ch05;

import java.util.Arrays;

public class Ex5_11 {

	public static void main(String[] args) {
//		Arrays클래스의 메소드
		int[] arr = {0,1,2,3,4};
		int[] arr1 = {0,1,2,3,4};
		int[][] arr2 = {
				{11,22},
				{21,22}
		};
//		1. 출력
//		1-1) 1차원배열 출력
		System.out.println(Arrays.toString(arr));
//		1-2) 2차원배열 출력
		System.out.println(Arrays.deepToString(arr2));
		
//		2. 비교
		String[][] strArr = {{"aaa","bbb"},{"AAA","BBB"}};
		String[][] strArr2 = {{"aaa","bbb"},{"AAA","BBB"}};
		
//		2-1) 1차원 배열 비교
		System.out.println(Arrays.equals(arr, arr1));
//		2-2) 2차원 배열 비교
		System.out.println(Arrays.deepEquals(strArr, strArr2));
		
//		3. 복사
//		3-1) 길이 지정
		int[] arrCopy = Arrays.copyOf(arr1, arr1.length);
		System.out.println(Arrays.toString(arrCopy));
		int[] arrCopy2 = Arrays.copyOf(arr1, 7);
		System.out.println(Arrays.toString(arrCopy2));
		int[] arrCopy3 = Arrays.copyOf(arr1, 3);
		System.out.println(Arrays.toString(arrCopy3));
		String[][] strCopy = Arrays.copyOf(strArr, strArr.length);
		System.out.println(Arrays.deepToString(strCopy));
//		3-2) 범위 지정
		String[][] strCopy2 = Arrays.copyOfRange(strArr, 0, 3);
		System.out.println(Arrays.deepToString(strCopy2));
		String[][] strCopy3 = Arrays.copyOfRange(strArr, 0, 1);
		System.out.println(Arrays.deepToString(strCopy3));
		
		int[] arrRanC = Arrays.copyOfRange(arr1, 2, 4);
		System.out.println(Arrays.toString(arrRanC));
		int[] arrRanC2 = Arrays.copyOfRange(arr1, 2, 7);
		System.out.println(Arrays.toString(arrRanC2));
		
//		4. 정렬(오름차순)
		int[] arrS = {3,4,1,0,2};
		System.out.println(Arrays.toString(arrS));
		Arrays.sort(arrS);
		System.out.println(Arrays.toString(arrS));

	}

}
