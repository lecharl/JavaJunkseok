
public class PointTest {

	public static void main(String[] args) {
		Point3d p3d = new Point3d(1, 2, 3);
		System.out.println(p3d.getLocation());
		
		Point3d p3d2 = new Point3d();
		System.out.println(p3d2.getLocation());

	}

}

class Point1{
	int x = 10;
	int y = 20;
	
	Point1(int x, int y){
//		super(); 컴파일러가 자동 추가
		this.x = x;
		this.y = y;
	}
	
	String getLocation() {
		return "x: "+x+", y: "+y;
	}
}

class Point3d extends Point1{
	int z = 30;
	
	Point3d() {
		this(100, 200, 300);
	}

	Point3d(int x, int y, int z) {
//		Implicit super constructor Point() is undefined. Must explicitly invoke another constructor
//		첫줄에 생성자를 호출 안하면 자동으로 super(); 를 추가하는데, Point() 이게 없기 때문에 에러가 난 것!
		super(x, y);
		this.z = z;
	}
	
	@Override
	String getLocation() {
//		***이렇게 사용하는 게 유지보수하기에 더 좋다.
		return super.getLocation()+", z: "+z;
	}
	
}