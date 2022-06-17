import java.util.Random;

public class RandomEx2 {

	public static void main(String[] args) {
//		난수 빈도수 구하기
		int[] random = new int[100];
		int[] count = new int[10];
		
		for(int i=0; i<random.length; i++) {
//			0<=~<10 :: (int)(Math.random()*10)
			random[i] = new Random().nextInt(9)+1;	//시험삼아 1<=~<10
			System.out.print(random[i]);
		}
		System.out.println();
		for(int i=0; i<random.length; i++) {
			count[random[i]]++;
		}
//		내가 한 방법
		for(int i=0; i<count.length; i++) {
			System.out.print(i+"의 개수 :: ");
			if(count[i] > 0) {
				for(int j=1; j<=count[i]; j++) {
					System.out.print("#");
				}
				System.out.print(" :: "+count[i]+"개");
			}else {
				System.out.print(" :: 0개");
			}
			System.out.println();
		}
//		자정 2)
		System.out.println();
		for(int i=0; i<count.length; i++) {
			System.out.println(i+"의 개수 :: "+ printGraph('#', count[i])+ " :: "+count[i]+"개");
		}
		

	}
	
//	자정 1) printGraph() 만들기
//	value만큼 ch출력
	public static String printGraph(char ch, int value) {
		char[] bar = new char[value];
		for(int i=0; i<bar.length; i++) {
//			value만큼(bar의 길이만큼) ch를 bar에 담기
			bar[i] = ch;
		}
//		문자열로 반환
		return new String(bar);
	}

}
