package ch11;

import java.util.HashSet;
import java.util.Iterator;

public class Ex11_12 {

	public static void main(String[] args) {
		HashSet setA = new HashSet();
		HashSet setB = new HashSet();
		HashSet setHap = new HashSet();
		HashSet setGyo = new HashSet();
		HashSet setCha = new HashSet();
		
		setA.add("1");
		setA.add("2");
		setA.add("3");
		setA.add("4");
		setA.add("5");
		
		setB.add("4");
		setB.add("5");
		setB.add("6");
		setB.add("7");
		setB.add("8");
		
		System.out.println("setA = "+setA);
		System.out.println("setB = "+setB);
		
		Iterator it = setA.iterator();
//		합집합
		while(it.hasNext())
			setHap.add(it.next());
		it = setB.iterator();
		while(it.hasNext())
			setHap.add(it.next());
		System.out.println("setHap = "+setHap);
		
//		교집합
		it = setB.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();	//이렇게 따로 받아서 해야한다! 
			//바로 contains(it.next())하면 계속 next()..해서 NoSuchElementException
			if(setA.contains(tmp)) 
				setGyo.add(tmp);	
		}
		System.out.println("setGyo = "+setGyo);//????왜 안나오지
		
//		차집합, setA 기준으로 하려면 setA.iterator()
		it = setA.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if(!setB.contains(tmp))
				setCha.add(tmp);	
		}
		System.out.println("setCha = "+setCha);
		
//		메서드 활용
//		setA.addAll(setB);
		System.out.println("합집합 addAll() :: "+setA);	//setA 변경
//		setA.retainAll(setB);
		System.out.println("교집합 retainAll() :: "+setA);	//setA 변경(삭제)
		setA.removeAll(setB);
		System.out.println("차집합 removeAll() :: "+setA);	//setB 변경(삭제)

	}

}
