
public class VarArgsEx {

	public static void main(String[] args) {
//		가변인자와 오버로딩
		String[] strArr = {"100", "200", "300"};
		
//		The method concatenate(String, String[]) is ambiguous for the type VarArgsEx
//		System.out.println(concatenate("", "100", "200", "300"));
//		System.out.println("["+ concatenate(",") +"]");
//		아래 두번째 메소드를 주석처리를 해야 가능하다!
		
//		System.out.println(concatenate(strArr));
		System.out.println(concatenate("", strArr));
		System.out.println(concatenate("-", new String[] {"1","2","3"}));
		System.out.println("["+concatenate(",", new String[0])+"]");
		System.out.println("["+ concatenate(",") +"]");

	}
	
	static String concatenate(String delim, String... args) {
		String result = "";
		for (String string : args) {
			result += string;
		}
		return result;
	}
	
	/*
	static String concatenate(String... args) {
		return concatenate("", args);
	}
	*/

}
