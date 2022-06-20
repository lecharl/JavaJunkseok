import java.util.Vector;

public class VectorEx1 {

	public static void main(String[] args) {
		Vector v = new Vector(5);	//**용량capacity == 5
		v.add("1");
		v.add("2");
		v.add(3);
//		v.add("5");
		print(v);
		
		v.trimToSize();	//빈공간 없애기
		System.out.println("=== After trimToSize() ===");
		print(v);	// size() == capacity()
		
		v.ensureCapacity(6);
		System.out.println("=== After ensureCapacity(6) ===");
		print(v);
		
		v.setSize(7);	//capacity가 작을 경우, 자동적으로 기존capacity*2 
		System.out.println("=== After setSize(7) ===");
		print(v);
		
		v.clear();	//모든 요소 삭제 -> size만 0, capaticy는 그대로!
		System.out.println("=== After clear() ===");
		print(v);
		
		
		

	}
	
	public static void print(Vector vector) {
		System.out.println(vector);
		System.out.println("size() :: "+vector.size());
		System.out.println("capacity() :: "+vector.capacity());
		System.out.println();
	}

}
