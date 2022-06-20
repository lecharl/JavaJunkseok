package ch11;

import java.util.ArrayList;
import java.util.Collections;

public class Ex11_1 {

	public static void main(String[] args) {
		ArrayList list1 = new ArrayList(10);
//		추가
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		System.out.println("list1.size() :: "+list1.size());
		
//		추출 :: **읽기전용이라 새 list로 받아야 한다!!
		ArrayList list2 = new ArrayList(list1.subList(1, 4));	//1~3
		print(list1, list2);
		
//		정렬 :: util클래스 Collections.sort() .. list1.sort()와 다른거임!!
		Collections.sort(list1);
		Collections.sort(list2);
		print(list1, list2);
		
//		합집합?
		System.out.println("list1.containsAll(list2) ? :: "+list1.containsAll(list2));
		
		list2.add("B");
		list2.add("C");
		print(list1, list2);
//		추가 - 인덱스 지정
		list2.add(3, "A");
		print(list1, list2);
		
//		변경
		list2.set(3, "AA");
		print(list1, list2);
		
//		문자열 "1" 넣기
		list1.add(0, "1");
		print(list1, list2);
//		검색
		System.out.println("list1.indexOf(\"1\") :: "+list1.indexOf("1"));
		System.out.println("list1.indexOf(1) :: "+list1.indexOf(1));
		System.out.println();
		
//		삭제 :: remove(인덱스), remove(객체)
//		list1.remove(0);
//		list1.remove("1");
		list1.remove(new Integer(1));
		print(list1, list2);
		

//		차집합? list1에서 겹치는 부분만 남기고 나머지 삭제
		System.out.println("list1.retainAll(list2) ? :: "+list1.retainAll(list2));
		print(list1, list2);
		
//		list2에서 list1에 포함된 객체들을 삭제
//		**만약 i++하면서 삭제하면, 한 요소가 삭제될 때마다 빈 공간을 채우기 위해 나머지 요소들이 자리이동하기 때문에
//		**꼭!! i--로 감소하면서 하기!!
		for(int i=list2.size()-1; i>=0; i--) {
			if(list1.contains(list2.get(i))) {	//**주의!! list1에서 contains() !!
				list2.remove(i);
			}
		}
		print(list1, list2);
		
	}
	
	public static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1 : "+list1);
		System.out.println("list2 : "+list2);
		System.out.println();
	}

}
