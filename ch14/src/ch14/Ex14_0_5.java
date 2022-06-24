package ch14;

import java.io.File;
import java.util.stream.Stream;

public class Ex14_0_5 {

	public static void main(String[] args) {
		File[] fileArr = {new File("Ex1.java"), new File("Ex1.bak"),
				new File("Ex2.java"), new File("Ex1"),
				new File("Ex1.txt")	};
		Stream<File> fileStream = Stream.of(fileArr);
		
		fileStream.map(File::getName).fil

	}

}
