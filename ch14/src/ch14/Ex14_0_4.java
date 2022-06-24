package ch14;

import java.io.File;
import java.util.stream.Stream;

public class Ex14_0_4 {

	public static void main(String[] args) {
//		map()
//		File의 스트림에서 파일의 이름만 뽑아서 출력하기
		Stream<File> fileStream = Stream.of(new File("Ex1.java"),new File("Ex1"),new File("Ex1.bak"),
				new File("Ex2.java"),new File("Ex1.txt"),new File("Ex2.html"));
//		Stream<File> -> Stream<String>
		Stream<String>  filenameStream = fileStream.map(File::getName);
//		filenameStream.forEach(System.out::println);
		System.out.println("----");
		
//		filenameStream = fileStream.map(File::getName);
//		filenameStream.filter(s -> s.indexOf('.') != -1)	//**확장자가 없는 것 제외
//				.map(s -> s.substring(s.indexOf('.')+1))	//Stream<String> -> Stream<String> 확장자만
//				.forEach(System.out::println);
		System.out.println("===");
		
		filenameStream.filter(s -> s.indexOf('.') != -1)
				.map(s -> s.substring(s.indexOf('.') +1))
				.map(String::toUpperCase)	//대문자로 변환
				.distinct()
				.forEach(System.out::println);

	}

}
