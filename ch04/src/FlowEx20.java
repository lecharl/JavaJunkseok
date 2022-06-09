
public class FlowEx20 {

	public static void main(String[] args) {
//		[1,1] [1,2] ... [1,5]
//		... [5,1] [5,2] ... [5,5]
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				System.out.printf("[%d,%d] ", i, j);
			}
			System.out.println();
		}

	}

}
