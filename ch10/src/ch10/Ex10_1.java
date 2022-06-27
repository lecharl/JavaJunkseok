package ch10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex10_1 {

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();	//추상클래스이기 때문에 직접 객체를 생성하지 못한다.
		System.out.println(today.toString());
		System.out.println("연 "+today.get(Calendar.YEAR));
		System.out.println("월(0~11) "+today.get(Calendar.MONTH));	//0~11 -> 1월~12월
		System.out.println("일 "+today.get(Calendar.DATE));

		System.out.println("연 기준 몇째주 "+today.get(Calendar.WEEK_OF_YEAR));	//1월1일부터 지금까지 몇째주인지
		System.out.println("월 기준 몇째주 "+today.get(Calendar.WEEK_OF_MONTH));
		
		System.out.println("일2 "+today.get(Calendar.DAY_OF_MONTH));
		System.out.println("연 기준 일 "+today.get(Calendar.DAY_OF_YEAR));
		System.out.println("요일(1일~7토) "+today.get(Calendar.DAY_OF_WEEK));	//1~7 -> 일~토
		System.out.println("이달의 몇째 요일 "+today.get(Calendar.DAY_OF_WEEK_IN_MONTH));	//??????????????????????
		
		System.out.println("am0, pm1 "+today.get(Calendar.AM_PM));
		System.out.println("시(0~11) "+today.get(Calendar.HOUR));
		System.out.println("시(0~23) "+today.get(Calendar.HOUR_OF_DAY));
		System.out.println("분 "+today.get(Calendar.MINUTE));
		System.out.println("초 "+today.get(Calendar.SECOND));
		
		System.out.println("ms(0~999) "+today.get(Calendar.MILLISECOND));
//		1시간 = 60분*60초 = 3600초
//		천분의 1초를 1시간으로 표시하기 위해 3600*1000 으로 나누기 
		System.out.println("???? TimeZone(-12~ +12) "+(today.get(Calendar.ZONE_OFFSET))/(60*60*1000));
		System.out.println("이 달의 마지막 날 "+today.getActualMaximum(Calendar.DATE));
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM-dd");
		SimpleDateFormat sdf11 = new SimpleDateFormat("HH:mm:ss");
		Date d1 = new Date();	
		System.out.println(d1);
		System.out.println(sdf1.format(d1));
		System.out.println(sdf11.format(d1));
		
		Calendar c1 = Calendar.getInstance();
		System.out.println(c1.getTime());	//c1.getTime() :: Date
		System.out.println(sdf1.format(c1.getTime())); 
		System.out.println(sdf11.format(c1.getTime())); 
		

	}

}
