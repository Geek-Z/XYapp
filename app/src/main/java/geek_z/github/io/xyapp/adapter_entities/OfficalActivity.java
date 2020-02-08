package geek_z.github.io.xyapp.adapter_entities;

/**
 * Created by MusaGeek on 2020/2/7 0007.
 * 适配给官方活动的RevyclerView的数据实体
 */

public class OfficalActivity {
    private int imageId;
    private String title;
    private String url;             // 此活动的具体URL的json数据的地址
    public OfficalActivity(int imageId, String title, String url) {
        this.imageId = imageId;
        this.title = title;
        this.url = url;
    }

    public int getImageId() { return imageId; }

    public String getTitle() {  return title; }

    public String getUrl() { return url; }
}
