package ch07;

class Tv{
	boolean power;
	int channel;
	
	void power() {power = !power;}
	void channelUp() {channel++;}
	void channelDown() {channel--;}
}

class SmartTv extends Tv{
	boolean caption;
	void displayCaption(String text) {
		if(caption) {
			System.out.println(text);
		}
	}
}


public class Ex7_1 {

	public static void main(String[] args) {
		SmartTv tv = new SmartTv();
		tv.channel = 10;
		tv.channelUp();
		System.out.println(tv.channel);
		
		System.out.println("caption 상태 : "+tv.caption);
		tv.displayCaption("Hello World!");
		tv.caption = true;
		System.out.println("caption 상태 : "+tv.caption);
		tv.displayCaption("Hello World!");

	}

}
