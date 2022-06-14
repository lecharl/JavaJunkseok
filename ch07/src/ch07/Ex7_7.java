package ch07;

public class Ex7_7 {

	public static void main(String[] args) {
		Car c = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		c = (Car)fe;
//		c.water();	-> 에러
		fe2 = (FireEngine) c;
		fe2.water();
		
//		------------- 아래 주의! 실제 가리키는 객체가 무엇인지가 중요하다!! -----------
		Car c2 = new Car();
		FireEngine fe3 = (FireEngine) c2;
		fe3.water();

	}

}

class Car{
	String color;
	int door;
	
	void drive() {
		System.out.println("drive, brrr~~~");
	}
	
	void stop() {
		System.out.println("stop!!!");
	}
}

class FireEngine extends Car{
	void water() {
		System.out.println("waterrrrr");
	}
}