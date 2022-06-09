import java.util.Scanner;

public class FlowEx27 {

	public static void main(String[] args) {
//		입력하는 숫자들을 합하는데, 0을 입력하면 끝내기
		int num;
		int sum = 0;
//		*** flag 사용 ***
		boolean flag = true;
		System.out.println("합계를 구할 숫자를 입력하세요.(끝내려면 0을 입력)");
		Scanner scanner = new Scanner(System.in);
		while(flag) {
			System.out.print(">> ");
			num = scanner.nextInt();
			if(num == 0) {
				flag = false;
			}else {
				sum += num;
			}
		}
		System.out.println("합계 : "+sum);

	}

}
