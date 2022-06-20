package ch11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex11_4 {
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;

	public static void main(String[] args) {
		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");
		
		while(true) {
			System.out.println(">>");
			try {
				Scanner sc = new Scanner(System.in);
				String input = sc.nextLine().trim();
				
				if("".equals(input)) continue;
				if(input.equalsIgnoreCase("q")) {
					System.exit(0);
				}else if(input.equalsIgnoreCase("help")) {
					System.out.println(" help - 도움말을 보여줍니다.");
					System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
					System.out.println(" history - 최근에 입력한 명령어를 "+MAX_SIZE+"개 보여줍니다.");
				}else if (input.equalsIgnoreCase("history")) {
//					입력받은 명령어 저장(help, q 제외 나머지 명령어들을 저장!!)
					save(input);
					
//					내용 보여주기
					LinkedList linkedList = (LinkedList)q;	//get()를 사용하기 위해!!
					final int SIZE = linkedList.size();
					for(int i=0; i<SIZE; i++) {
						System.out.println((i+1)+". "+linkedList.get(i));
					}
				}else {
					save(input);
					System.out.println(input);
				}
			} catch (Exception e) {
				System.out.println("입력 오류입니다.");
			}
		}
		
	}//main
	
	public static void save(String input) {
//		queue에 저장
		if(!"".equals(input)) {
			q.offer(input);
		}
		
//		최대크기를 넘으면 처음 거 삭제
		if(q.size() > MAX_SIZE) {
			q.poll();
		}
	}//save

}
