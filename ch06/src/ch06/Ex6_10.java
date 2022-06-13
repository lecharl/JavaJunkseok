package ch06;

public class Ex6_10 {

	public static void main(String[] args) {
//		오버로딩
		MyMath3 mm = new MyMath3();
//		println()메서드가 결과를 출력하려면 add메서드의 결과가 먼저 계산되어야 하기 때문에!! 뒤에 add메서드가 먼저!!!
		System.out.println("mm.add(3,3)의 결과 : "+mm.add(3,3));
		System.out.println("mm.add(3,3L)의 결과 : "+mm.add(3,3L));
		System.out.println("mm.add(3L,3)의 결과 : "+mm.add(3L,3));
		System.out.println("mm.add(3L,3L)의 결과 : "+mm.add(3L,3L));
		int a[] = {100,200,300};
		System.out.println("mm.add(a[])의 결과 : "+mm.add(a));

	}

}


class MyMath3{
	int add(int a, int b) {
		System.out.print("int add(int a, int b) => ");
		return a+b;
	}
	
	long add(int a, long b) {
		System.out.print("long add(int a, long b) => ");
		return a+b;
	}
	
	long add(long a, int b) {
		System.out.print("long add(long a, int a) => ");
		return a+b;
	}
	
	long add(long a, long b) {
		System.out.print("long add(long a, long b) => ");
		return a+b;
	}
	
	int add(int[] a) {
		System.out.print("int add(int[] a) => ");
		int result = 0;
		for(int i=0; i<a.length; i++) {
			result += a[i];
		}
		return result;
	}
}
