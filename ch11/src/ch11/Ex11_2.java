package ch11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex11_2 {

	public static void main(String[] args) {
		Stack st = new Stack();
		Queue q = new LinkedList();	
		//Queue는 인터페이스이기 때문에 직접 객체 생성 못함
//		-> Queue를 구현한 LinkedList 사용
		
		st.push("0");
		st.push("1");
		st.push("2");
		System.out.println(st);
		
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
//		LI(마지막에 저장한 데이터)가 1이 된다!! 1부터 시작!!
		System.out.println("st.search(\"0\") :: "+st.search("0"));	//3
		System.out.println("st.search(\"1\") :: "+st.search("1"));	//2
		System.out.println("st.search(\"2\") :: "+st.search("2"));	//1
		
		System.out.println("= Stack =");
		while(!st.empty()) {
			System.out.println(st.peek());
			System.out.println(st.pop());
		}
		
		System.out.println("= Queue =");
		while(!q.isEmpty()) {
			System.out.println(q.poll());
			System.out.println(q.peek());	//예외 발생 X, null 반환
		}

	}

}
