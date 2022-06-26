package ch14;

import java.io.File;
import java.util.stream.Stream;

public class Ex14_0_5 {

	public static void main(String[] args) {
//		peek(), 중간확인용, 스트림 소모 안함
		File[] fileArr = {new File("Ex1.java"), new File("Ex1.bak"),
				new File("Ex2.java"), new File("Ex1"),
				new File("Ex1.txt")	};
		Stream<File> fileStream = Stream.of(fileArr);
		
		Stream<String> fileNameStream = fileStream.map(File::getName);
		fileNameStream.forEach(System.out::println);
		
		fileStream = Stream.of(fileArr);
		
		fileStream.map(File::getName)	//.map(String::toString) :: 이미 앞에서 map(File::getName) ->Stream<String>으로 돼서 할 필요 없음!!
				.filter(s -> s.indexOf('.') != -1)
				.peek(s -> System.out.printf("filename = %s%n", s))
				.map(s -> s.substring(s.indexOf('.')+1))	//+1 잊지말자!
				.peek(s -> System.out.printf("extension = %s%n", s))
				.map(String::toUpperCase)
				.distinct()
				.forEach(System.out::println);

	}

}
