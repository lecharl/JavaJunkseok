
public class FlowEx19 {

	public static void main(String[] args) {
//		111, 112, 113
//		121, 122, 123 ...
//		331, 332, 333
		
		for(int i=1; i<=3; i++) {
			for(int j=1; j<=3; j++) {
				for(int k=1; k<=3; k++) {
					System.out.println(""+i+j+k);
				}
			}
		}

	}

}
