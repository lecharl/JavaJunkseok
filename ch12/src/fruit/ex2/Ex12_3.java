package fruit.ex2;

import java.util.ArrayList;

public class Ex12_3 {

	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox();
		FruitBox<Apple> appleBox = new FruitBox();
		FruitBox<Grape> grapeBox = new FruitBox();
		Box<Toy> toyBox = new Box();
//		FruitBox<Toy> toyBox2 = new FruitBox();	//FruitBox<Fruit> -> Fruit과 그 자손
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		fruitBox.add(new Apple());
		
		appleBox.add(new Apple());
//		appleBox.add(new Grape());	//FruitBox<Apple> -> Apple과 그 자손
		
		grapeBox.add(new Grape());
		
		System.out.println("fruitBox - "+fruitBox);
		System.out.println("appleBox - "+appleBox);
		System.out.println("grapeBox - "+grapeBox);

	}

}

interface Eatable{}

class Fruit implements Eatable{
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

class Toy{
	@Override
	public String toString() {
		return "Toy";
	}
}

class FruitBox<E extends Fruit & Eatable> extends Box<E>{}


class Box<E>{
	ArrayList<E> list = new ArrayList<E>();
	
	void add(E item) {
		list.add(item);
	}
	E get(int index) {
		return list.get(index);
	}
	int size() {
		return list.size();
	}
	@Override
	public String toString() {
		return list.toString();
	}
}