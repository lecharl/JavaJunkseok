package ch07;

public class InterfaceTest {

	public static void main(String[] args) {
		A a = new A();
		a.method(new C());
	}

}

class A {
//	I를 구현한 인스턴스만 들어와라
	void method(I i) {
		i.method();
	}
}

interface I{
	void method();
}

class B implements I{
	public void method() {
		System.out.println("B의 메서드");
	}
}

class C implements I{
	public void method() {
		System.out.println("C의 메서드");
	}
}