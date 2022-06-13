
public class CarTest3 {

	public static void main(String[] args) {
//		생성자를 이용한 인스턴스의 복사
		Car2 c1 = new Car2();
//		***c1의 복사본 c2를 생성한다***
		/*
		 * c2는 c1을 복사하여 생성된 것이므로 서로 같은 상태를 갖지만, 
		 * 서로 독립적으로 메모리 공간에 존재하는 별도의 인스턴스이므로
		 * c1의 값들이 변경되어도 c2는 영향을 받지 않는다!!!!
		 */
		
		Car2 c2 = new Car2(c1);
		
		System.out.printf("c1의 color=%s, gearType=%s, door=%d%n", c1.color, c1.gearType, c1.door);
		System.out.printf("c2의 color=%s, gearType=%s, door=%d%n", c2.color, c2.gearType, c2.door);
		
		c1.door = 100;
		System.out.printf("c1의 color=%s, gearType=%s, door=%d%n", c1.color, c1.gearType, c1.door);
		System.out.printf("c2의 color=%s, gearType=%s, door=%d%n", c2.color, c2.gearType, c2.door);

	}

}

class Car2{
	String color;
	String gearType;
	int door;
	
	Car2(){
		this("white", "auto", 4);
	}
	
//	***인스턴스를 복사하기 위한 생성자
	Car2(Car2 car){
		this(car.color, car.gearType, car.door);
	}
	
	Car2(String color, String gearType, int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}