import java.util.Arrays;
import java.util.Scanner;

public class MultiArrEx1 {

	public static void main(String[] args) {
//		9 * 9 보드판에 배 위치를 알아내는 게임(좌표에 X하기)
		final int SIZE = 10;
		int x = 0, y = 0;
		
//		전체 보드판의 SIZE ==  10인 이유 :: 위와 옆에 행번호와 열번호를 넣어야 하기 때문에
//		-> shipBoard 보다 +1, +1 크기가 크다.
		char[][] board = new char[SIZE][SIZE];
		
//		실제 배의 위치가 있는 것? 정답지?
		byte[][] shipBoard = new byte[SIZE-1][SIZE-1];
//		1. shipBoard 채워넣기
		for(int i=0; i<shipBoard.length; i++) {
			for(int j=0; j<shipBoard[i].length; j++) {
				shipBoard[i][j] = (byte)(Math.random()*2);
			}
		}
//		shipBoard 출력
		System.out.println("실제 배의 위치(1이 배가 있을 때) ::");
		for (byte[] bs : shipBoard) {
			System.out.println(Arrays.toString(bs));
		}
		
//		2. 전체 보드판에 행번호와 열번호를 넣는다. :: board[0][1]~board[0][9], board[1,0], board[2,0] ... board[9,0]
		for(int i=1; i<SIZE; i++) {
			board[0][i] = board[i][0] = (char) (i + '0');	// 숫자->문자
		}
		
//		3. 사용자가 좌표 입력하기
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("좌표를 입력하세요.(종료는 00)(예: 33) >> ");
			String input = scanner.next();
			if (input.length() == 2) {
//				제대로 입력했다면
				x = input.charAt(0) - '0';	// 문자->숫자
				y = input.charAt(1) - '0';
				
				if(x==0 && y==0) {
					System.out.println("게임을 종료합니다.");
					break;
				}
			}
			if(input.length() != 2 || x<=0 || x>=SIZE || y<=0 || y>=SIZE) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				continue;
			}
//			4. 입력한 게 실제 shipBoard[x-1][y-1]의 좌표에 배가 있다면, board[x][y]에 'O'를 저장, 아니면 'X' 저장
			board[x][y] = (shipBoard[x-1][y-1] == 1)? 'O' : 'X';
			
//			5. 전체 보드판 board[][] 출력
			for (char[] cs : board) {
				System.out.println(Arrays.toString(cs));
			}
		}

	}

}
