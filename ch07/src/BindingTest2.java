
public class BindingTest2 {

	public static void main(String[] args) {
		Parent1 p = new Child1();
		Child1 c = new Child1();
		
//		**인스턴스 변수**는 **참조변수의 타입**에 따라 달라진다.
		System.out.println("p.x = "+p.x);
		System.out.println("c.x = "+c.x);

//		**메서드**는 참조변수의 타입에 관계 없이 항상 **실제 가리키는 인스턴스 타입**에 따라 달라진다.
		p.method();
		c.method();
	}

}

class Parent1{
	int x = 100;
	void method() {
		System.out.println("Parent Method");
	}
}

class Child1 extends Parent1{
//	int x = 200;
//	void method() {
//		System.out.println("Child Method");
//	}
}