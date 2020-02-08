package geek_z.github.io.xyapp.activities;

import android.support.v4.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import geek_z.github.io.xyapp.R;
import geek_z.github.io.xyapp.application.MyApplication;
import geek_z.github.io.xyapp.fragments.ActivityFragment;
import geek_z.github.io.xyapp.fragments.MainFragment;
import geek_z.github.io.xyapp.utils.DensityUtil;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    // 控件
    private ImageButton[] bottomTabs = new ImageButton[5];
    private DrawerLayout mDrawerLayout;
    private NavigationView navView;

    // 碎片
    Fragment[] fragments = new Fragment[5];

    // ImageButton的id
    private int[] imageButtonIds = new int[]{R.id.ibtn_main, R.id.ibtn_message,
            R.id.ibtn_activity, R.id.ibtn_contact, R.id.ibtn_live};

    // 默认图片
    private int[] imageDefaultIds = new int[]{R.drawable.main, R.drawable.message,
            R.drawable.activity, R.drawable.contact, R.drawable.live};

    // 点击后展现的图片
    private int[] imageFocus = new int[]{R.drawable.main_focus, R.drawable.message_focus,
            R.drawable.activity_focus, R.drawable.contact_focus, R.drawable.live_focus};

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取控件
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navView = (NavigationView)findViewById(R.id.nav_view);

        // 设置ActionBar
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 给toolBar 增加一个导航按钮
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_navbar);
        }

        // 设置NavigationView 当中菜单项的点击事件
        navView.setCheckedItem(R.id.drawer_item1);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(MainActivity.this, "" + item.getItemId(), Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        // 初始化控件
        for(int i = 0; i < 5; ++i)
            bottomTabs[i] = (ImageButton)findViewById(imageButtonIds[i]);

        // 设置监听事件
        for(int i = 0; i < 5; ++i)
            bottomTabs[i].setOnClickListener(this);

        // 显示以一个Fragment 以及 第一个ImageButton 被选中的状态
        setStated(0);
        switchFragment(0);
    }


    // 创建toolbar 上面的菜单项
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         switch (item.getItemId()){
             case R.id.item1:
                 Toast.makeText(MainActivity.this, "Item1", Toast.LENGTH_LONG).show();
                 break;

             // 当点击了导航栏按钮的时候, 弹出滑动菜单
             case android.R.id.home:
                 mDrawerLayout.openDrawer(GravityCompat.START);
                 int ret = DensityUtil.dip2px(MainActivity.this, 26);
                 Toast.makeText(MainActivity.this, "" + ret, Toast.LENGTH_LONG).show();
             default:
         }
         return true;
    }

    /**
     * 给切换栏上面的按钮添加监听事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ibtn_main:
                Toast.makeText(MyApplication.getContext(), "Main Fragment", Toast.LENGTH_LONG).show();
                setStated(0);
                switchFragment(0);
                break;
            case R.id.ibtn_message:
                Toast.makeText(MyApplication.getContext(), "Message Fragment", Toast.LENGTH_LONG).show();
                setStated(1);
                switchFragment(1);
                break;
            case R.id.ibtn_activity:
                Toast.makeText(MyApplication.getContext(), "Activity Fragment", Toast.LENGTH_LONG).show();
                setStated(2);
                switchFragment(2);
                break;
            case R.id.ibtn_contact:
                Toast.makeText(MyApplication.getContext(), "Contact Fragment", Toast.LENGTH_LONG).show();
                setStated(3);
                switchFragment(3);
                break;
            case R.id.ibtn_live:
                Toast.makeText(MyApplication.getContext(), "Live Fragment", Toast.LENGTH_LONG).show();
                setStated(4);
                switchFragment(4);
                break;
            default:
        }
    }

    // 图片样式改变
    private void setStated(int index) {
        for(int i = 0; i < 5; ++i)
            bottomTabs[i].setImageResource(imageDefaultIds[i]);
        bottomTabs[index].setImageResource(imageFocus[index]);
    }

    // 切换Fragment
    private void switchFragment(int index) {
        Fragment target = null;
        switch (index) {
            case 0 :
                if(fragments[index] == null)
                    fragments[index] = new MainFragment();
                target = fragments[index];
            case 1 :
                if(fragments[index] == null)
                    fragments[index] = new ActivityFragment();
                target = fragments[index];
            case 2 :
                if(fragments[index] == null)
                    fragments[index] = new ActivityFragment();
                target = fragments[index];
            case 3 :
                if(fragments[index] == null)
                    fragments[index] = new ActivityFragment();
                target = fragments[index];
            case 4 :
                if(fragments[index] == null)
                    fragments[index] = new ActivityFragment();
                target = fragments[index];
            default:
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_fragment, target);
        transaction.commit();
    }

}
