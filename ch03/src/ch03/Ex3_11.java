package ch03;

public class Ex3_11 {
//	Math.round()로 반올림 
	public static void main(String[] args) {
		double pi  = 3.141592;
//		Q. 반올림해서 소수점 셋째자리까지
//		x * 10의 3제곱 -> Math.round(?) -> 10의 3제곱.0 으로 다시 나눔
		System.out.println(pi);
		System.out.println(pi*1000);
		System.out.println(Math.round(pi*1000));
		System.out.println(Math.round(pi*1000)/1000.0);
		System.out.println((double)Math.round(pi*1000)/1000.0);
		System.out.println("-------------");
		
//		Q. 소수점 셋째자리까지, 그 아래는 버림
//		x * 10의 3제곱 -> (int)(?) -> 10의 3제곱.0 으로 다시 나눔
		double pi2 = 3.141592;
		System.out.println(pi2);
		System.out.println(pi2*1000);
		System.out.println((int)(pi2*1000));
		System.out.println((int)(pi2*1000)/1000.0);
		

	}

}
