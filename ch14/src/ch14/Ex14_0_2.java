package ch14;

import java.util.stream.Stream;

public class Ex14_0_2 {

	public static void main(String[] args) {
//		iterate(T seed, UnaryOperator f), UnaryOperator == 단항연산자
		Stream<Integer> evenStream = Stream.iterate(2, n -> n+2);	//무한스트림
		evenStream.limit(5).forEach(System.out::println);
		System.out.println("---");
		
		Stream<Integer> oddStream = Stream.iterate(1, n -> n+2);
		oddStream.limit(5).forEach(System.out::println);
		System.out.println("===");
		
//		generate(Supplier<T> s) :: 주기만 하는 것, 입력x, 출력o, 매개변수가 없다!!
		Stream<Integer> oneStream = Stream.generate(()->1);	//무한스트림
		oneStream.limit(5).forEach(System.out::println);

	}

}
