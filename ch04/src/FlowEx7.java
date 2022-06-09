
import java.util.Scanner;

public class FlowEx7 {

	public static void main(String[] args) {
//		컴퓨터와 가위바위보
//		가위1, 바위2, 보3
//		내가 이길 때: 가위-보(-2), 바위-가위(1), 보-바위(1) :: -2, 1
//		내가 질 때 : 가위-바위(-1), 바위-보(-1), 보-가위(2) :: -1, 2
//		비길 때 : 가위-가위(0), 바위-바위(0), 보-보(0) :: 0
		
		System.out.print("가위(1), 바위(2), 보(3) 중 하나를 입력하세요. > ");
		Scanner scanner = new Scanner(System.in);
		int my = scanner.nextInt();
//		***컴퓨터 -> 난수구하기로 처리***
		int computer = (int)(Math.random()*3) + 1;	//1<=x<4
		System.out.println("당신은 "+my+" 입니다.");
		System.out.println("컴퓨터는 "+computer+" 입니다.");
		switch (my-computer) {
		case -2: case 1:
			System.out.println("당신이 이겼습니다.");
			break;
		case -1: case 2:
			System.out.println("당신이 졌습니다.");
			break;
		default:
			System.out.println("비겼습니다.");
			break;
		}
	}
}
