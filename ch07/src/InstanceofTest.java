
public class InstanceofTest {

	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		
//		instanceof 조상타입 -> true
		if(fe instanceof FireEngine) {	//FireEngine으로 형변환 가능한가
			FireEngine f2 = fe;
			System.out.println("This is a FireEngine instance");
			System.out.println(f2.getClass().getName());
		}
		if(fe instanceof Car) {	//Car로 형변환 가능한가
			Car c = (Car)fe;
			System.out.println("This is a Car instance");
			System.out.println(c.getClass().getName());
		}
		if(fe instanceof Object) {	//Object로 형변환 가능한가
			Object o = (Object)fe;
			System.out.println("This is a Object instance");
			System.out.println(o.getClass().getName());
		}
		System.out.println(fe.getClass().getName());
	}

}

class Car{}

class FireEngine extends Car {}