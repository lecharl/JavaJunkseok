package ch06;

public class Ex6_6 {

	public static void main(String[] args) {
//		기본형 매개변수
		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x = "+ d.x);	//x = 10
		
//		*** Ex6_6.change() 이렇게 안해도 되는 이유 :: 1) static 메소드라서 2) *같은 클래스에 있어서
		change(d.x); 
		System.out.println("After change(d.x)");
		System.out.println("main() : x = "+ d.x);	//x = 10

	}

	 static void change(int x) {
		x = 1000;
		System.out.println("change() : x = "+x);	//x = 1000		
	}

}
// 1. Ex6_6.change() 이렇게 안하는 이유는 같은 클래스 내에 있어서?
// 2. static이 아닌 메소드를 호출할 경우 왜 오류가 나는지?

class Data {
	int x;
	
}