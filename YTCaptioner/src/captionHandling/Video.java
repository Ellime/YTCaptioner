package captionHandling;

//import java.util.ArrayList;
import java.util.List;

public class Video {

	private String id;
	private List<Caption> captions;
	
	public Video(String videoId, List<Caption> videoCaptions) {
		id = videoId;
		captions = videoCaptions;
	}
	
	public String getId() {
		return id;
	}
	
	public List<Caption> getCaptions() {
		return captions;
	}
	
	public void setId(String videoId) {
		id = videoId;
	}
	
	public boolean matchesVideoId(String videoId) {
		return id.equalsIgnoreCase(videoId);
	}
}