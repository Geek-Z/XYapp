package geek_z.github.io.xyapp;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 获取控件
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取控件
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        // 设置ActionBar
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 给toolBar 增加一个导航按钮
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_navbar);
        }
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
             case R.id.item2:
                 Toast.makeText(MainActivity.this, "Item2", Toast.LENGTH_LONG).show();
                 break;
             case R.id.item3:
                 Toast.makeText(MainActivity.this, "Item3", Toast.LENGTH_LONG).show();
                 break;

             // 当点击了导航栏按钮的时候, 弹出滑动菜单
             case android.R.id.home:
                 mDrawerLayout.openDrawer(GravityCompat.START);
             default:
         }
         return true;
    }
}
