
public class TVCR extends TV00{
	VCR vcr = new VCR();
	
	void play() {
		vcr.play();
	}
	void stop() {
		vcr.stop();
	}
	void rew() {
		vcr.rew();
	}

	public static void main(String[] args) {

	}

}

class TV00{
	boolean power;
	int channel;
	
	void power() {power = !power;}
	void channelUp() {++channel;}
	void channelDown() {--channel;}
}

class VCR{
	boolean power;
	int counter = 0;
	void power() {power = !power;}
	void play() {System.out.println("play");}
	void stop() {System.out.println("stop");}
	void rew() {System.out.println("rew");}
}

