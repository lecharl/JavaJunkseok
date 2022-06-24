package ch14;

import java.util.Random;
import java.util.stream.IntStream;

public class Ex14_0_1 {

	public static void main(String[] args) {
//		Random().ints()는 무한스트림 -> 제한을 줘야 한다.
//		1) limit(int)
		IntStream intStream = new Random().ints();
		intStream.limit(5).forEach(System.out::println);
		System.out.println("--------");
		
//		2) ints(개수)
		IntStream intStream2 = new Random().ints(5);
		intStream2.forEach(System.out::println);
		System.out.println("========");
		
//		범위를 지정할 수 있다. :: from 이상 to 미만
//		1) ints(from, to)
		IntStream intStream3 = new Random().ints(3,10);
		intStream3.limit(5).forEach(System.out::println);
		System.out.println("-=-=-=--=");
		
//		2) ints(개수, from, to) .limit(int)
		IntStream intStream4 = new Random().ints(4,10,20);
		intStream4.forEach(System.out::println);

	}

}
