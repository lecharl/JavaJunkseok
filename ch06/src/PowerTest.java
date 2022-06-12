
public class PowerTest {
	public static void main(String[] args) {
//		x의 1승부터 x의 n승까지의 합
		int x = 2;
		int n = 6;
		long result = power(x, n);
		for(int i=1; i<=5; i++) {
			result += power(x, i);
		}
		System.out.printf("%d의 1승부터 %d의 %d승까지의 합 :: %d", x,x, n, result);
	}
	
	static long power(int x, int n) {
		if(n <= 0) {
			return 1;
		}
		if(n == 1) {
			return x;
		}else {
			return x * power(x, n-1);
		}
	}
}
