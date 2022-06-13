package ch07;

import static java.lang.Math.*;	//Math클래스의 모든 static 멤버
import static java.lang.System.out;	//System.out이 static변수임!! 이 out만으로 참조가능

public class Ex7_6 {

	public static void main(String[] args) {
		out.println(random());
		out.println("Math.PI : "+PI);	//static변수.. 상수임
	}

}
