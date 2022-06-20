package ch11;

import java.util.EmptyStackException;
import java.util.Stack;

public class Ex11_3 {

	public static void main(String[] args) {
		Stack st = new Stack();
		String expression = "((2+3)*1) + )3";
		
		System.out.println("expression:: "+expression);
		
		try {
			for(int i=0; i<expression.length(); i++) {
				if('(' == expression.charAt(i)) {
//					** 객체를 넣는 것이기 때문에 객체타입이 더 좋다.
					st.push(expression.charAt(i) + "");
				}else if(')' == expression.charAt(i)) {
					st.pop();
				}
			}
			
			if(st.empty()) {
				System.out.println("괄호가 일치합니다.");
			}else {
				System.out.println("괄호'('가 더 많습니다.");
			}
		} catch (EmptyStackException e) {
			System.out.println("괄호')'가 더 많습니다.");
		}
	}

}
