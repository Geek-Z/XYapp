package geek_z.github.io.xyapp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import geek_z.github.io.xyapp.utils.StatusMode;

/**
 * 自定义的Activity中间层, 执行所有的Acticity 共有的代码
 * Created by MusaGeek on 2020/2/1 0001.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 设置状态栏为浅色背景 和 黑色icon
        StatusMode.setLightMode(this);
    }
}
