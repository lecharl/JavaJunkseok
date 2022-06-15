
public class ParserTest {

	public static void main(String[] args) {
//		static메서드라서 가능!
		Parsable parsable = ParserManager.getParser("XML");
		parsable.parse("notitle.xml");

		parsable = ParserManager.getParser("HTML");
		parsable.parse("fighting.html");
	}

}

interface Parsable{
	void parse(String fileName);
}

class XMLParser implements Parsable{
	public void parse(String fileName) {
		System.out.println(fileName+" - XML parsing completed");
	}
}

class HTMLParser implements Parsable{
	public void parse(String fileName) {
		System.out.println(fileName+" - HTML parsing completed");
	}
}

class ParserManager{
	public static Parsable getParser(String type) {
		if("XML".equals(type)) {
			return new XMLParser();
		}else {
			return new HTMLParser();
		}
	}
}