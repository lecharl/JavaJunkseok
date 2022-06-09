package ch05;

public class Ex5_7 {

	public static void main(String[] args) {
//		매개변수의 개수
		System.out.println("매개변수의 개수 : "+args.length);
//		각 요소 출력
		for(int i=0; i<args.length; i++) {
			System.out.printf("args[%d] = %s\n", i, args[i]);
		}

	}

}
