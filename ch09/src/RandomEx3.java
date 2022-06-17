import java.util.Arrays;

public class RandomEx3 {

	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			System.out.print(getRandom(5, 10)+", ");
		}
		System.out.println();
		
		int[] result = fillRandom(new int[10], new int[] {2,3,7,5});
		System.out.println(Arrays.toString(result));

	}

//	from<= ~ <=to 정수 난수 반환
//	== from<= ~ <to+1
	public static int getRandom(int from, int to) {
//		내가 한 방법. 근데 이건 from > to 이라고 확정해놓은거라 안좋은 방법
//		return new Random().nextInt(to - from + 1) + from;
		return (int)(Math.random() * (Math.abs(to-from)+1)) + Math.min(from, to);
	}
	
//	배열arr을 배열data에 있는 값들로 랜덤으로 지정해서 채우고 반환
	public static int[] fillRandom(int[] arr, int[] data) {
		for(int i=0; i<arr.length; i++) {
			arr[i] = data[getRandom(0, data.length-1)];
		}
		return arr;
	}
	
//	배열arr을 from이상 to이하의 값으로 채워서 반환
	public static int[] fillRandom(int[]arr, int from, int to) {
		for(int i=0; i<arr.length; i++) {
			arr[i] = getRandom(from, to);
		}
		return arr;
	}
}
