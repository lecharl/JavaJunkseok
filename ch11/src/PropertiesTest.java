import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		Properties p = new Properties();
//		추가 .. map.put(k, v)
		p.setProperty("autosave", "5");
		p.setProperty("language", "한글");
		p.setProperty("timeout", "10");
		
		System.out.println(p);
		
//		읽기 .. map.get(key)
		System.out.println(p.getProperty("autosave"));
		System.out.println(p.getProperty("autosave2", "-1"));	//찾고 없으면 "-1" 
		System.out.println(p.getProperty("autosave2"));	//찾고 없으면 "-1" 
		
//		출력(스트림)
		p.list(System.out);
		
		
//		파일로 저장, 읽기
		try {
			p.load(new FileInputStream("output.txt"));
			System.out.println(p);
			p.store(new FileOutputStream("output.txt"), "commmmmmment");
//			p.store(new FileOutputStream("c:\\java\\output.text"), "주석");	//이처럼 경로 지정 가능
			p.storeToXML(new FileOutputStream("output.xml"), "hangeul possible");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
