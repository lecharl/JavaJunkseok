
public class FlowEx21 {

	public static void main(String[] args) {
//		[1,1] 
//		      [2,2]
//		...
//		                        [5,5]
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				if(i==j) {
					System.out.printf("[%d,%d] ", i, j);					
				}else {
					System.out.printf("%6c", ' ');
				}
			}
			System.out.println();
		}

	}

}
