import java.util.Enumeration;
import java.util.Properties;

public class PropertiesEx1 {

	public static void main(String[] args) {
		Properties p = new Properties();
		
		p.setProperty("timeout", "30");
		p.setProperty("language", "kr");
		p.setProperty("size", "10");
		p.setProperty("capacity", "10");
		
//		Enumeration을 이용해 출력
		Enumeration e = p.propertyNames();
		
		while(e.hasMoreElements()) {
			String element = (String)e.nextElement();
			System.out.println(element+"="+p.getProperty(element));
		}
		System.out.println();
		
		p.setProperty("size", "20");
		System.out.println("size = "+p.getProperty("size"));
		System.out.println("capacity = "+p.getProperty("capacity", "20"));
		System.out.println("loadfactor = "+p.getProperty("loadfactor", "0.75"));
		System.out.println(p);
		System.out.println();
		p.list(System.out);

	}

}
