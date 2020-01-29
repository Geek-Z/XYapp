package geek_z.github.io.xyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 设置ActionBar
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
            default:
         }
         return true;
    }
}
