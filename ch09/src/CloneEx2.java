import java.util.Arrays;

public class CloneEx2 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
//		배열의 경우엔 오버라이딩이 되어있어 바로 사용 가능
//		List, Vector, 등등도 다 clone()이 오버라이딩 되어있어서 바로 사용 가능하다!!
		int[] arrClone = arr.clone();
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arrClone));
		System.out.println("=== 변경 후 ===");
		arr[0] = 6;
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arrClone));
	}

}
