package ch06;

public class Ex6_8 {

	public static void main(String[] args) {
//		참조형 반환타입
		Data3 d = new Data3();
		d.x = 10;
		
		Data3 d2 = copy(d);
		System.out.println("main() : d.x = "+d.x);
		System.out.println("main() : d2.x = "+d2.x);

	}

	static Data3 copy(Data3 d) {
//		새로운 객체 생성
		Data3 tmp = new Data3();
		tmp.x = d.x;	//tmp.x = 10
		return tmp;
	}

}

class Data3 {
	int x;
}