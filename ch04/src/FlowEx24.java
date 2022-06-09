
public class FlowEx24 {

	public static void main(String[] args) {
//		카운트다운 시작
		int i = 11;
		System.out.println("카운트다운을 시작합니다.");
		
		while (i-- !=0) {
			System.out.println(i);
//			아래 세개는 같은 뜻
			for(long cnt=5_000_000_000L; cnt>0; cnt--) {
				;
			}
//			for(long cnt=5_000_000_000L; cnt>0; cnt--) {}
//			for(long cnt=5_000_000_000L; cnt>0; cnt--) ;
		}
		System.out.println("GAME OVER");
	}
}
