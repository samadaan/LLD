package structural.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class YouTubeCacheProxy implements ThirdPartyYouTubeLib{

    private ThirdPartyYouTubeLib youtubeService;

    private Map<String, Video> cachePopular = new HashMap<String, Video>();
    private Map<String, Video> cacheAll = new HashMap<String, Video>();

    public YouTubeCacheProxy(ThirdPartyYouTubeLib youtubeService){
        this.youtubeService=youtubeService;
    }
    @Override
    public Map<String, Video> popularVideos() {
        if(cachePopular.isEmpty()){
            cachePopular=youtubeService.popularVideos();
        }else{
            System.out.println("Returning from Cache");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String id) {
        Video video=cacheAll.get(id);
        if(Objects.isNull(video)){
            video=youtubeService.getVideo(id);
            cacheAll.put(id, video);
        }else{
            System.out.println("Retrieved Video From Cahce");
        }
        return video;
    }

    public void reset(){
        cacheAll.clear();
        cachePopular.clear();
    }
}
