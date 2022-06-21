package ch11;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Ex11_13_2 {

	public static void main(String[] args) {
		Set set = new TreeSet(new TestComp());	//저절로 정렬하기 때문에 따로 정렬할 필요가 없다!!
		
//		for(int i=0; set.size()<6; i++) {
		for(; set.size()<6;) {
			int num = (int)(Math.random()*45)+1;	//1<=x<46
			set.add(new Test());
		}

		System.out.println(set);
	}

}

class Test implements Comparable{
//	비교기준
	@Override
	public int compareTo(Object o) {
		return -1;
	}
}

class TestComp implements Comparator{
//	비교기준, TreeSet(Comparator)
	@Override
	public int compare(Object o1, Object o2) {
		return 1;
	}
}