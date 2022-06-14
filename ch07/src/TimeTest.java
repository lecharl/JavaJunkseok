
public class TimeTest {

	public static void main(String[] args) {
		Time t = new Time();
		t.setHour(22);
		t.setMinute(55235);
		t.setSecond(55);
		System.out.println(t);
		
//		-> 매개변수 있는 생성자로 해보자!!
		Time t2 = new Time(12, 36, 336783);
		System.out.println(t2);
	}

}

class Time{
	private int hour;	//0~23, 기본값 0
	private int minute;	//0~59, 기본값 0
	private int second;	//0~59, 기본값 0
	
//	***생성자***
	Time(int hour, int minute, int second){
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}
	
	Time(){
		this(0, 0, 0);
	}
	
	public void setHour(int hour) {
//		if(hour < 0 || hour > 23) 	return;
		if(isInvalid(hour, 23)) return;
		this.hour = hour;
	}
	
	public int getHour() {	return this.hour;}
	
	public void setMinute(int minute) {
//		if(minute < 0 || minute > 59) 	return;
		if(isInvalid(minute, 59)) return;
		this.minute = minute;
	}
	
	public int getMinute() {return this.minute; }
	
	public void setSecond(int second) {
//		if(second < 0 || second > 59) return;
		if(isInvalid(second, 59)) return;
		this.second = second;
	}
	public int getSecond() {return this.second; }
	
//	무효한 시간인지, true면 무효 false면 유효한 시간
	private boolean isInvalid(int input, int max) {
		if(input < 0 || input > max) return true;
		else return false;
	}
	
	@Override
	public String toString() {
		return hour+"시 "+minute+"분 "+second+"초";
	}
}