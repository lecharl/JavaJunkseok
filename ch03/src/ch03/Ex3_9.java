package ch03;

public class Ex3_9 {

	public static void main(String[] args) {
		int a = 1_000_000;
		int b = 2_000_000;
		
		long c = a*b;
		long d = (long)a*b;
		
		System.out.println("long c = a*b; :: "+c);			//오버플로우
		//둘 중 하나를(long)으로 수동 형변환해줘야 한다!!
		System.out.println("long d = (long)a*b; :: "+d);	
		
	}

}
