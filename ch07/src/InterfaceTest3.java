
public class InterfaceTest3 {

	public static void main(String[] args) {
//		** B를 직접 생성하지 않고, getInstance()를 통해 제공받음
//		나중에 다른 클래스의 인스턴스로 변경되어도 A클래스의 변경없이 getInstance()만 변경하면 된다.
		A a = new A();
		a.methodA();
	}

}

class A{
	void methodA() {
//		제3의 클래스의 메서드를 통해서 인터페이스 I를 구현한 클래스의 인스턴스 B를 얻어온다.
		I i = InstanceManager.getInstance();	//I i = new B();
		i.methodB();	//-> **실제 가리키는 객체 B의 methodB()를 호출
		System.out.println(i);	// 위와 마찬가지, i.toString()이지만 실제 가리키는 객체 B의 toString()을 호출
	}
}

class B implements I{

	@Override
	public void methodB() {
		System.out.println("methodB in class B");
	}
	
	@Override
	public String toString() {
		return "class B!!";
	}
	
}

interface I{
	void methodB();
}

class InstanceManager{
//	I를 구현한 인스턴스, 즉 B만 반환
	public static I getInstance() {
		return new B();
	}
}