
public class VarEx2_1 {

	public static void main(String[] args) {
		// 두 변수의 값 교환하기
		int x = 10, y = 20;
		int tmp;
		
		tmp = x;
		x = y;
		y = tmp;
		System.out.println("x="+x);
		System.out.println("y="+y);
	}

}
