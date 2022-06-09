import java.util.Scanner;

public class FlowEx8 {

	public static void main(String[] args) {
//		주민번호로 성별 판별하기
		System.out.print("당신의 주민번호를 입력하세요.(240122-1022155) >> ");
		Scanner scanner = new Scanner(System.in);
		String jumin = scanner.next();
//		아래처럼 하면 안됨!! 1-> 49가 됨
//		int gender = Integer.valueOf(jumin.charAt(7));
		char gender = jumin.charAt(7);
		System.out.println(gender);
		switch (gender) {
		case '1': case '3':
			System.out.println("당신은 남자입니다.");
			break;
		case '2': case '4':
			System.out.println("당신은 여자입니다.");
			break;
		default:
			System.out.println("유효하지 않은 주민등록번호입니다.");
		}
	}
}
