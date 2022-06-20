package ch10;

import java.util.Calendar;

public class Ex10_4 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 7, 31);	//2015년 8월 31일
		
		System.out.println(toString(cal));
		
		System.out.println("= 1일 후 =");
		cal.add(Calendar.DATE, 1);
		System.out.println(toString(cal));
		
		System.out.println("= 6달 전 =");
		cal.add(Calendar.MONTH, -6);
		System.out.println(toString(cal));
		
		System.out.println("= 31일 후(roll) =");
		cal.roll(Calendar.DATE, 31);	//다른 필드에 영향을 안 줌
		System.out.println(toString(cal));
		
		System.out.println("= 31일 후(add) =");
		cal.add(Calendar.DATE, 31);
		System.out.println(toString(cal));
		

	}
	
	public static String toString(Calendar cal) {
		return cal.get(Calendar.YEAR)+"년 "+(cal.get(Calendar.MONTH)+1)+"월 "+cal.get(Calendar.DATE)+"일";
	}

}
