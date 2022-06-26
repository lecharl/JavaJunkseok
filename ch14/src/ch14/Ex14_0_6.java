package ch14;

import java.util.Random;
import java.util.stream.IntStream;

public class Ex14_0_6 {

	public static void main(String[] args) {
//		mapToObj()
//		로또번호 출력
		IntStream lottoStream = new Random().ints(1,46);
		lottoStream.distinct().limit(6)	//중복 제거 후 6개를 고른다.
		.mapToObj(i -> i+",")	//정수를 문자열로 변환 :: IntStream -> Stream<String>
		.forEach(System.out::print);
		
		System.out.println();
		
//		chars()
//		String.chars() -> IntStream
//		StringBuffer.chars() -> IntStream
		IntStream charIntStream = "12345".chars();
		int charSum = charIntStream.map(ch -> ch - '0').sum();
		System.out.println(charSum);
	}

}
