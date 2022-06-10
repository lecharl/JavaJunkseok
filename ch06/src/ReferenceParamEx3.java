
public class ReferenceParamEx3 {

	public static void main(String[] args) {
		int[] arr = new int[] {3,2,1,6,5,4};
		
		printArr(arr);
		sortArr(arr);
		printArr(arr);
		System.out.println("sum = "+ sumArr(arr));
	}

//	출력
	static void printArr(int[] arr) {
		System.out.print("[");
		for (int i : arr) {
			System.out.print(i+", ");
		}
		System.out.println("]");
	}
	
//	*** 정렬
	static void sortArr(int[] arr) {
		for(int i=0; i<arr.length - 1; i++) {
			for(int j=0; j<arr.length - 1 - i; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;					
				}
			}
		}
	}
	
//	각 요소 총합	
	static int sumArr(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum;
	}
	
}
