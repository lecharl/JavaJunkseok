package ch12;

import java.util.HashMap;

public class Ex12_2_2 {

	public static void main(String[] args) {
		HashMap<String, Student2> map = new HashMap<String, Student2>();
		map.put("자바왕", new Student2("1학년", 1, 1, 100, 90, 90));
		map.put("자바짱", new Student2("2학년", 1, 2, 100, 90, 90));
		map.put("홍길동", new Student2("3학년", 2, 1, 100, 90, 90));
		Student2 student2 = map.get("자바짱");
		System.out.println(student2.hakneon+" "+student2.ban+"반");
		System.out.println(student2.kor+", "+student2.eng+", "+student2.math);
		
	}

}

class Student2{
	String hakneon = "";
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	public Student2(String hakneon, int ban, int no, int kor, int eng, int math) {
		this.hakneon = hakneon;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
}