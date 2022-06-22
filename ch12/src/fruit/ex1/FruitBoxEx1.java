package fruit.ex1;

import java.util.ArrayList;
import java.util.Iterator;

public class FruitBoxEx1 {

	public static void main(String[] args) {
		Box<Fruit> fruitBox = new Box();
		Box<Apple> appleBox = new Box();
		Box<Toy> toyBox = new Box();
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		
		toyBox.add(new Toy());
		
		System.out.println(fruitBox);
		System.out.println(fruitBox.size());
		Grape grape = (Grape) fruitBox.get(2);	//반환타입 Fruit
		System.out.println(grape);
		
		System.out.println("===");
		Iterator<Apple> it = appleBox.list.iterator(); 
		while(it.hasNext()) {
			Apple apple = it.next();
			System.out.println(apple);
		}
		
	}

}

class Box<T>{
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) {
		list.add(item);
	}
	T get(int index) {
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

class Toy {
	@Override
	public String toString() {
		return "Toy";
	}
}