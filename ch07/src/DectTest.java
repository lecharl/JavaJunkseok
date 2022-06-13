
public class DectTest {

	public static void main(String[] args) {
//		카드 덱 만들기
		Deck d = new Deck();
//		맨 위의 카드 뽑기, 그 배열안에 있는 건 Card객체이므로 Card로 받는다.
		Card c = d.pick(0);
		System.out.println(c);
		
		d.shuffle();
//		섞은 후 맨 위의 카드 뽑기
		c = d.pick(0);
		System.out.println(c);

	}

}

class Deck{
	final int CARD_NUM = Card.KIND_MAX * Card.NUM_MAX;
//	포함 - Card객체배열을 포함한다.
	Card cardArr[] = new Card[CARD_NUM];
	
//	Deck의 카드를 초기화한다.
	Deck() {
		int i = 0;
		
		for(int k=Card.KIND_MAX; k>0; k--) {
			for(int n=0; n<Card.NUM_MAX; n++) {
				cardArr[i++] = new Card(k, n+1);
			}
		}
	}
	
//	지정된 위치에 있는 카드 하나 꺼내서 반환( Card(?, ?) 반환)
	Card pick(int index) {
		return cardArr[index];
	}
	
//	랜덤하게 카드 하나 선택
	Card pick() {
//		0~51
		int index = (int)(Math.random() * CARD_NUM);
		return cardArr[index];
	}
	
//	카드 순서 섞기
	void shuffle() {
		for(int i=0; i<cardArr.length; i++) {
			int r = (int)(Math.random() * CARD_NUM);
			 
			Card tmp = cardArr[i];
			cardArr[i] = cardArr[r];
			cardArr[r] = tmp;
		}
	}
}	//Deck 끝 

class Card{
	static final int KIND_MAX = 4;	//카드 무늬 수
	public static final int NUM_MAX = 13;	//무늬별 카드 수
	
	static final int SPADE = 4;
	static final int DIAMOND = 3;
	static final int HEART = 2;
	static final int CLOVER = 1;
	int kind;
	int number;
	
	Card(){
		this(SPADE, 1);
	}
	
	Card(int kind, int number){
		this.kind = kind;
		this.number = number;
	}
	
	@Override
	public String toString() {
		String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
		String numbers = "0123456789XJQK";	//X 는 10
		return "kind : " + kinds[this.kind] + ", number : " + numbers.charAt(this.number);
	}
}