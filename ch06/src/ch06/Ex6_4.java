package ch06;

public class Ex6_4 {

	public static void main(String[] args) {
		MyMath mm = new MyMath();
		System.out.println("add(5L, 3L) = "+mm.add(3l, 5l));
		System.out.println("substract(5L, 3L) = "+mm.substract(3l, 5l));
		System.out.println("multiply(5L, 3L) = "+mm.multiply(3l, 5l));
		System.out.println("divide(5L, 3L) = "+mm.divide(3l, 5l));
		System.out.println("max(5L, 3L) = "+mm.max(3l, 5l));
		
		mm.print99dan(10);
	}

}

class MyMath{
	long add(long a, long b) {
		long result = a+b;
		return result;
	}
	long substract(long a, long b) {return a-b;}
	long multiply(long a, long b) {return a*b;}
	double divide(double a, double b) {
//		0으로 나눌 수 없으므로! 매개변수의 유효성 검사!!
		if(b == 0.0) {
			System.out.println("0으로 나눌 수 없습니다.");
			return 0;
		}
		return a/b;
	}
	
	long max(long a, long b) {
		return (a>b)? a : b;
	}
	
	void print99dan(int dan) {
		if(!(2 <= dan && dan <= 9)) {
			return;
		}
		for(int i=1; i<=9; i++) {
			System.out.printf("%d * %d = %d%n", dan, i, dan*i);
		}
	}
}