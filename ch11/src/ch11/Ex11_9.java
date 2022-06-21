package ch11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex11_9 {

	public static void main(String[] args) {
		Object[] objArr = {"1", new Integer(1), "2", "2", "3", "3", "4", "4", "4"};
		Set set = new HashSet();
		
		for (Object object : objArr) {
			set.add(object);
		}
//		출력1
		System.out.println(set);
		
//		출력2 : Iterator
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
//		주의) 그런데 Set은 순서X 이므로, add한 순서대로 출력이 안될 수도 있다!!

	}

}
