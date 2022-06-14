package ch07;

public class Ex7_10 {
	public static void main(String[] args) {
		Unit[] unit = {new Marine(), new Tank(), new DropShip()};
		for(int i=0; i<unit.length; i++) {
//			한꺼번에 이동
			unit[i].move(100, 200);
		}
	}
}

abstract class Unit{
	int x, y;
	abstract void move(int x, int y);
	void stop() {}
}

class Marine extends Unit{
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.printf("Marine[x = %d, y = %d]\n", x, y);
	}
	void stimPack() {}
}

class Tank extends Unit{
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.printf("Tank[x = %d, y = %d]\n", x, y);
	}
	void changeMode() {}
}

class DropShip extends Unit{
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.printf("DropShip[x = %d, y = %d]\n", x, y);		
	}
	void unload() {}
}