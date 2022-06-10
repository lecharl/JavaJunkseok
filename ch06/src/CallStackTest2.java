
public class CallStackTest2 {

	public static void main(String[] args) {
		System.out.println("main(String[] args) 시작됨");
		firstMethod();
		System.out.println("main(String[] args) 끝남");
	}

	private static void firstMethod() {
		System.out.println("firstMethod() 시작됨");
		secondMethod();
		System.out.println("firstMethod() 끝남");
	}

	private static void secondMethod() {
		System.out.println("secondMethod() 시작됨");
		System.out.println("secondMethod() 88888");
		System.out.println("secondMethod() 끝남");
	}
//	콜 스택 순서
	/*
	 * main 
	 * main -> first
	 * main -> first -> second
	 * main -> first -> second -> sop
	 * main -> first -> second
	 * main -> first
	 * main 
	 * .
	 */

}
