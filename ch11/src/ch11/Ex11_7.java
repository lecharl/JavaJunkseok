package ch11;

import java.util.Arrays;
import java.util.Comparator;

public class Ex11_7 {

	public static void main(String[] args) {
		String[] strArr = {"cat","Dog","lion","tiger"};
		
//		기본 정렬(오름차순, 사전순) :: Arrays.sort(arr[])
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));
		
//		다른 정렬 :: Arrays.sort(arr[], Comparator)
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);	//대소문자 구분안함, String클래스에 이러한 정렬기준이 존재함
		System.out.println(Arrays.toString(strArr));

		Arrays.sort(strArr, new Descending());
		System.out.println(Arrays.toString(strArr));
	}
	
}

class Descending implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable) o1;
			Comparable c2 = (Comparable) o2;
			return c1.compareTo(c2) * -1;
//			return c2.compareTo(c1);
		}
		return -1;
	}
}