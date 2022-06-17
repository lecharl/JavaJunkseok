import java.util.Random;

public class RandomEx1 {

	public static void main(String[] args) {
		Random r = new Random(1);
		Random r2 = new Random(1);
//		종자값 :: 뭔가...딱 고정을 시키는..? 할 때마다 값이 바뀌지 않네??
		
		System.out.println("= r =");
		for(int i=0; i<5; i++) {
			System.out.println(i + " : "+r.nextInt());
		}
		
		System.out.println("= r2 =");
		for(int i=0; i<5; i++) {
			System.out.println(i + " : "+r2.nextInt());
		}
	}

}
