package geek_z.github.io.xyapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import geek_z.github.io.xyapp.R;

/**
 * Created by Administrator on 2020/1/30 0030.
 */

public class MainFragment extends Fragment {
    // 轮播图控件
    SliderLayout mDemoSlider = null;

    // 轮播图的图片地址
    HashMap<String,String> urlMaps = new HashMap<>();

    // 轮播图的点击监听器 和 页面改变监听器
    private BaseSliderView.OnSliderClickListener onSliderClickListener=new BaseSliderView.OnSliderClickListener() {
        @Override
        public void onSliderClick(BaseSliderView slider) {
            Toast.makeText(getActivity(),slider.getBundle().get("extra") + "",
                    Toast.LENGTH_SHORT).show();
        }
    };

    private ViewPagerEx.OnPageChangeListener onPageChangeListener=new ViewPagerEx.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

        @Override
        public void onPageSelected(int position) {
            //Toast.makeText(getActivity() ,"Page Changed: " + position, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPageScrollStateChanged(int state) {}
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        initSlider(view);

        return view;
    }

    /**
     * 初始化轮播图
     * @param view
     */
    private void initSlider(View view) {

        mDemoSlider = (SliderLayout)(view.findViewById(R.id.slider));

        // 初始化图片
        urlMaps.put("黄师的秋景1---小猫", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1580550137991&di=060f300d79778d155339c0db8ca5f3b8&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fphotoblog%2F1111%2F03%2Fc2%2F9490951_9490951_1320282112805.jpg");
        urlMaps.put("黄师的秋景2---小猫", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3300790747,943101569&fm=26&gp=0.jpg");
        urlMaps.put("黄师的秋景3---小猫", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1580550137991&di=060f300d79778d155339c0db8ca5f3b8&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fphotoblog%2F1111%2F03%2Fc2%2F9490951_9490951_1320282112805.jpg");
        urlMaps.put("黄师的秋景4---小猫", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3300790747,943101569&fm=26&gp=0.jpg");
        urlMaps.put("黄师的秋景5---小猫", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1580550137991&di=060f300d79778d155339c0db8ca5f3b8&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fphotoblog%2F1111%2F03%2Fc2%2F9490951_9490951_1320282112805.jpg");
        urlMaps.put("黄师的秋景6---小猫", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3300790747,943101569&fm=26&gp=0.jpg");

        for(String name : urlMaps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getActivity());
            textSliderView.description(name)                                    // 描述
                    .image(urlMaps.get(name))                            // 设置图片
                    .setScaleType(BaseSliderView.ScaleType.Fit)          // 图片缩放
                    .setOnSliderClickListener(onSliderClickListener);  // 监听

            // 设置跳转的时候携带的额外数据
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);

            //添加一个滑动页面
            mDemoSlider.addSlider(textSliderView);
        }
        // 设置滑动样式、自定义指示器、图片描述显示动画、设置滚动时间
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default );    // 滑动样式
        mDemoSlider.setCustomIndicator((PagerIndicator)(view.findViewById(R.id.custom_indicator)));
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(onPageChangeListener);
    }
}
