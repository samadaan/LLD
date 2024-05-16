package structural.proxy;

import java.util.Map;

public interface ThirdPartyYouTubeLib {
    Map<String, Video> popularVideos();
    Video getVideo(String id);
}

