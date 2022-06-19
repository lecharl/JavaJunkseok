package ch10;

import java.util.*;
import java.util.Calendar;

public class Ex10_2 {

	public static void main(String[] args) {
//		1일~7월 이기 때문에 -> [0] = "" 로 함**
		final String[] DAY_OF_WEEK = {"","일","월","화","수","목","금","토"};
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		date1.set(2022, 3, 29);	//2022년 4월 29일
		date1.set(2022, Calendar.APRIL, 29);	//와 같음
		System.out.println("date1은 "+ toString(date1)+
				DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)]+"요일,");
		
		System.out.println("오늘(date2)은 "+toString(date2)+
				DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)]+"요일입니다.");
//		**두 날짜간의 차이 :: getTimeInMillis() 천분의 일초 단위로 변환해야 한다!!
		long difference = Math.abs(date2.getTimeInMillis() - date1.getTimeInMillis())/1000;
		System.out.println("date1부터 지금(date2)까지 "+difference+"초가 지났습니다.");
		System.out.println("일(day)로 계산하면 "+difference/(24*60*60)+"일입니다.");

	}

//	오버라이딩 아님!! 매개변수 있음!!
	public static String toString(Calendar cal) {
		return cal.get(Calendar.YEAR) + "년 "+ (cal.get(Calendar.MONTH)+1)+"월 "+ cal.get(Calendar.DATE)+"일 ";
	}
}
