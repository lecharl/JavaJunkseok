import java.util.Arrays;

public class ArrayEx3 {

	public static void main(String[] args) {
//		배열 복사하기
		int[] arr1 = new int[5];
		for(int i=0; i<arr1.length; i++) {
			arr1[i] = (int)(Math.random()*arr1.length); 
		}
		System.out.println(Arrays.toString(arr1));
		
//		1. 새 배열 만들기
		int[] newArr = new int[arr1.length*2];
//		2. 넣기
		for(int i=0; i<arr1.length; i++) {
			newArr[i] = arr1[i]; 
		}
//		3. *** 참조변수가 가리키는 저장공간을 바꾸기
		arr1 = newArr;
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(newArr));

	}

}
