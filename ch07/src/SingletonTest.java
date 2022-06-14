
public class SingletonTest {
	public static void main(String[] args) {
//		The constructor Singleton() is not visible
//		Singleton s = new Singleton();
		Singleton s = Singleton.getInstance();	//1)
	}
}

final class Singleton{
//	2) getInstance()에서 사용될 수 있도록 인스턴스가 미리 생성되어야 하므로 static이어야 한다!!
	private static Singleton s = new Singleton();
	private Singleton() {
		//...
	}
	
//	1) 인스턴스를 생성하지 않고도 호출할 수 있어야 하므로 static이어야 한다!!
	public static Singleton getInstance() {
//		2)
		if(s == null) {
			s = new Singleton();
		}
		return s;
	}
}