package ch06;

public class Ex6_3 {

	public static void main(String[] args) {
//		cv 다루는 방법 <- 클래스변수는 클래스가 메모리에 올라갈 때 생성되기 때문에
		System.out.println("카드의 너비 :: "+Card.width);
		System.out.println("카드의 높이 :: "+Card.height);
		
		Card c1 = new Card();
		c1.kind = "Heart";
		c1.number = 7;
		
		Card c2 = new Card();
		c2.kind = "Spade";
		c2.number = 4;
		
		System.out.printf("c1은 %s, %d이며, 크기는 (%d, %d)%n", c1.kind, c1.number, c1.width, c1.height);
		System.out.printf("c2은 %s, %d이며, 크기는 (%d, %d)%n", c2.kind, c2.number, c2.width, c2.height);
		
		System.out.println("c1의 width와 height를 각각 50, 80으로 변경합니다.");
		
//		iv가 아니라 cv이기 때문에
		c1.width = 50;
		c1.height = 80;
		
//		c2도 같이 바뀜!
//		오해가 생기지 않도록 cv는 클래스이름.cv 로 해야 함!!
		System.out.printf("c1은 %s, %d이며, 크기는 (%d, %d)%n", c1.kind, c1.number, c1.width, c1.height);
		System.out.printf("c2은 %s, %d이며, 크기는 (%d, %d)%n", c2.kind, c2.number, c2.width, c2.height);
		
		

	}

}

class Card{
	String kind;
	int number;
	static int width = 100;
	static int height = 250;
}