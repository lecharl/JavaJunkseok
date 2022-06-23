package fruit.ex3;

import java.util.ArrayList;

public class Ex12_4 {

	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<? extends Fruit> appleBox = new FruitBox<Apple>();	
		//원래 저건데, FruitBox<? extends Fruit> 생략 가능
		FruitBox<Apple> appleBox2 = new FruitBox();
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		fruitBox.add(new Apple());
		fruitBox.add(new Fruit());
		
//		왜 안되지?????????????
//		appleBox.add(new Fruit());
		
		appleBox2.add(new Apple());
		
		System.out.println(Juicer.makeJuice(fruitBox));
		System.out.println(Juicer.makeJuice(appleBox));
		System.out.println(Juicer.makeJuice(appleBox2));
	}

}

class Juice{
	String name;
	Juice(String name){
		this.name = name + "juice";
	}
	@Override
	public String toString() {
		return name;
	}
}

class Juicer{
//	static <T extends Fruit> Juice makeJuice(FruitBox<T> fruitBox) {	//지네릭 메서드 
	static Juice makeJuice(FruitBox<? extends Fruit> fruitBox) {	//와일드카드 메서드, 여기선 둘다 됨!
		String tmp = "";
		for(Fruit fruit : fruitBox.getList()) {
			tmp += fruit + " ";
		}
		return new Juice(tmp);
	}
}

class Fruit{
	@Override
	public String toString() {
		return "Fruit";
	}
}

class Apple extends Fruit{
	@Override
	public String toString() {
		return "Apple";
	}
}

class Grape extends Fruit{
	@Override
	public String toString() {
		return "Grape";
	}
}

class Box<E>{	//여기의 E와 아래의 E는 다르다!!!!!!!
	ArrayList<E> list = new ArrayList();
	void add(E item) {
		list.add(item);
	}
	E get(int index) {
		return list.get(index);
	}
	int size() {
		return list.size();
	}
	ArrayList<E> getList(){
		return list;
	}
}

// ***
class FruitBox<T extends Fruit> extends Box<T> {
}