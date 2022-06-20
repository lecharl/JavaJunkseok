package ch10;

import java.util.Calendar;

public class Ex10_6 {

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Usage : java Ex10_6 2015 9");
			return;
		}
		int year = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		int START_DAY_OF_WEEK = 0;	//시작하는 날의 요일
		int END_DAY = 0;
		
		Calendar sDay = Calendar.getInstance();	//시작일
		Calendar eDay = Calendar.getInstance();	//끝일
		
		sDay.set(year, month-1, 1);	
		eDay.set(year, month, 1);
		eDay.add(Calendar.DATE, -1);
		
//		**첫번째 요일이 무슨 요일인지
		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
		
//		**eDay에 지정된 날짜 얻어오기
		END_DAY = eDay.get(Calendar.DATE);
		
		System.out.println("      "+args[0]+"년 "+args[1]+"월");
		System.out.println(" SU MO TU WE TH FR SA");
		
//		**START_DAY_OF_WEEK, 즉 해당 월의 요일에 따라서 공백을 출력하기
//		예) 수요일(4) -> 공백 세번
		for(int i=1; i<START_DAY_OF_WEEK; i++) {
			System.out.print("   ");
		}
		
//		**1) i는 1일~말일까지 돌기
//		**2) n은 %7==0 일때 \n
		for(int i=1, n=START_DAY_OF_WEEK; i<=END_DAY; i++, n++) {
//			한자리면 공백 2, 두자리면 공백 1
			System.out.print((i<10)? "  "+i : " "+i);	//바로 sop 할 수도 있었구나...
			if(n%7==0) System.out.println();
		}

	}

}
