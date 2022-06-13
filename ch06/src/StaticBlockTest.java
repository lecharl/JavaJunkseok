
public class StaticBlockTest {
	static int[] arr = new int[10];
	
	static {
		for(int i=0; i<arr.length; i++) {
//			1~10의 난수로 초기화하는 건 간단하게 못하니까
			arr[i] = (int)(Math.random()*10)+1;
		}
	}

	public static void main(String[] args) {
		for(int i=0; i<arr.length; i++) {
			System.out.printf("arr[%d] : %d\n", i, arr[i]);
		}
	}

}
