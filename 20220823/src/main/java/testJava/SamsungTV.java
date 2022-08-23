package testJava;

public class SamsungTV implements TV {
	
	private Speaker speaker;
	

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	@Override
	public void powerOn() {
		System.out.println("삼성 TV 전원을 켠다.");

	}

	@Override
	public void powerOff() {
		System.out.println("삼성 TV 전원을 끈다.");

	}

	@Override
	public void volumeUp() {
		speaker.model();
		System.out.println("볼륨을 높인다.");

	}

	@Override
	public void volumeDown() {
		speaker.model();
		System.out.println("볼륨을 줄인다.");

	}

}
