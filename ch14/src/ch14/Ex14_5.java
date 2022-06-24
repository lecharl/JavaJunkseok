package ch14;

import java.util.Comparator;
import java.util.stream.Stream;

public class Ex14_5 {

	public static void main(String[] args) {
		Stream<Student> studentStream = Stream.of(new Student("이자바", 3, 300),
				new Student("김자바", 1, 200),
				new Student("안자바", 2, 100),
				new Student("박자바", 2, 150),
				new Student("소자바", 1, 200),
				new Student("나자바", 3, 290),
				new Student("감자바", 3, 180));
		
//		studentStream.sorted(Comparator.comparing(Student::getBan)	//반별로
//									.thenComparing(Comparator.naturalOrder()))	//기본정렬(내림차순)
//					.forEach(System.out::println);
//		studentStream.sorted(Comparator.comparing(Student::getName)).forEach(System.out::println);	//이름별
//		studentStream.sorted(Comparator.comparing(Student::getTotal)).forEach(System.out::println);	//총점 오름차순
//		studentStream.sorted(Comparator.naturalOrder()).forEach(System.out::println);	//기본정렬(총점 내림차순)
		
//		반별 -> 성적순 -> 이름순
		studentStream.sorted(Comparator.comparing(Student::getBan)
									.thenComparing(Comparator.naturalOrder())
									.thenComparing(Student::getName))
					.forEach(System.out::println);
	}

}

class Student implements Comparable<Student>{
	private String name;
	private int ban;
	private int total;
	
	public Student(String name, int ban, int total) {
		this.name = name;
		this.ban = ban;
		this.total = total;
	}
	@Override
	public String toString() {
		return String.format("[%s, %d, %d]", name,ban,total);	//String.format("", ...)
	}
	public String getName() { return name;}
	public int getBan() {return ban;}
	public int getTotal() {return total;}
	
//	총점 내림차순을 기본정렬로!
	@Override
	public int compareTo(Student s) {
		return s.total - this.total;
	}
}
