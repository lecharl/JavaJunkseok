import java.util.Arrays;
import java.util.StringJoiner;

public class StringEx4 {

	public static void main(String[] args) {
		String animals = "dog,cat,bear";
		String[] arr = animals.split(",");
		System.out.println(Arrays.toString(arr));
		
		System.out.println(String.join("-", arr));
		
//		StringJoiner(구분자, 열기, 닫기)
		StringJoiner sj = new StringJoiner(",", "[", "]");
		for (String s : arr) {
//			sj.add(str[i])
			sj.add(s.toUpperCase());
		}
		System.out.println(sj.toString());
	}

}
