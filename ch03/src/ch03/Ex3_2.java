package ch03;

public class Ex3_2 {

	public static void main(String[] args) {
		int i=5, j=0;
		
//		전위형 :: 증감시킨 후 참조!!
		j = ++i;
//		++i; 또는 i++;
//		j = i;
		System.out.println("j = ++i; >> i = "+i+", j = "+j);
		
		i=5;
		j=0;
		
//		후위형 :: 참조!! 먼저 한 후!! 증감시키기
		j = i++;
//		j = i;
//		i++;
		System.out.println("j = i++; >> i = "+i+", j = "+j);
		
		int k=5, l=5;
		System.out.println("k++ >> "+ k++);
		System.out.println("k >> "+ k);
		System.out.println("위는 아래와 같다 !!");
//		*** 위는 아래와 같다 !!
		System.out.println(l);
		l++;
		
		
		System.out.println(l);
		l = 6;
		System.out.println("++l >> "+ ++l);
		System.out.println("l++ >> "+ l++);

	}

}
