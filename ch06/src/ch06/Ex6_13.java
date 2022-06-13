package ch06;

public class Ex6_13 {

	public static void main(String[] args) {
//		기본생성자로 인스턴스 변수 초기화
		Car c1 = new Car();
		c1.color = "white";
		c1.gearType = "manual";
		c1.door = 4;
		
//		매개변수가 있는 생성자로 인스턴스 변수 초기화
		Car c2 = new Car("yellow", "auto", 2);
		
		System.out.printf("c1의 color=%s, gearType=%s, door=%d%n", c1.color, c1.gearType, c1.door);
		System.out.printf("c2의 color=%s, gearType=%s, door=%d%n", c2.color, c2.gearType, c2.door);
	}

}

class Car{
	String color;
	String gearType;
	int door;
	
	Car(){}
	
	Car(String c, String g, int d){
		color = c;
		gearType = g;
		door = d;
	}
}
