package ch11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ex11_18 {

	public static void main(String[] args) {
		String[] data = { "A","K","A","K","D","K","A","K","K","K","Z","D" };
		HashMap map = new HashMap();
		
		for(int i=0; i<data.length; i++) {
			if(map.containsKey(data[i])) {
				int value = (int) map.get(data[i]);
//				value++; 하면 안된다!! 저장이 안되잖아!!
				map.put(data[i], value+1);
			}else {
				map.put(data[i], 1);
			}
		}
		System.out.println(map);
//		Set set = map.entrySet();
//		Iterator it = set.iterator();
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry me = (Map.Entry)it.next();
			System.out.println(me.getKey()+ " : "+printBar('#', (int)me.getValue())+" "+me.getValue());
		}

	}//main
	
	public static String printBar(char ch, int value) {
		char[] bar = new char[value];
		for(int i=0; i<value; i++) {
			bar[i] = ch;
		}
		return new String(bar);
	}

}
