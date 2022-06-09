import java.util.Arrays;

public class ArrayEx10 {

	public static void main(String[] args) {
//		정렬 - 버블정렬
//		바깥쪽 반복문의 반복횟수 : arr.length - 1
//		안쪽 반복문의 반복횟수 : arr.length - 1 - i 
		
		int[] nArr = new int[10];
		
//		채우기
		for (int i = 0; i < nArr.length; i++) {
			nArr[i] = (int)(Math.random()*nArr.length);
		}
		System.out.println(Arrays.toString(nArr)+"\n");
		
//		오름차순으로 버블정렬
		for(int i=0; i<nArr.length - 1; i++) {
			// 자리바꿈이 발생했는지, 매 반복마다 false로 초기화
			boolean changed = false;
			for(int j=0; j<nArr.length - 1 - i; j++) {
				if(nArr[j] > nArr[j+1]) {
					int tmp = nArr[j];
					nArr[j] = nArr[j+1];
					nArr[j+1] = tmp;
					// 자리바꿈이 발생하면 true
					changed = true;
				}
				System.out.println(Arrays.toString(nArr));
			} // j end
			System.out.println();
			// *** 자리바꿈이 없으면(다 정렬되었으면) 반복문을 벗어난다 ***
			if(!changed) break;
		} // i end
		System.out.println(Arrays.toString(nArr));
		
		

	}

}
