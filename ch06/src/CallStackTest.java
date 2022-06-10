
public class CallStackTest {

	public static void main(String[] args) {
		firstMethod();
	}

	private static void firstMethod() {
		secondMethod();
	}

	private static void secondMethod() {
		System.out.println("secondMethod()");
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
