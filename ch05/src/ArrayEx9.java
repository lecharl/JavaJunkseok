import java.util.Arrays;

public class ArrayEx9 {

	public static void main(String[] args) {
//		내가? 불연속적인 임의의 값으로 배열 채우기
		int[] code = {-4, -1, 3, 6, 11};
		int[] arr = new int[10];
		
		for(int i=0; i<arr.length; i++) {
//			code의 인덱스 0~4를 랜덤으로
			int n = (int)(Math.random()*code.length);
			arr[i] = code[n]; 
			System.out.println(Arrays.toString(arr));
		}

	}

}
