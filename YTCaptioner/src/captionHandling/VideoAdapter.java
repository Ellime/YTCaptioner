package captionHandling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class VideoAdapter extends TypeAdapter<Object> {

	@Override
	public Video read(JsonReader reader) throws IOException {
		if (reader.peek() == JsonToken.NULL) {
			reader.nextNull();
			return null;
		}
		String videoId = null;
		reader.beginObject();
		if (reader.nextName().equals("id")) {
			videoId = reader.nextString();
		}
		else {
			System.out.println("Error: No video ID.");
			return null;
		}
		if(reader.nextName().equals("captions")) {
			List<Caption> captions = new ArrayList<Caption>();
			reader.beginArray();
			while(reader.hasNext()) {
				reader.beginObject();
				String captionText = null;
				int captionDuration = 0;
				if (reader.nextName().equals("text")) {
					captionText = reader.nextString();
				}
				if (reader.nextName().equals("duration")) {
					captionDuration = reader.nextInt();
				}
				reader.endObject();
				Caption caption = new Caption(captionText, captionDuration);
				captions.add(caption);
			}
			reader.endArray();
			reader.endObject();
			return new Video(videoId, captions);
		}
		else {
			System.out.println("Error: No video captions.");
			return null;
		}
	}

	@Override
	public void write(JsonWriter arg0, Object arg1) throws IOException {
		// WIP: I don't have a need for this so ¯\_(ツ)_/¯
		
	}

}
