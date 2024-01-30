package backend.CC.converter;

import backend.CC.domain.Video;

import java.util.ArrayList;
import java.util.List;

public class VideoConverter {

    public static List<Video> toVideoList(List<String> video) {
        List<Video> videoList = new ArrayList<>();

        for (String url : video) {
            Video videoObj = new Video(url);
            videoList.add(videoObj);
        }

        return videoList;
    }

}
