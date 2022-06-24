package ch14;

import java.io.File;
import java.util.stream.Stream;

public class Ex14_6 {

	public static void main(String[] args) {
		File[] fileArr = { new File("Ex1.java"), new File("Ex1.bak"),
				new File("Ex2.java"), new File("Ex1"),
				new File("Ex1.txt")	};
//		Stream.of(배열)
		Stream<File> fileStream = Stream.of(fileArr);
		
//		Stream<File> -> Stream<String>
		Stream<String> filenameStream = fileStream.map(File::getName);
		filenameStream.forEach(System.out::println);
		System.out.println();
		
//		다시
		fileStream = Stream.of(fileArr);
		fileStream.map(File::getName)	//Stream<String>
				.filter(s -> s.indexOf('.') != -1)
				.map(s -> s.substring(s.indexOf('.')+1))
				.map(String::toUpperCase)
				.distinct()
				.forEach(System.out::println);
		System.out.println();
	}

}