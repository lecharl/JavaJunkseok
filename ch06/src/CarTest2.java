
public class CarTest2 {

	public static void main(String[] args) {
		Car c1 = new Car();
		
		Car c2 = new Car("red");
		
		Car c3 = new Car("violet", "manual", 2);
		
		System.out.printf("c1의 color=%s, gearType=%s, door=%d%n", c1.color, c1.gearType, c1.door);
		System.out.printf("c2의 color=%s, gearType=%s, door=%d%n", c2.color, c2.gearType, c2.door);
		System.out.printf("c3의 color=%s, gearType=%s, door=%d%n", c3.color, c3.gearType, c3.door);
	}

}

class Car{
	String color;
	String gearType;
	int door;
	
//	매개변수가 없는 생성자, 아무것도 넘기지 않을 때 디폴트로 값 지정
	Car(){
		/*
		this.color = "white";
		this.gearType = "auto";
		this.door = 4;
		-> 위 세줄을 아래 한 줄로 간단히
		 */
		this("white", "auto", 4);
	}
	
//	매개변수 color 하나만 받는 생성자, color만 지정하고 나머진 디폴트로
	Car(String color){
		/*
		this.color = color;
		gearType = "auto";
		door = 4;
		-> 마찬가지!
		*/
		this(color, "auto", 4);
	}
	
//	매개변수 3개
	Car(String color, String gearType, int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}