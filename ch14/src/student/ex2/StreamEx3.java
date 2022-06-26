package student.ex2;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {

	public static void main(String[] args) {
		Student[] stuArr = {new Student("이자바", 3, 300),
				new Student("김자바", 1, 200),
				new Student("안자바", 2, 100),
				new Student("박자바", 2, 150),
				new Student("소자바", 1, 200),
				new Student("나자바", 3, 290),
				new Student("감자바", 3, 180)};
		Stream<Student> stuStream = Stream.of(stuArr);
		stuStream.sorted(Comparator.comparing(Student::getBan).thenComparing(Comparator.naturalOrder())).forEach(System.out::println);
		
//		다시 생성
		stuStream = Stream.of(stuArr);
		IntStream stuScoreStream = stuStream.mapToInt(Student::getTotal);
		IntSummaryStatistics summaryStatistics = stuScoreStream.summaryStatistics();
		
		System.out.println("count = "+summaryStatistics.getCount());
		System.out.println("sum = "+summaryStatistics.getSum());
		System.out.println("average = "+summaryStatistics.getAverage());
		System.out.printf("average = %.2f%n", summaryStatistics.getAverage());
		System.out.println("max = "+summaryStatistics.getMax());	//Comparator 필요없음!!
		System.out.println("min = "+summaryStatistics.getMin());
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
		return String.format("[%s, %d, %d]", name, ban, total);	//String.format("..", ..)
	}
	public String getName() { return name;}
	public int getBan() {return ban;}
	public int getTotal() {return total;}

//	**내림차순을 기본정렬
	@Override
	public int compareTo(Student o) {
		return o.total - this.total;
	}
	
	
}