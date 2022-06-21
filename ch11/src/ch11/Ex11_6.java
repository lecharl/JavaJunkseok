package ch11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex11_6 {

	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4};
		int[][] arr2D = {{11,12,13}, {21,22,23}};
		
//		출력 :: toString(arr[]), deepToString(arr[][])
		System.out.println("arr = "+Arrays.toString(arr));
		System.out.println("arr2D = "+Arrays.toString(arr2D));
		System.out.println("arr2D = "+Arrays.deepToString(arr2D));
		System.out.println();
		
//		복사 :: copyOf(arr[], 길이), copyOfRange(arr[], from, to)
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		int[] arr3 = Arrays.copyOf(arr, 3);
		int[] arr4 = Arrays.copyOf(arr, 7);
		int[] arr5 = Arrays.copyOfRange(arr, 2, 4);
		int[] arr6 = Arrays.copyOfRange(arr, 0, 7);
		
		System.out.println("arr2 = "+Arrays.toString(arr2));
		System.out.println("arr3 = "+Arrays.toString(arr3));
		System.out.println("arr4 = "+Arrays.toString(arr4));
		System.out.println("arr5 = "+Arrays.toString(arr5));
		System.out.println("arr6 = "+Arrays.toString(arr6));
		System.out.println();
		
//		채우기 :: fill(arr[], 값), setAll(arr[], 람다식)
		int[] arr7 = new int[5];
		Arrays.fill(arr7, 9);
		System.out.println("arr7 = "+Arrays.toString(arr7));
		
		Arrays.setAll(arr7, i -> (int)(Math.random()*6 + 1));	//1<=x<7
		System.out.println("arr7 = "+Arrays.toString(arr7));
		for (int i : arr7) {
			char[] charArr = new char[i];	//길이 1~6 랜덤
			Arrays.fill(charArr, '*');
			System.out.println(new String(charArr)+i);	//char[] -> String :: new String(char[])
		}
		System.out.println();
		
//		동등비교 :: equals(arr1[], arr2[]), deepEquals(arr1[][], arr2[][])
		String[][] str2D = new String[][] {{"aaa","bbb"}, {"AAA","BBB"}};
		String[][] str2D2 = new String[][] {{"aaa","bbb"}, {"AAA","BBB"}};
		System.out.println("Arrays.equals(str2D, str2D2) :: "+Arrays.equals(str2D, str2D2));
		System.out.println("Arrays.deepEquals(str2D, str2D2) :: "+Arrays.deepEquals(str2D, str2D2));
		System.out.println();
		
//		정렬 :: sort(arr[])
//		탐색 :: sort() -> binarySearch(arr[], ?)
		char[] chArr = {'A','D','C','B','E'};
		System.out.println("chArr = "+Arrays.toString(chArr));
		System.out.println("indexOf 'B' = "+Arrays.binarySearch(chArr, 'B'));	//-2 가 나옴, 오름차순 정렬이 안돼서 그럼!
		System.out.println("== After sort() ==");
		Arrays.sort(chArr);
		System.out.println("chArr = "+Arrays.toString(chArr));
		System.out.println("indexOf 'B' = "+Arrays.binarySearch(chArr, 'B'));
		System.out.println();
		
//		배열을 List로 변환 :: asList(Object...)
		List list = Arrays.asList(new Integer[] {1,2,3,4,5});
		List list2 = Arrays.asList(1,2,3,4,5);	//1)각 요소가 Integer로 오토박싱이 일어나서
		List list3 = Arrays.asList(arr);	//2)
		List list4 = new ArrayList(Arrays.asList(arr));	//2)arr 그자체는 참조형 데이터인데, 각 요소는 기본형 데이터다.
		System.out.println("list = "+list);
		System.out.println("list2 = "+list2);	//1)참조형 데이터로 받아져 각 list의 요소로 출력함
		System.out.println("list3 = "+list3);	//2)그래서 이렇게 통으로 출력할 때 arr을 한 요소로 보고 참조값 해시(주소)를 출력한다.
		System.out.println("list4 = "+list4);	
//		list4.add(9);
//		list.add(6); -> UnsupportedOperationException, 크기 변경 불가능!!!
//		크기 변경, 추가, 삭제하려면? => new ArrayList(Arrays.asList(1,2,3,4,5))
		
		//2)따라서 아래처럼 반복문을 사용해 add해야 한다!!
		List list5 = new ArrayList();
		for (int i : arr) {
			list5.add(i);
		}
		System.out.println("list5 = "+list5); //..맞나?? asList 어케 하지
		
	}

}
