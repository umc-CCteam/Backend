package backend.CC.converter;

import backend.CC.domain.Video;

import java.util.ArrayList;
import java.util.List;

public class VideoConverter {

    public static List<Video> toVideoList(List<String> video) {
        List<Video> videos = new ArrayList<>();

        for (String url : video) {
            Video videoObj = new Video(url);
            videos.add(videoObj);
        }

        return videos;
    }

}
