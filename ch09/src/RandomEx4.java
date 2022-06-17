
public class RandomEx4 {

//		생성할 레코드의 수
	final static int RECORD_NUM = 10;
	final static String TABLE_NAME = "TEST_TABLE";
	final static String[] CODE1 = {"010", "011", "017", "018", "019"};
	final static String[] CODE2 = {"남자", "여자"};
	final static String[] CODE3 = {"10대", "20대", "30대", "40대", "50대"};

	public static void main(String[] args) {
		for(int i=0; i<RECORD_NUM; i++) {
			System.out.println("INSERT INTO TABLE "+TABLE_NAME+" VALUE ('"
					+ getRandomArr(CODE1)+"', '"
					+ getRandomArr(CODE2)+"', '"
					+ getRandomArr(CODE3)+"', "
					+ getRandom(100, 200)+");");	//100이상 200이하의 값 얻기
		}
	}
	
	
//	0이상 n이하
	public static int getRandom(int n) {
		return getRandom(0, n);
	}

//	from이상 to이하
	public static int getRandom(int from, int to) {
		return (int)(Math.random() * (Math.abs(to-from+1))+Math.min(from, to));
	}
	
//	배열에 저장된 값 중 하나 반환
	public static String getRandomArr(String[] arr) {
		return arr[getRandom(arr.length-1)];
	}

}
