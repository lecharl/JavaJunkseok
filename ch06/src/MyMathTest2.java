
public class MyMathTest2 {

	public static void main(String[] args) {
//		클래스메서드 호출 - 인스턴스 생성 없이 호출 가능
		System.out.println(MyMath2.add(200L, 100L));
		System.out.println(MyMath2.substract(200L, 100L));
		System.out.println(MyMath2.multiply(200L, 100L));
		System.out.println(MyMath2.divide(200.0, 100.0));
		
		MyMath2 mm = new MyMath2();
		mm.a = 200L;
		mm.b = 100L;
//		인스턴스메서드는 인스턴스 생성 후에만 호출이 가능
		System.out.println(mm.add());
		System.out.println(mm.substract());
		System.out.println(mm.multiply());
		System.out.println(mm.divide());
		
	}

}


class MyMath2{
	long a, b;
	
//	인스턴스 메서드
//	인스턴스 변수 a,b 만을 이용해서 작업하므로 매개변수가 필요없다.
	long add() {return a+b;}
	long substract() {return a-b;}
	long multiply() {return a*b;}
	double divide() {return (double)a/b;}
	
//	클래스 메서드, static 메서드
	static long add(long a, long b) {return a+b;}
	static long substract(long a, long b) {return a-b;}
	static long multiply(long a, long b) {return a*b;}
	static double divide(double a, double b) {return a/b;}
}
