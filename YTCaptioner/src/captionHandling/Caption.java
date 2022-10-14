package captionHandling;

public class Caption {

	private String text;
	private int duration;
	
	protected Caption(String captionText, int captionDuration) {
		text = captionText;
		duration = captionDuration;
	}
	
	protected Caption(int inputDuration) {
		text = "";
		duration = inputDuration;
	}
	
	public String getText() {
		return text;
	}
	
	public int getDuration() {
		return duration;
	}
}
