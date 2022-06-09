
public class FlowEx29 {

	public static void main(String[] args) {
//		1~100 369 게임
//		1부터 100까지 출력하고, 369가 있으면 '짝' 출력하기
		for(int i=1; i<=100; i++) {
			System.out.print("i = "+i);
			
//			다른 변수에 저장해서 처리해야 한다. i는 반복문 제어에 사용되니까 
			int tmp = i;
//			각 자리수가 369 중 하나라도 있는지 == 각 자리수가 3의 배수인지 확인
//			각 자리수 : tmp%10, 3의 배수인지 : tmp%10%3
//			tmp != 0
			while(tmp != 0) {
				if(tmp%10%3 == 0 && tmp%10 != 0) {
					System.out.print(" 짝");
				}
				tmp /= 10;
			}
			System.out.println();
		}

	}

}
