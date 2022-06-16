package ch09;

import java.util.Objects;

public class Ex9_3 {

	public static void main(String[] args) {
		Card c1 = new Card();
		Card c2 = new Card("HEART", 10);
		Card c3 = new Card();
		
		System.out.println(c1.equals(c3));
		System.out.println(c1.hashCode());
		System.out.println(c3.hashCode());

	}

}

class Card{
	int number;
	String kind;
	
	Card(){
		this("SPADE", 1);
	}
	
	Card(String kind, int number){
		this.number = number;
		this.kind = kind;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Card)) return false;
		Card c = (Card)obj;
		return this.number == c.number && this.kind.equals(c.kind);
	}
	
//	equals()를 오버라이딩하면 hashCode()도 오버라이딩 해야 한다!!
	@Override
	public int hashCode() {
//		iv들을 다 넣자(가변인자)
		return Objects.hash(number, kind);
	}
	
	@Override
	public String toString() {
		return "kind: "+kind+", number: "+number;
	}
}