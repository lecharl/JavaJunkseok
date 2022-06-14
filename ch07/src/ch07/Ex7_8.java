package ch07;

class Product0{
	int price;
	int bonusPoint;
	
	 Product0(int price) {
		 this.price = price;
		 this.bonusPoint = (int)(price/10.0);	//10.0!!
	}
}

class Tv0 extends Product0{
	Tv0(int price) {
		super(price);
	}
	@Override
	public String toString() {
		return "Tv";
	}
}

class Computer0 extends Product0{
	Computer0(){
		super(200);
	}
	@Override
	public String toString() {
		return "Computer";
	}
}

// 사는 사람
class Buyer{
	int money = 1000;
	int bonusPoint = 0;
	
	void buy(Product0 p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p+"을/를 구입하였습니다.");
	}
}

public class Ex7_8 {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		b.buy(new Tv0(100));
		b.buy(new Computer0());
		
		System.out.println("현재 보너스점수는 "+b.bonusPoint+"점입니다.");
		System.out.println("현재 남은 돈은 "+b.money+"원입니다.");
	}

}
