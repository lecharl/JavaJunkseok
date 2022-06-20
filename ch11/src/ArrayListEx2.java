import java.util.ArrayList;
import java.util.List;

public class ArrayListEx2 {

	public static void main(String[] args) {
//		긴 문자열 데이터를 원하는 길이로 잘라서  ArrayList에 담은 다음 출력하기
		
		final int LIMIT = 10;	//자르고자 하는 글자의 개수
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		int sourceLength = source.length();	//길이 43
		
//		크기를 약간 여유있게 잡기... 근데 왜 이렇게 잡지?
		List list = new ArrayList(sourceLength/LIMIT + 10);
		
		for(int i=0; i<sourceLength; i += LIMIT) {
			if(i+LIMIT < sourceLength)
				list.add(source.substring(i, i+LIMIT));
			else
				list.add(source.substring(i));	//i == 40일 때 여기로
		}
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println(list);
		
	}

}
