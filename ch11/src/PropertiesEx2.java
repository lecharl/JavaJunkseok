import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesEx2 {

	public static void main(String[] args) {
//		외부파일(input.txt)로부터 데이터를 입력받아서 계산결과를 보여주는 예제
//		커맨드라인에서 inputfile을 지정해주지 않으면 프로그램을 종료한다.
		if(args.length != 1) {
			System.out.println("USAGE: java PropertiesEx2 INPUTFILENAME");
			System.exit(0);
		}
		
		Properties prop = new Properties();
//		미리 파일 만듦...
		prop.setProperty("name", "Seong Namkung");
		prop.setProperty("data", "9,1,5,2,8,13,26,11,35,1");
		System.out.println(prop);
		
		String inputFile = args[0];
		try {
			prop.store(new FileOutputStream("input.txt"), "This is comment..");
			prop.load(new FileInputStream(inputFile));
		} catch (FileNotFoundException e) {
			System.out.println("지정된 파일을 찾을 수 없습니다.");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String name = prop.getProperty("name");
//		**아래는 인코딩 문제로 한글이 깨질 수 있는 걸 방지
		try {
			name = new String(name.getBytes("8859_1"), "EUC-KR");
		} catch (Exception e) {
		}
		String[] data = prop.getProperty("data").split(",");
		int max = 0, min = 0;
		int sum = 0;
		
		for(int i=0; i<data.length; i++) {
			int intValue = Integer.valueOf(data[i]);
			if(i == 0)
				max = min = intValue;
			if(max < intValue)
				max = intValue;
			else if(min > intValue)
				min = intValue;
			sum += intValue;
		}
		System.out.println("이름 : "+name);
		System.out.println("최댓값 : "+max);
		System.out.println("최솟값 : "+min);
		System.out.println("합계 : "+sum);
//		System.out.println("평균 : "+(sum*100.0/data.length)/100);
		System.out.println("평균 : "+(sum/(double)data.length));

	}

}
