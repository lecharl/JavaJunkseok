import java.util.Scanner;

public class FlowEx9 {

	public static void main(String[] args) {
//		점수를 입력하여 학점 출력
//		기교를 부려서..!
		System.out.print("당신의 점수를 입력하세요.(1~100) >> ");
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		char grade = 'F';
		
		switch (score/10) {
//		90, 91, ... 99, 100 -> A
		case 9: case 10:
			grade = 'A';
			break;
//		80, 81, ... 88, 89 
		case 8:
			grade = 'B';
			break;
//		70, 71, ... 78, 79
		case 7:
			grade = 'C';
			break;
		}
		
		System.out.println("당신의 학점은 "+grade+"입니다.");

	}

}
