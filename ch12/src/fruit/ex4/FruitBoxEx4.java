package fruit.ex4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FruitBoxEx4 {

	public static void main(String[] args) {
		FruitBox<Apple> appleBox = new FruitBox();
		FruitBox<Grape> grapeBox = new FruitBox();
		
		appleBox.add(new Apple("GreenApple", 300));
		appleBox.add(new Apple("GreenApple", 100));
		appleBox.add(new Apple("GreenApple", 200));

		grapeBox.add(new Grape("GreenGrape", 400));
		grapeBox.add(new Grape("GreenGrape", 300));
		grapeBox.add(new Grape("GreenGrape", 200));
		
//		***주의!! appleBox 자체는 list가 아니기 때문에 list로 뽑아주는 getList()메소드를 만들어서 넣어야 한다!!
//		내림차순
		Collections.sort(appleBox.getList(), new AppComp());
		Collections.sort(grapeBox.getList(), new GrapeComp());
		System.out.println(appleBox);
		System.out.println(grapeBox);
		System.out.println();
//		올림차순
		Collections.sort(appleBox.getList(), new FruitComp());
		Collections.sort(grapeBox.getList(), new FruitComp());
		System.out.println(appleBox);
		System.out.println(grapeBox);
		
	}

}

class Fruit{
	String name;
	int weight;
	
	public Fruit(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return name+"("+weight+")";
	}
}

class Apple extends Fruit{
	public Apple(String name, int weight) {
		super(name, weight);
	}
}

class Grape extends Fruit{
	public Grape(String name, int weight) {
		super(name, weight);
	}
}

class AppComp implements Comparator<Apple>{
	@Override
	public int compare(Apple a1, Apple a2) {
		return a2.weight - a1.weight;
	}
}

class GrapeComp implements Comparator<Grape>{
	@Override
	public int compare(Grape g1, Grape g2) {
		return g2.weight - g1.weight;
	}
}

// **아래처럼 Comparator<조상타입>으로 해야한다.. 아직은 잘 모르겠다...
class FruitComp implements Comparator<Fruit>{
	@Override
	public int compare(Fruit o1, Fruit o2) {
		return o1.weight - o2.weight;
	}
}

//-------box---------
class Box<T>{
	ArrayList<T> list = new ArrayList<T>();
	void add(T t) {
		list.add(t);
	}
	T get(int i) {
		return list.get(i);
	}
	int size() {
		return list.size();
	}
	ArrayList<T> getList(){
		return list;
	}
	@Override
	public String toString() {
		return list.toString();
	}
}

class FruitBox<T extends Fruit> extends Box<T>{}