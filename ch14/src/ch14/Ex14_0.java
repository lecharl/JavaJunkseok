package ch14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex14_0 {

	public static void main(String[] args) {
//		Collection -> 스트림
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Stream<Integer> listStream = list.stream();	//Collection의 메서드:: list, set..등을 Stream으로 바꿈
		listStream.forEach(System.out::print);	//최종연산이므로 스트림이 닫힘
		
		listStream = list.stream();	//이처럼 다시 생성해야함
		listStream.forEach(System.out::println);
		System.out.println("=========");

//		객체배열 -> 스트림
		Stream<String> strStream = Stream.of("a","b","c");	//Stream.of(...)
		strStream.forEach(System.out::println);;
		System.out.println("-----");
		
		String[] strArr = new String[] {"a","b","c","d"};	
		Stream<String> strStream2 = Stream.of(strArr);		//Stream.of([])
		strStream2.forEach(System.out::println);
		System.out.println("===");
		
		Stream<String> strStream3 = Arrays.stream(strArr);	//Arrays.stream([])
		strStream3.forEach(System.out::println);
		System.out.println("---");
		
		Integer[] integerArr = {new Integer(1), 2,3,4,5};
		Stream<Integer> integerStream = Arrays.stream(integerArr);
		System.out.println("integerStream.count() :: "+integerStream.count());	
		//Stream<>은 count()만 있음
		System.out.println("===");
		
//		기본형배열 -> 스트림
		int[] intArr = {6,7,8,9,10};
		IntStream intStream = IntStream.of(intArr);			//IntStream.of(...) / IntStream.of([])
		System.out.println("intStream.sum() :: "+intStream.sum());
		
		int[] intArr2 = {1,2,3,4,5};
		IntStream intStream2 = Arrays.stream(intArr2);		//Arrays.stream([])
		System.out.println("intStream2.average() :: "+intStream2.average());	
		//기본형스트림IntStream은 count(), sum(), average() 다 있음!!
		
		
	}

}
