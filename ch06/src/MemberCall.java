
public class MemberCall {

	int iv = 10;
	static int cv = 20;
	
	int iv2 = cv;
//	Cannot make a static reference to the non-static field iv, 클래스변수는 인스턴스변수 사용불가
//	static int cv2 = iv;
	static int cv2 = new MemberCall().iv;	//이처럼 인스턴스를 생성해야 사용가능
	
	static void staticMethod1() {
		System.out.println(cv);
//		클래스메서드에서 인스턴스변수 사용 불가
//		System.out.println(iv);
		MemberCall c = new MemberCall();
		System.out.println(c.iv);	//이처럼 인스턴스를 생성한 후에야 인스턴스변수 참조 가능
	}
	
	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv);
	}
	
	static void staticMethod2() {
		staticMethod1();
//		클래스메서드에서는 인스턴스 메서드 호출 불가
//		instanceMehod1();
		MemberCall c = new MemberCall();
		c.instanceMethod1();	//이처럼 인스턴스를 생성한 후에야 호출 가능
	}
	
	void instanceMethod2() {
		staticMethod1();
		instanceMethod1();
	}
	
}
