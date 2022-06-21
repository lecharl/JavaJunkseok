package ch11;

import java.util.Set;
import java.util.TreeSet;

public class Ex11_15 {

	public static void main(String[] args) {
//		Set set = new TreeSet();
		TreeSet set = new TreeSet();
		int[] score = {80,95,50,35,45,65,10,100};
		
//		for(int i=0; i<score.length; i++) {
//			set.add(new Integer(score[i]));
//		}
		for (int i : score) {
			set.add(new Integer(i));
		}
		System.out.println(set);
//		System.out.println("50보다 작은 값 :: "+ ((TreeSet) set).headSet(new Integer(50)));
		System.out.println("50보다 작은 값 :: "+ set.headSet(new Integer(50)));
		System.out.println("50이상인 값 :: "+set.tailSet(new Integer(50)));
		System.out.println("40보다 80사이의 값 :: "+set.subSet(40, 80));
	}

}
