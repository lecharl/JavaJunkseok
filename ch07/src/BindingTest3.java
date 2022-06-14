
public class BindingTest3 {

	public static void main(String[] args) {
		Parent2 p = new Child2();
		Child2 c = new Child2();
		
//		**인스턴스 변수**는 **참조변수의 타입**에 따라 달라진다.
//		**메서드**는 참조변수의 타입에 관계 없이 항상 **실제 가리키는 인스턴스 타입**에 따라 달라진다.
		System.out.println("p.x = "+p.x);
		p.method();
		System.out.println();

		System.out.println("c.x = "+c.x);
		c.method();
	}

}

class Parent2{
	int x = 100;
	void method() {
		System.out.println("Parent Method");
	}
}

class Child2 extends Parent2{
	int x = 200;
	void method() {
		System.out.println("x = "+x);	//this.x
		System.out.println("super.x = "+super.x);
		System.out.println("this.x = "+this.x);
	}
}