package ch07;

class Product1{
	int price;
	int bonusPoint;
	
	Product1(int price){
		this.price = price;
		this.bonusPoint = (int)(price/10.0);
	}
}

class Tv1 extends Product1{

	Tv1(int price) {
		super(price);
	}
	@Override
	public String toString() { return "Tv"; }
}

class Computer1 extends Product1{

	Computer1(int price) {
		super(price);
	}
	@Override
	public String toString() { return "Computer"; }
}

class Audio1 extends Product1{
	Audio1(int price){
		super(price);
	}
	@Override
	public String toString() { return "Audio"; }
}


class Buyer1{
	int money;
	int bonusPoint;
//	**1**
	Product1[] cart = new Product1[10];
	int i=0;
	
	Buyer1(int money, int bonusPoint){
		this.money = money;
		this.bonusPoint = bonusPoint;
	}
	
	void buy(Product1 p) {
		if(this.money < p.price) {
			System.out.println("잔액이 부족하여 "+p+"을/를 살 수 없습니다.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
//		**2**
		cart[i++] = p;
		System.out.println(p+"을/를 구입하셨습니다.");
	}
	
//	구입한 물품의 총 가격과 목록
	void summary() {
//		**3**
		int sum = 0;	//lv라 수동초기화 꼭
		String itemList = "";
		
		for(int i=0; i<cart.length; i++) {
//			***중요!! 없으면 빠져나가기 ***
			if(cart[i] == null) break;
			sum += cart[i].price;
			itemList += cart[i] + ", ";
		}
		System.out.println("구입하신 물품의 총금액은 "+sum+"만원입니다.");
		System.out.println("구입하신 제품은 "+itemList+"입니다.");
	}
}

public class Ex7_9 {

	public static void main(String[] args) {
		Buyer1 b = new Buyer1(1000, 10);
		b.buy(new Tv1(140));
		b.buy(new Computer1(3250));
		b.buy(new Audio1(70));
		b.summary();
		System.out.println("현재 잔액은 "+b.money+"만원입니다.");
		System.out.println("현재 보너스포인트는 "+b.bonusPoint+"점입니다.");

	}

}
