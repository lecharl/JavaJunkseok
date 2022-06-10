package ch06;

public class Ex6_7 {

	public static void main(String[] args) {
//		참조형 매개변수
		Data2 d = new Data2();
		d.x = 10;
		System.out.println("main() : x = "+ d.x);	//10
		
		change(d);
		System.out.println("After change(d)");
		System.out.println("main() : x = "+ d.x);	//1000

	}

	static void change(Data2 d) {
		d.x = 1000;
		System.out.println("change() : x = "+ d.x);	//1000
	}

}

class Data2{
	int x;
}