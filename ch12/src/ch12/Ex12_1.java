package ch12;

import java.util.ArrayList;

class Product{}
class Tv extends Product {}
class Audio extends Product{}

public class Ex12_1 {

	public static void main(String[] args) {
//		참조변수의 타입변수 == 생성된 객체(생성자)의 타입변수
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Tv> tvList = new ArrayList<Tv>();

//		Product와 그 자손들만, add(<Product>)
		productList.add(new Product());
		productList.add(new Tv());
		productList.add(new Audio());
		
		//**주의1) get(1)에 들어있는 객체가 Tv라도 반환타입은 <Product>이기 때문에
//		Product 타입의 참조변수로 받아야 한다!!!!!!
		Product product = productList.get(1);	//OK
		Tv tv = (Tv) productList.get(1);	//이렇게 형변환!!
		
//		Tv와 그 자손들만
		tvList.add(new Tv());
//		tvList.add(new Audio());
		
		System.out.println(productList);
		System.out.println("===");
		printAll(productList);
//		**주의2) printAll(0)은 매개변수가 ArrayList<Product> 인데, 
//		tvList 는 ArrayList<Tv> 이니까
//		printAll(tvList);
		
	}

	public static void printAll(ArrayList<Product> list) {
//		**이렇게 쓸 수 있음!!
		for (Product product : list) {
			System.out.println(product);
		}
	}
}
