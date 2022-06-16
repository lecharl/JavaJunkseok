

public class CloneEx1 {

	public static void main(String[] args) throws CloneNotSupportedException {
		Point oriPoint = new Point(3, 5);
//		** 반환타입이 Object이므로 꼭!! 형변환 해줘야 함!!
//		Point copyPoint = (Point) oriPoint.clone();
		Point copyPoint = oriPoint.clone();
//		copyPoint = oriPoint;
		
		System.out.println(oriPoint);
		System.out.println(copyPoint);
		
//		System.out.println(oriPoint.hashCode());
//		System.out.println(copyPoint.hashCode());
//		System.out.println(oriPoint.equals(copyPoint));
		
		oriPoint.x = 10;
		System.out.println(oriPoint);
		System.out.println(copyPoint);
		
	}

}

class Point implements Cloneable{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "x= "+x + ", y= "+y;
	}
	
//	clone() **
//	@Override
//	public Point clone() throws CloneNotSupportedException {
//		return (Point)super.clone();
//	}
	
	public Point clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return (Point)obj;
	}
}