package ch10;

import java.util.*;
import java.util.Calendar;

public class Ex10_2 {

	public static void main(String[] args) {
		final String[] DAY_OF_WEEK = {"","일","월","화","수","목","금","토"};
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		date1.set(2022, 3, 29);	//2022년 4월 29일
		date1.set(2022, Calendar.APRIL, 29);	//와 같음
		System.out.println("date1은 "+ toString(date1)+
				DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)]);

	}

}
