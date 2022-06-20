import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedListTest {

	public static void main(String[] args) {
		ArrayList al = new ArrayList(2000000);	//추가할 데이터를 고려해 충분히 잡아야 함
		LinkedList ll = new LinkedList();
		
		System.out.println("=== 순차적으로 추가하기 ===");
		System.out.println("ArrayList :: "+addFromFirst(al));
		System.out.println("LinkedList :: "+addFromFirst(ll));
		System.out.println();
		System.out.println("=== 중간에 추가하기 ===");
		System.out.println("ArrayList :: "+addFrom500(al));
		System.out.println("LinkedList :: "+addFrom500(ll));
		System.out.println();
		System.out.println("=== 중간에 삭제하기 ===");
		System.out.println("ArrayList :: "+removeMiddle(al));
		System.out.println("LinkedList :: "+removeMiddle(ll));
		System.out.println();
		System.out.println("=== 순차적으로 삭제하기 ===");
		System.out.println("ArrayList :: "+removeFromEnd(al));
		System.out.println("LinkedList :: "+removeFromEnd(ll));
		

	}
	
	public static long addFromFirst(List list) {
		long start = System.currentTimeMillis();
		for(int i=0; i<1000000; i++)
			list.add(i+"");
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	public static long addFrom500(List list) {
		long start = System.currentTimeMillis();
		for(int i=0; i<10000; i++)
			list.add(500, "X");
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	public static long removeFromEnd(List list) {
		long start = System.currentTimeMillis();
		for(int i=list.size()-1; i>=0; i--)
			list.remove(i);
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	public static long removeMiddle(List list) {
		long start = System.currentTimeMillis();
		for(int i=0; i<10000; i++)
			list.remove(i);
		long end = System.currentTimeMillis();
		return end - start;
	}

}
