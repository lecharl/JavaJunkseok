import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapEx1 {

	public static void main(String[] args) {
		String[] data = { "A","K","A","K","D","K","A","K","K","K","Z","D" };
		TreeMap map = new TreeMap();
		
		for(int i=0;i<data.length; i++) {
			if(map.containsKey(data[i])) {
				int value = (int)map.get(data[i]);
				map.put(data[i], value+1);
			}else {
				map.put(data[i], 1);
			}
		}
		
		System.out.println(map);
		
//		읽어오기 iterator()
		Iterator it = map.entrySet().iterator();
		
		System.out.println("== 기본정렬 ==");
		while(it.hasNext()) {
			Map.Entry me = (Map.Entry)it.next();
			System.out.println(me.getKey()+" : "+printBar('*', (int)me.getValue())+ " "+me.getValue());
		}
		System.out.println();
		
//		**정렬 :: Map -> Set(entrySet()) -> ArrayList로 변환한 다음에 Collections.sort()로 정렬
		Set set = map.entrySet();
		List list = new ArrayList(set);	//ArrayList(Collection c)
		
//		static void sort(List list, Comparator c) .. Collections.sort(list, 정렬기준)
		Collections.sort(list, new ValueComparator());
		it = list.iterator();
		
		System.out.println("== 값의 크기가 큰 순서로 정렬 ==");
		while(it.hasNext()) {
			Map.Entry me = (Map.Entry)it.next();
			int value = (int) me.getValue();
			System.out.println(me.getKey() + " : "+printBar('@', value) + " "+value);
		}
		
		
	}//main()

	private static String printBar(char c, int value) {
		char[] chArr = new char[value];
		for(int i=0; i<value; i++) {
			chArr[i] = c;
		}
		return new String(chArr);
	}//printBar()
	
	static class ValueComparator implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			if(o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
				Map.Entry e1 = (Map.Entry) o1;
				Map.Entry e2 = (Map.Entry) o2;
				int v1 = (int) e1.getValue();
				int v2 = (int) e2.getValue();
				return v2-v1;
			}
			return -1;
		}
		
	}

}
