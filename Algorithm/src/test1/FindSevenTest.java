package test1;

public class FindSevenTest {

	public static void main(String[] args) {
		int count = 0;
		for(int i=1; i<77778; i++) {
			int tmp=i;
//			System.out.print("i= "+i);
			while(tmp != 0) {
				if(tmp%10%7 == 0 && tmp%10 != 0) {
					count++;
//					System.out.print(", 짝 "+count);
				}
				tmp /= 10;
			}
//			System.out.println();
		}
		System.out.println("7의 개수 : "+count);
	}

}
