package ch12;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex12_2 {

	public static void main(String[] args) {
		ArrayList<Student> stList = new ArrayList<Student>();
		stList.add(new Student("자바왕", 1, 1));
		stList.add(new Student("자바짱", 1, 2));
		stList.add(new Student("홍길동", 2, 1));
		
		Student s = stList.get(2);
		System.out.println(s.ban+"반 "+s.no+"번 "+s.name);
		System.out.println();
		
		Iterator<Student> it = stList.iterator();
		while(it.hasNext()) {
			Student st = it.next();
			System.out.println(st.ban+"반 "+st.no+"번 "+st.name);
		}
	}

}

class Student{
	String name;
	int ban;
	int no;

	public Student(String name, int ban, int no) {
		this.name = name;
		this.ban = ban;
		this.no = no;
	}
}