package ch14;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex14_0_3 {

	public static void main(String[] args) {
//		자르기 :: skip(), limit()
		IntStream intStream = IntStream.rangeClosed(1, 10);	//1~10
		intStream.skip(3).limit(5).forEach(System.out::print);
		System.out.println();
//		걸러내기 :: filter(조건식), distinct()
		IntStream intStream2 = IntStream.of(1,2,2,3,3,3,4,5,5,6);
		intStream2.distinct().forEach(System.out::print);
		System.out.println();
		
		IntStream intStream3 = IntStream.rangeClosed(1, 10);
		intStream3.filter(i -> i%3 == 0).forEach(System.out::print);
		System.out.println();
		
		intStream3 = IntStream.rangeClosed(1, 10);
		intStream3.filter(i -> i%2 != 0 && i%3 != 0).forEach(System.out::print);
		intStream3 = IntStream.rangeClosed(1, 10);
		intStream3.filter(i -> i%2 != 0).filter(i -> i%3 != 0).forEach(System.out::print);
		System.out.println();
//		정렬 :: sorted(), sorted(Comparator)
		//기본정렬, 따로 안하면 오름차순
		Stream<String> strStream = Stream.of("dd","aaa","CC","cc","b");	
		strStream.sorted().forEach(System.out::print);
		System.out.println();
		
		strStream = Stream.of("dd","aaa","CC","cc","b");
		strStream.sorted(String::compareTo).forEach(System.out::print);
		System.out.println();
		
		strStream = Stream.of("dd","aaa","CC","cc","b");
		strStream.sorted(Comparator.naturalOrder()).forEach(System.out::print);
		System.out.println();

		strStream = Stream.of("dd","aaa","CC","cc","b");
		strStream.sorted((s1,s2)->s1.compareTo(s2)).forEach(System.out::print);
		System.out.println();
		
//		기본정렬의 역순
		strStream = Stream.of("dd","aaa","CC","cc","b");
		strStream.sorted(Comparator.reverseOrder()).forEach(System.out::print);
		System.out.println();
		
//		대소문자 구분 안함
		strStream = Stream.of("dd","aaa","CC","cc","b");
		strStream.sorted(String.CASE_INSENSITIVE_ORDER).forEach(System.out::print);
		System.out.println();

		strStream = Stream.of("dd","aaa","CC","cc","b");
		strStream.sorted(String::compareToIgnoreCase).forEach(System.out::print);;
		System.out.println();
		
//		대소문자 구분 안함, 역순
		strStream = Stream.of("dd","aaa","CC","cc","b");
		strStream.sorted(String.CASE_INSENSITIVE_ORDER.reversed()).forEach(System.out::print);
		System.out.println();
		
//		길이순 정렬
		strStream = Stream.of("dd","aaa","CC","cc","b");
		strStream.sorted(Comparator.comparing(String::length)).forEach(System.out::print);
		System.out.println();
		
//		길이순 정렬, 역순
		strStream = Stream.of("dd","aaa","CC","cc","b");
		strStream.sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::print);
		
	}

}

