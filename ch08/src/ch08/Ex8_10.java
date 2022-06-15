package ch08;

import java.io.File;

public class Ex8_10 {

	public static void main(String[] args) {
		try {
			 File f = createFile(args[0]);
			 System.out.println("파일이 성공적으로 생성되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage()+ " 다시 입력해 주시기 바랍니다.");
		}
	}
	
	static File createFile(String fileName) throws Exception {
		if(fileName == null || "".equals(fileName)){
			throw new Exception();
		}else {
//			파일 생성 순서 :: 객체 생성, createNewFile() -> 생성된 객체의 참조를 반환
			File file = new File(fileName);
			file.createNewFile();
			return file;
		}
	}

}

