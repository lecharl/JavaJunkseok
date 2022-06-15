package ch07;

public class FighterTest2 {

	public static void main(String[] args) {
		Fighter fighter = new Fighter();
		Fighter newFighter = new Fighter();
		fighter.move(100, 200);
//		** 1) 인터페이스를 매개변수로
		fighter.attack(newFighter);
		fighter.stop();
//		** 2) 인터페이스를 반환타입으로
		System.out.println("NEW CHALLENGER :: "+fighter.getFightable());
		System.out.println();
		
		Unit2 unit = new Fighter();
		unit.move(50, 555);
//		unit.attack(newFighter);	-> 없음!
		unit.stop();
//		System.out.println("NEW CHALLENGER :: "+unit.getFightable());	-> 없음!!
		System.out.println();
		
		Fightable fightable = new Fighter();
		fightable.move(77, 777);
		fightable.attack(newFighter);
//		fightable.stop();	-> 없음!
//		System.out.println("NEW CHALLENGER :: "+fightable.getFightable());	-> 없음!!

	}

}


abstract class Unit2{
	int x, y;
	abstract void move(int x, int y);
	void stop() {System.out.println("STOP!");}
}

interface Fightable extends Movable, Attackable{}

interface Movable{
	void move(int x, int y);
}
interface Attackable{
//	** 1) 인터페이스를 매개변수로
	void attack(Fightable fightable);
}

class Fighter extends Unit2 implements Fightable{

//	** 1) 인터페이스를 매개변수로
	@Override
	public void attack(Fightable fightable) {
		System.out.println(fightable+"을/를 공격");
	}

	@Override
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.printf("[x= %d, y=%d]로 이동\n", x,y);
	}
	
//	싸울 수 있는 상대를 불러온다.
//	** 2) 인터페이스를 반환타입으로
	 Fightable getFightable() {
		 return (Fightable)new Fighter();
	 }
}