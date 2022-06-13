
public class ProductTest {

	public static void main(String[] args) {
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		
		System.out.println("p1의 제품번호는 "+p1.serialNo);
		System.out.println("p2의 제품번호는 "+p2.serialNo);
		System.out.println("p3의 제품번호는 "+p3.serialNo);
		System.out.println("생산된 제품의 수는 모두 "+Product.count+"개입니다.");
	}

}

class Product{
//	생성된 인스턴스의 수 -> static 변수
//	인스턴스 변수라면 인스턴스가 생성될 때마다 0으로 초기화되니까 ㄴㄴ
	static int count;
//	각 인스턴스의 고유번호 -> 인스턴스 변수
	int serialNo;
	
//	인스턴스 초기화 블럭
//	***인스턴스가 생성될 때마다 수행***
//	코드의 의미상 모든 생성자에서 공통으로 수행되어야 하는 내용
	{
		count++;
		serialNo = count;
	}
	
	Product() {
//		여기다 해도 됨. 
	}
}