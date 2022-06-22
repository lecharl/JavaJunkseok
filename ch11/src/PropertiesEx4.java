import java.util.Properties;

public class PropertiesEx4 {

	public static void main(String[] args) {
//		시스템 속성 가져오기
		Properties sysProp = System.getProperties();
		System.out.println("java version : "+sysProp.getProperty("java.version"));
		System.out.println("user.language : "+sysProp.getProperty("user.language"));
		sysProp.list(System.out);
	}

}
