
public class FighterTest {

	public static void main(String[] args) {
		Fighter f = new Fighter();
		
		if(f instanceof Unit)
			System.out.println("f는 Unitz클래스의 자손입니다.");
		if(f instanceof Fightable)
			System.out.println("f는 Fightable인터페이스를 구현했습니다.");
		if(f instanceof Movable)
			System.out.println("f는 Movable인터페이스를 구현했습ㄴ다.");
		if(f instanceof Attackable)
			System.out.println("f는 attackable인터페이스를 구현했습니다.");
		if(f instanceof Object)
			System.out.println("f는 Object클래스의 자손입니다.");
	}

}

// 상속과 구현을 동시에
// 구현 :: 추상메서드를 반드시!! 다!! 구현해야 한다!!
class Fighter extends Unit implements Fightable{

	@Override
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.printf("위치: x= %d, y= %d\n", x, y);
	}

	@Override
	public void attack(Unit u) {
		System.out.println("Attack!!");
	}
	
}

class Unit{
	int currentHP;
	int x, y;
}

// 인터페이스는 다중상속 가능
interface Fightable extends Movable, Attackable{}
interface Movable{
	void move(int x, int y);
}
interface Attackable{
	void attack(Unit u);
}