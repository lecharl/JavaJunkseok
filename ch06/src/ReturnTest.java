
public class ReturnTest {

	public static void main(String[] args) {
		ReturnTest r = new ReturnTest();
		
		int result = r.add(3, 5);
		System.out.println(result);
		
		int[] resultArr = {0};
		r.add(3, 5, resultArr);
		System.out.println(resultArr[0]);
	}

	void add(int i, int j, int[] resultArr) {
//		이렇게 참조변수로 값을 바꿨기 때문에 반환값이 없어도 됨!!
		resultArr[0] = i+j;
	}

	int add(int i, int j) {
		return i+j;
	}

}
