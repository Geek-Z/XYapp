package geek_z.github.io.xyapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import geek_z.github.io.xyapp.R;
import geek_z.github.io.xyapp.adapter_entities.OfficalActivity;
import geek_z.github.io.xyapp.adapters.OfficalActivityAdapter;

/**
 * Created by MusaGeek on 2020/1/30 0030.
 */

public class ActivityFragment extends Fragment {

    // RecyclerView的数据
    private List<OfficalActivity> activities = new ArrayList<>();

    // 轮播图控件
    private SliderLayout mDemoSlider = null;

    // 轮播图的图片地址
    private HashMap<String,String> urlMaps = new HashMap<>();

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
        View view = inflater.inflate(R.layout.activity_fragment, container, false);
        initSlider(view);
        initOfficalActivity(view);
        return view;
    }

    /**
     * 初始化轮播图
     * @param view
     */
    private void initSlider(View view) {

        mDemoSlider = (SliderLayout)(view.findViewById(R.id.slider));

        // 初始化图片
        urlMaps.put("盛大开业, 进店有礼", "http://img1.imgtn.bdimg.com/it/u=2981689625,3530753832&fm=26&gp=0.jpg");
        urlMaps.put("双11疯狂继续, 全场满就减", "http://img0.imgtn.bdimg.com/it/u=2825599023,2633011549&fm=26&gp=0.jpg");
        urlMaps.put("幸运大抽奖, 保证每抽必中", "http://img3.imgtn.bdimg.com/it/u=3028809815,1144697470&fm=26&gp=0.jpg");
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

    private void initOfficalActivity(View view) {

        activities.add(new OfficalActivity(R.drawable.offical_activity_image1, "瑞天广场 春哥麻辣烫开业, 今日半价", ""));
        activities.add(new OfficalActivity(R.drawable.offical_activity_image2, "黄商期末大促销，只要是吃的 ，一律....！", ""));
        activities.add(new OfficalActivity(R.drawable.offical_activity_image3, "敬请期待学海超时开学季大礼包。", ""));

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.activity_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        OfficalActivityAdapter adapter = new OfficalActivityAdapter(activities);
        recyclerView.setAdapter(adapter);
    }
}
