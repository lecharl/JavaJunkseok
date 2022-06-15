
public class RepariableTest {

	public static void main(String[] args) {
		Tank1 tank = new Tank1();
		DropShip1 dropShip = new DropShip1();
		Marine1 marine = new Marine1();
		SCV scv = new SCV();
		
		scv.repair(tank);
		scv.repair(dropShip);
//		scv.repair(marine);	-> Marine1은 Repairable을 구현X

	}

}

class Unit1{
	int hitPoint;
	final int MAX_HP;
	Unit1(int hp){
		MAX_HP = hp;
	}
}

class GroundUnit extends Unit1{
	GroundUnit(int hp){
		super(hp);
	}
}

class AirUnit extends Unit1{
	AirUnit(int hp) {
		super(hp);
	}
}

interface Repairable{}

//

class Marine1 extends GroundUnit{
	Marine1(){
		super(40);
		hitPoint = MAX_HP;
	}
}



class Tank1 extends GroundUnit implements Repairable{
	Tank1(){
		super(150);
		hitPoint = MAX_HP;
	}
	@Override
	public String toString() {
		return "Tank";
	}
}

class DropShip1 extends AirUnit implements Repairable{
	public DropShip1() {
		super(125);
		hitPoint = MAX_HP;
	}
	
	@Override
	public String toString() {
		return "DropShip";
	}
}

class SCV extends GroundUnit implements Repairable{
	SCV(){
		super(60);
		hitPoint = MAX_HP;
	}
	@Override
	public String toString() {
		return "SCV";
	}
//	SCV가 Repariable을 구현한 인스턴스(SCV, Tank, DropShip)를 repair()한다.
	void repair(Repairable r) {
//		** Unit1에 정의된 hitPoint, MAX_HP를 사용하게
		if(r instanceof Unit1) {
			Unit1 u = (Unit1)r;
			while(u.hitPoint != u.MAX_HP) {
				u.hitPoint++;
			}
			System.out.println(u.toString()+"의 수리가 끝났습니다.");
		}
	}
}