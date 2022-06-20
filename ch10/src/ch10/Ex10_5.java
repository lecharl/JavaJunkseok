package ch10;

import java.util.Calendar;

public class Ex10_5 {

	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		date.set(2015, 0, 31);	//2015년 1월 31일
		System.out.println(toString(date));
		
		date.roll(Calendar.MONTH, 1);
		System.out.println(toString(date)); //31일이 2월에 없기 때문에 자동으로 (말일인) 28일로!
		

	}
	
	public static String toString(Calendar cal) {
		return cal.get(Calendar.YEAR)+"년 "+(cal.get(Calendar.MONTH)+1)+"월 "+cal.get(Calendar.DAY_OF_MONTH)+"일";
	}

}
