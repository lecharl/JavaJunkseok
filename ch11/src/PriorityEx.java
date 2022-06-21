import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityEx {

	public static void main(String[] args) {
//		PriorityQueue - null 저장 못함
//		저장순서에 관계없이 우선순위가 높은 것부터 꺼내게 된다.
//		저장공간으로 배열을 사용하며, 각 요소를 heap이라는 자료구조의 형태로 저장한다.
		Queue pq = new PriorityQueue();
		pq.offer(new Integer(3));
		pq.offer(1);
		pq.offer(5);
		pq.offer(2);
		pq.offer(4);
		System.out.println(pq);	//pq의 내부 배열을 출력
		Object obj = null;
		
//		저장된 요소 하나씩 꺼내기
		while((obj = pq.poll()) != null)
			System.out.println(obj);
	}

}
