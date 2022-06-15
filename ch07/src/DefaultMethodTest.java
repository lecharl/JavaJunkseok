
public class DefaultMethodTest {

	public static void main(String[] args) {
		Child3 c = new Child3();
		c.method1();
		c.method2();	//실제 가리키는 객체 Child3가 상속받은 Parent3의 method2() 또는 MyInterface의 method2()를 부르는데
//		이럴 경우엔 조상클래스의 메서드가 상속되고 인터페이스의 디폴트메서드는 무시된다.
		MyInterface.staticMethod();
		MyInterface2.staticMethod();
		
	}

}

class Child3 extends Parent3 implements MyInterface, MyInterface2{
//	MyInterface의 method1() 오버라이딩 -> 충돌 해결
	public void method1(){
		System.out.println("method1() in Child");
	}
}


class Parent3{
//	만약 이게 없다면 위에서 호출할 때 MyInterface의 method2()를 갖고옴
	public void method2() {
		System.out.println("method2 in Parent");
	}
}

interface MyInterface{
	default void method1() {
		System.out.println("method1() in MyInterface");
	}
	default void method2() {
		System.out.println("method2() in MyInterface");
	}
	static void staticMethod() {
		System.out.println("staticMethod() in MyInterface");
	}
}

interface MyInterface2{
	default void method1() {
		System.out.println("method1() in MyInterface2");
	}
	static void staticMethod() {
		System.out.println("staticMethod() in MyInterface2");
	}
}