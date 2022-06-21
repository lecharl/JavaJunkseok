package ch11;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Ex11_10 {

	public static void main(String[] args) {
		Set set = new HashSet();
		System.out.println(set.size());
//		size가 0~5까지 들어감 -> size == 6
		for(int i=0; set.size() <6; i++) {
			int num = (int)(Math.random()*45) + 1;	//1<=x<46
			set.add(new Integer(num));
		}
		System.out.println(set);
//		set이므로 정렬관련 메서드가 없다 -> List로 바꿔서 정렬하기!!(ArrayList / LinkedList)
		
		List list = new LinkedList(set);	//LinkedList(Collection c)
		Collections.sort(list);		// Collections.sort(List list)
		System.out.println(list);
	}

}
