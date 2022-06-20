package ch10;

import java.util.Calendar;

public class Ex10_7 {

	public static void main(String[] args) {
		if(args.length!=2) {
			System.out.println("Usage: java Ex10_7 2015 11");
			return;
		}
		int year = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		
		Calendar sDay = Calendar.getInstance();
		Calendar eDay = Calendar.getInstance();
		
//		비워주기
		sDay.clear();
		eDay.clear();
		
//		지정하기
		sDay.set(year, month-1, 1);	//2022 6 1
		eDay.set(year, month-1, sDay.getActualMaximum(Calendar.DATE));	//2022 6 30
		
//		**1일이 속한 주의 일요일로 날짜 설정
		sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);	//1일이 수요일이면 4 -> -4 + 1 -> -3 -> 2022 5 29
//		**말일이 속한 주의 토요일로 날짜 설정
		eDay.add(Calendar.DATE, 7 - eDay.get(Calendar.DAY_OF_WEEK));	//말일이 목요일이면 5 -> 7 - 5 -> +2 -> 2022 7 2
		
		System.out.println("      "+year+"년 "+month+"월");
		System.out.println(" SU MO TU WE TH FR SA");
		
//		**시작일부터 마지막일까지(sDay <= eDay) 1씩 증가시키면서 Calendar.DATE 출력
		for(int n=1; sDay.before(eDay) || sDay.equals(eDay); sDay.add(Calendar.DATE, 1)) {
			int day = sDay.get(Calendar.DATE);
			System.out.print((day <10)? "  "+day : " "+day);
			if(n++%7 == 0) System.out.println();
		}

	}

}
