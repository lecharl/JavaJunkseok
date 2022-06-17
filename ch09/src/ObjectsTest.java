import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class ObjectsTest {

	public static void main(String[] args) {
		String[][] str2D = new String[][] {{"aaa","bbb"}, {"AAA","BBB"}};
		String[][] str2D_2 = new String[][] {{"aaa","bbb"}, {"AAA","BBB"}};
		
		System.out.print("str2D ={");
		for (String[] tmp : str2D) {
			System.out.print(Arrays.toString(tmp));
		}
		System.out.println("}");
		
		System.out.print("str2D_2 ={");
		for (String[] tmp : str2D_2) {
			System.out.print(Arrays.toString(tmp));
		}
		System.out.println("}");
		
		System.out.println("Objects.equals(str2D, str2D_2) :: " + Objects.equals(str2D, str2D_2));
		System.out.println("Objects.equals(null, null) :: " + Objects.equals(null, null));
		System.out.println("Objects.deepEquals(str2D, str2D_2) :: " + Objects.deepEquals(str2D, str2D_2));
		
		System.out.println("Objects.isNull(null) :: "+Objects.isNull(null));
		System.out.println("Objects.nonNull(null) :: "+Objects.nonNull(null));
		System.out.println("Objects.hashCode(null) :: "+Objects.hashCode(null));
		System.out.println("Objects.toString(null) :: "+Objects.toString(null));
		System.out.println("Objects.toString(null, \"\") :: "+Objects.toString(null, ""));
		
//		대소문자 구분 안하는 비교
		Comparator c = String.CASE_INSENSITIVE_ORDER;
		
		System.out.println("Objects.compare(\"aa\", \"bb\", c) :: "+Objects.compare("aa", "bb", c));
		System.out.println("Objects.compare(\"bb\", \"aa\", c) :: "+Objects.compare("bb", "aa", c));
		System.out.println("Objects.compare(\"ab\", \"AB\", c) :: "+Objects.compare("ab", "AB", c));
	}

}
