package ch07;

public class PlayerTest {

	public static void main(String[] args) {
//		AudioPlayer ap = new AudioPlayer();
		Player ap = new AudioPlayer();
		ap.play(100);
//		ap.stop();
		ap.pause();
		ap.pause();
	}

}

abstract class Player{
	boolean pause;	//일시정지 상태인지 아닌지
	int currentPos;	//현재 위치
	
//	추상클래스도 생성자가 있어야 한다.
	Player(){
		pause = false;
		currentPos = 0;
	}
	abstract void play(int pos);	//pos 지정된 위치
	abstract void stop();
	
//	추상메서드를 사용할 수 있다!
	void play() {
		play(currentPos);
	}
	
	void pause() {
		if(pause) {	//pause == true, 즉 멈춰있다면
			pause = false;	//재생
			play();
//			play(currentPos);
		}else {
			pause = true;	//재생중이라면
			stop();	//멈춰
		}
	}
}

class AudioPlayer extends Player{
	@Override
	void play(int pos) {
		super.currentPos = pos;
		System.out.println(pos+"위치부터 play합니다");
	}

	@Override
	void stop() {
		System.out.println("재생을 멈춥니다.");
	}
}