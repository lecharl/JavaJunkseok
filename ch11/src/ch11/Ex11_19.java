package ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class Ex11_19 {

	public static void main(String[] args) {
//		Collections
		List list = new ArrayList();
		
//		addAll(Collection, T...)
		Collections.addAll(list, 1,2,3,4,5,6);	//한번에 add하기 좋네!
		System.out.println(list);

//		rotate(List, int a) :: 오른쪽으로 a칸 이동 
		Collections.rotate(list, 2);	//오른쪽으로 2칸 이동
		System.out.println(list);
		
//		swap(List, int a, int b) :: 인덱스 a, b의 위치를 변경
		Collections.swap(list, 0, 2);
		System.out.println(list);
		
//		shuffle(List) :: 섞기
		Collections.shuffle(list);
		System.out.println(list);
		
//		sort(List, Comparator) :: 내림차순
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		
//		reverse(List) :: 뒤집기
		Collections.reverse(list);
		System.out.println(list);
		
//		sort(List) :: 오름차순
		Collections.sort(list);
		System.out.println(list);
		
//		binarySearch(List, T key)
		int idx = Collections.binarySearch(list, 3);	//3이 저장된 위치 반환
		System.out.println("index of 3 = "+idx);
		
//		max(Collection), max(Collection, Comparator)
		System.out.println("max = "+Collections.max(list));
		System.out.println("min = "+Collections.min(list));
		System.out.println("min = "+Collections.max(list, Collections.reverseOrder()));
		
//		fill(List, T) :: 채우기
		Collections.fill(list, 9);
		System.out.println(list);
		
//		nCopies(int, T) :: list와 같은 크기의 새로운 list를 생성하고 2로 채운다. 
		List newList = Collections.nCopies(list.size(), 2);
		System.out.println("newList = "+newList);	
		//단 결과는 변경불가!!
		
//		disjoint(Collection c1, Collection c2) :: 공통요소가 없으면 true
		System.out.println(Collections.disjoint(list, newList));
		
//		copy(List dest, List src) :: src를 desc에 복사
		Collections.copy(list, newList);
		System.out.println("newList = "+newList);
		System.out.println("list = "+list);
		
//		replaceAll(List, T oldVal, T newVal
		Collections.replaceAll(list, 2, 1);	//키가 2인 객체들을 다 1로 바꾸기
		System.out.println(list);
		
//		enumeration(Collection)
		Enumeration e = Collections.enumeration(list);
//		list(Enumeration) -> Arraylist
		ArrayList list2 = Collections.list(e);
		System.out.println("list2 = "+list2);
	}

}
