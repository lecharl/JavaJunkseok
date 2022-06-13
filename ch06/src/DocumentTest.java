
public class DocumentTest {

	public static void main(String[] args) {
		Document d1 = new Document();
		Document d2 = new Document("죠르디");
		Document d3 = new Document("새콤달콤");
		Document d4 = new Document();
		System.out.println("전체 문서의 개수는 총 "+Document.count+"개입니다.");
		System.out.println("이름없는 문서의 개수는 총 "+Document.noNameCount+"개입니다.");
	}

}

class Document{
//	제목을 지정하지 않았을 때 문서 개수
	static int noNameCount;
	String name;
//	총 문서 개수
	static int count;
	
	public Document() {
		this("제목없음"+ ++noNameCount);
	}
	
	Document(String name){
		this.name = name;
		System.out.println("문서 "+this.name+"가(이) 생성되었습니다.");
		count++;
	}
}