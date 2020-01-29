package geek_z.github.io.xyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    // 控件
    private EditText usernameEdit;
    private EditText passwordEdit;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);

        // 获取控件
        usernameEdit = (EditText)findViewById(R.id.edi_username);
        passwordEdit = (EditText)findViewById(R.id.edi_password);
        loginBtn = (Button)findViewById(R.id.btn_login);

        // 设置监听事件的
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String username = usernameEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if("admin".equals(username) && "123".equals(password)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {

                    // 即使密码不正确也跳转, 为了测试使用
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
