import java.util.Scanner;

public class FlowEx11 {

	public static void main(String[] args) {
//		주민번호를 입력받아 성별을 판별하고 2000년 이전 또는 이후에 출생한지 가르기
//		중첩 switch문!!
		System.out.print("당신의 주민번호를 입력하세요.(240122-1022155) >> ");
		Scanner scanner = new Scanner(System.in);
		String jumin = scanner.nextLine();
		char gender = jumin.charAt(7);
		String genString = "여성";
		String bfString = "이전";
		
//		유효한 주민번호인지 따지기
		if('1' <= gender && gender <= '4') {
			//		성별 판별하고
			switch (gender) {
			case '1': case '3':
				genString = "남성";
				//		2000년 이전/이후 따지기
				switch (gender) {
				case 3:
					bfString = "이후";
					break;
				}
				break;
				//1, 3이 아니라면 여성, 이전 출생이므로 4일 경우 따지기
			case '4':
				bfString = "이후";
				break;
			}
			System.out.printf("당신은 2000년 %s에 출생한 %s입니다.", bfString, genString);
		} else {
			System.out.println("유효하지 않은 주민등록번호입니다.");
		}
	}

}
