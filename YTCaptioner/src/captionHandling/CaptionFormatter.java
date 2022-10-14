package captionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CaptionFormatter {
	
	public static String videoJson = "iLearnt3dAnimation.json";

	public static void main(String[] args) {
		
		/* 
		 * WIP: Testing video creation.
		 */
		
		Video newVideo = null;
		try {
			Reader videoReader = new FileReader(videoJson);
			GsonBuilder builder = new GsonBuilder();
			builder.registerTypeAdapter(Video.class, new VideoAdapter());
			Gson gson = builder.create();
			newVideo = gson.fromJson(videoReader, Video.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("What video ID was read: " + newVideo.getId());
			System.out.println("What captions were read: ");
			List<Caption> newCaptions = newVideo.getCaptions();
			int captionQty = newCaptions.size();
			for (int i = 0; i < captionQty; i++) {
				Caption caption = newCaptions.get(i);
				System.out.println("Display \"" + caption.getText() + "\" for " + caption.getDuration() + " seconds.");
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
}
