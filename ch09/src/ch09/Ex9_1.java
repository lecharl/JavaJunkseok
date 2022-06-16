package ch09;

public class Ex9_1 {

	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		
		System.out.println(v1 == v2);
		System.out.println(v1.equals(v2));

	}

}

class Value{
	int value;
	Value(int value){
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Value)) return false;
		Value v = (Value)obj;
		return this.value == v.value;
//		if(obj instanceof Value) {
//			return this.value == ((Value)obj).value;
//		}else {
//			return false;
//		}
	}
}