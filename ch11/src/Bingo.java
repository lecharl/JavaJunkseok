import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Bingo {

	public static void main(String[] args) {
//		1~50 중 25개를 골라서 5*5 빙고판 만들기
		Set set = new HashSet();
		int[][] board = new int[5][5];
		
//		size 0~24까지 들어감 -> set.size() == 25
		for(int i=0; set.size()<25; i++) {
			set.add((int)(Math.random()*50) + 1 + "");	//1<=x<51 -> String,, 아래 parseInst(String)때문에 이런걸까?? ClassCastException
		}
		Iterator it = set.iterator();
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				board[i][j] = Integer.parseInt((String) it.next());	//**parseInt(String) :: String을 매개로 받고, next()는 반환이 Object이므로 형변환을 해줘야 함!!
				System.out.print((board[i][j] <10 ? "  " : " ") + board[i][j]);
			}
			System.out.println();
		}

	}//main

}
