
public class DrawShape {

	public static void main(String[] args) {
		Point[] p = {
			new Point(100, 100),
			new Point(140, 50),
			new Point(200, 110)
		};
		Triangle t = new Triangle(p);
		Circle c = new Circle(p[2], 50);
		
		t.draw();
		c.draw(); 
	}

}

class Shape{
	String color = "black";
	void draw() {
		System.out.printf("[color=%s]%n", color);
	}
}

class Point{
	int x, y;
	
//	따로 지정하지 않았으면 (0, 0)으로 디폴트
	Point(){
		this(0, 0);
	}

	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
//	(x, y)를 문자열로 출력
	String getXY() {
		return "("+x+", "+y+")";
	}
}

class Circle extends Shape{
//	***포함***
	Point center;	//선언만 한거지, 객체 생성 아직이다!! 꼭 초기화 해줘야함!!
	int r;
	
//	디폴트, (0, 0), 반지름 100
	Circle(){
		this(new Point(), 100);
	}
	
	Circle(Point center, int r){
		this.center = center;
		this.r = r;
	}
	
	@Override
	void draw() {
//		***주의***
		System.out.printf("[center=(%d, %d), r=%d, color=%s]%n", center.x, center.y, r, color);
	}
}

class Triangle extends Shape{
//	3개의 Point 인스턴스를 담을 배열 생성
	Point[] p = new Point[3];
	
//	Point배열을 매개변수로 받는 생성자
	Triangle(Point[] p) {
		this.p = p;
	}
	
	@Override
	void draw() {
		System.out.printf("[p1=%s, p2=%s, p3=%s, color=%s]%n", p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
	}
}