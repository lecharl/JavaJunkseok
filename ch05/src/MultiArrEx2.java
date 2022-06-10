import java.util.Arrays;
import java.util.Scanner;

public class MultiArrEx2 {

	public static void main(String[] args) {
//		빙고! 5*5 빙고판에 1~25를 랜덤으로 지정 후, 
//		입력한 숫자가 빙고판에 있으면 해당 숫자를 0으로 바꾸기
		
//		사이즈는 처음부터 정하는가 보다.
		final int SIZE = 5;
//		빙고판을 섞기 위한 인덱스를 정할 x, y
		int x=0, y=0, num=0;
//		num은 뭐지?
		int[][] bingo = new int[SIZE][SIZE];
		
//		1. *** bingo판을 1~25로 초기화
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				bingo[i][j] = SIZE*i + (j+1);
			}
		}
		for (int[] is : bingo) {
			System.out.println(Arrays.toString(is));
		}
//		2. 섞기 : *** 랜덤으로 인덱스 숫자 뽑기
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				x = (int)(Math.random()*SIZE);
				y = (int)(Math.random()*SIZE);
				
//				bingo[i][j]와 bingo[x][y] 값 바꾸기
				int tmp = bingo[i][j];
				bingo[i][j] = bingo[x][y];
				bingo[x][y] = tmp;
				
			}
		}
		System.out.println("섞은 후::");
		
		Scanner scanner = new Scanner(System.in);
		do {
//			3. 출력
			for(int i=0; i<bingo.length; i++) {
				for(int j=0; j<bingo[i].length; j++) {
					System.out.printf("%2d ", bingo[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			System.out.printf("1~%d의 숫자를 입력하세요. (종료: 0) >> ", SIZE*SIZE);
			num = scanner.nextInt();
			
//			4. 입력받은 숫자와 같은 숫자에 0 저장
//			찾기
			outer: for(int i=0; i<bingo.length; i++) {
				for(int j=0; j<bingo[i].length; j++) {
					if(num == bingo[i][j]) {
						bingo[i][j] = 0;
//						*** 빠져나가기!!
						break outer;
					}
				}
			}
			
		} while (num!=0);
		System.out.println("게임을 종료합니다.");
	}

}
