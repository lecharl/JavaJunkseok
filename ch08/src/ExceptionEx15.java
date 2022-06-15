import java.io.File;

public class ExceptionEx15 {

	public static void main(String[] args) {
		File file = createFile("");
		System.out.println(file.getName()+" 파일이 성공적으로 생성되었습니다.");
	}
	
	static File createFile(String fileName) {
//		여기서 예외 처리!!
		try {
			if(fileName == null || "".equals(fileName)) {
				throw new Exception("파일이름이 유효하지 않습니다.");	//위에 메소드에 던져주는 게 있어도 캐치블럭이 있기에 우선됨
			}
		} catch (Exception e) {
			fileName = "제목없음.txt";
		}finally {
			File file = new File(fileName);
			createNewFile(file);
			return file;
		}
	}
	
	static void createNewFile(File file) {
		try {
			file.createNewFile();
		} catch (Exception e) {
			
		}
	}
}
