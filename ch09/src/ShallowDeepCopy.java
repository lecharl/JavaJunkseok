
public class ShallowDeepCopy {

	public static void main(String[] args) {
		Circle c1 = new Circle(new Point1(1, 1), 2.0);
		Circle c2 = c1.shallowCopy();
		Circle c3 = c1;
		
		System.out.println("c1 : "+c1);
		System.out.println("c2 : "+c2);
		System.out.println("c3 : "+c3);
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());	//얕은 복사1
		System.out.println(c3.hashCode());	//얕은 복사2
		
		System.out.println("=== c1.p.x = 3; ===");
		c1.p.x = 3;
		System.out.println("c1 : "+c1);
		System.out.println("c2 : "+c2);
		System.out.println("c3 : "+c3);
		System.out.println();
		
		Circle c4 = c1.deepCopy();
		System.out.println("c4 : "+c4);
		
		System.out.println("=== c1.p.x = 7; ===");
		c1.p.x = 7;
		System.out.println("c1 : "+c1);
		System.out.println("c2 : "+c2);
		System.out.println("c3 : "+c3);
		System.out.println("c4 : "+c4);
		
		
		
	}

}

class Circle implements Cloneable{	//**implements Cloneable을 잊지 말자!!
	Point1 p;
	double r;
	
	public Circle(Point1 p, double r) {
		this.p = p;
		this.r = r;
	}
	
	public Circle shallowCopy() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return (Circle)obj;
	}
	
	public Circle deepCopy() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		Circle c = (Circle) obj;
		c.p = new Point1(this.p.x, this.p.y);
		return c;
	}
	
	@Override
	public String toString() {
		return p+", 반지름= "+r;
	}
}



class Point1{
	int x, y;
	Point1(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "("+x+", "+y+")";
	}
}

