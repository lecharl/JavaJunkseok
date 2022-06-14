import java.util.Vector;

class Product{
	int price;
	int bonusPoint;
	
	Product(int price){
		this.price = price;
		this.bonusPoint = (int)(price/10.0);
	}
}

class Tv extends Product{
	Tv(int price){
		super(price);
	}
	@Override
	public String toString() { return "Tv";	}
}

class Computer extends Product{
	Computer(int price){
		super(price);
	}
	@Override
	public String toString() { return "Computer";}
}

class Audio extends Product{
	Audio(int price){
		super(price);
	}
	@Override
	public String toString() { return "Audio";}
}

class Buyer{
	int money;
	int bonusPoint;
	
	Buyer(int money, int bonusPoint){
		this.money = money;
		this.bonusPoint = bonusPoint;
	}
	
//	Product[] cart = new Product[10];
//	int i=0;
	Vector vCart = new Vector();
	
	void buy(Product p) {
		if(p.price > this.money) {
			System.out.println("잔액이 부족하여 "+p+"을/를 살 수 없습니다.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
//		cart[i++] = p;
		vCart.add(p);
		System.out.println(p+"을/를 구입하셨습니다.");
	}
	
//	환불
	void refund(Product p) {
		if(vCart.remove(p)) {
			money += p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println(p+"을/를 반품하셨습니다.");
		}else {	//제거 실패
			System.out.println("구입하신 제품 중 해당 제품이 없습니다.");
		}
	}
	
	void summary() {
		int sum=0;
		String itemList = "";
		
		if(vCart.isEmpty()) {
			System.out.println("구입하신 제품이 없습니다.");
		}else {
			for(int i=0; i<vCart.size(); i++) {
				Product p = (Product) vCart.get(i);
				sum += p.price;
//				***
				itemList += (i==0)? ""+ p : ", "+p;
			}
			System.out.println("구입하신 물품의 총금액은 "+sum+"만원입니다.");
			System.out.println("구입하신 제품은 "+itemList+"입니다.");
		}
				
	}
}

public class PolyArgumentTest3 {

	public static void main(String[] args) {
		Buyer b = new Buyer(1000, 20);
		Tv t = new Tv(204);
		Computer c = new Computer(1800);
		Audio a = new Audio(50);
		
		b.buy(t);
		b.buy(c);
		b.buy(a);
		System.out.println();
		b.refund(t);
		b.summary();
		System.out.println("현재 잔액은 "+b.money+"만원입니다.");
		System.out.println("현재 보너스포인트는 "+b.bonusPoint+"점입니다.");

	}

}
