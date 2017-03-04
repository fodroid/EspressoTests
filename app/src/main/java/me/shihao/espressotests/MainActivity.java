package me.shihao.espressotests;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edt1;
    private EditText edt2;
    private Button btn;
    private TextView tv;
    private Button btnWebView, btnRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText) findViewById(R.id.editText);
        edt2 = (EditText) findViewById(R.id.editText2);
        btn = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = edt1.getText().toString().trim();
                if (TextUtils.isEmpty(str)) {
                    Toast.makeText(MainActivity.this, "请输入数字1", Toast.LENGTH_SHORT).show();
                    return;
                }
                String str2 = edt2.getText().toString().trim();
                if (TextUtils.isEmpty(str2)) {
                    Toast.makeText(MainActivity.this, "请输入数字2", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    int num1 = Integer.parseInt(str);
                    int num2 = Integer.parseInt(str2);
                    tv.setText("计算结果：" + (num1 + num2));
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
        btnWebView = (Button) findViewById(R.id.button3);
        btnWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra(WebViewActivity.EXTRA_URL, "http://m.baidu.com");
                startActivity(intent);
            }
        });
        btnRecycleView = (Button) findViewById(R.id.button4);
        btnRecycleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecycleviewActivity.class);
                startActivity(intent);
            }
        });
    }

}
