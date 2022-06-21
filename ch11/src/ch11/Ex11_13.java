package ch11;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex11_13 {

	public static void main(String[] args) {
		Set set = new TreeSet();	//저절로 정렬하기 때문에 따로 정렬할 필요가 없다!!
		
//		for(int i=0; set.size()<6; i++) {
		for(; set.size()<6;) {
			int num = (int)(Math.random()*45)+1;	//1<=x<46
			set.add(new Integer(num));
		}

		System.out.println(set);
	}

}
