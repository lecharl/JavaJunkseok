package ch06;

public class Ex6_11 {

	public static void main(String[] args) {
		Data_1 d1 = new Data_1();
		Data_2 d2 = new Data_2(0);
//		기본생성자를 안만들면 -> The constructor Data_2() is undefined
		Data_2 d22 = new Data_2();

	}

}

class Data_1{
	int value;
}

class Data_2{
	int value;
	Data_2(){}
	Data_2(int x){
		value = x;
	}
}

