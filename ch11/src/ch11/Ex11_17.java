package ch11;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ex11_17 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("김자바", new Integer(90));
		map.put("김자바", new Integer(100));
		map.put("이자바", new Integer(100));
		map.put("강자바", new Integer(90));
		map.put("안자바", new Integer(90));
		System.out.println("map = "+map);
		
//		읽어오기 :: entrySet(), iterator()
		Set set = map.entrySet();	//entrySet() -> Set
		System.out.println("map.entrySet() = "+set);
		Iterator it = set.iterator();
		while(it.hasNext()) {
//			**주의) it.next()를 Map.Entry 로 형변환!!
			Map.Entry me = (Map.Entry)it.next(); 
			System.out.println("이름 : "+me.getKey()+", 성적 : "+me.getValue());
		}
		
//		keySet() -> Set
		set = map.keySet();
		System.out.println("참가자 명단 map.keySet() : "+set);
		
//		values() -> Collection
		Collection values = map.values();
		System.out.println("map.values() : "+values);
		it = values.iterator();
		int total = 0;
		while(it.hasNext()) {
			int i = (int) it.next();
			total += i;
//			Integer i = (Integer)it.next();
//			total += i.intValue();	//intValue() :: Integer -> int
		}
		System.out.println("총점 :: "+total);
		System.out.println("평균 :: "+(double)total/set.size());	//set.size()
//		**주의) Collections.max(Comparble을 구현한 객체만)
		System.out.println("최고점수 :: "+Collections.max(values));
		System.out.println("최저점수 :: "+Collections.min(values));
	}

}
