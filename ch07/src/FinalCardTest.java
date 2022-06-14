
public class FinalCardTest {

	public static void main(String[] args) {
		Card1 c = new Card1(10, "CLOVER");
//		The final field Card1.NUMBER cannot be assigned
//		c.NUMBER = 5; -> 안됨!!
		System.out.println(c.NUMBER);
		System.out.println(c.KIND);
		System.out.println(c);
	}

}

class Card1{
//	상수지만, 선언과 함께 초기화하지 않고
//	***생성자에서 단 한번만 초기화할 수 있다!! -> 각 인스턴스마다 다른 값을 갖도록
	final int NUMBER;
	final String KIND;
	
//	생성자에서 초기화!!
	Card1(int number, String kind) {
		this.NUMBER = number;
		this.KIND = kind;
	}
	
	Card1(){
		this(1, "HEART");
	}
	
	@Override
	public String toString() {
		return this.KIND+" "+this.NUMBER;
	}
}