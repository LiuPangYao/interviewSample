package com.example.user.interviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 測試 Button 點擊事件 4 種寫法
 * 備註 : Button 的 setOnClickListener 優先等級比 xml 中 android:onClick 高，如果同時設置點擊事件，只有 setOnClickListener 有效。
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initView1(); // 第 1 種方式，xml檔中加入 onClick 屬性
        // initView2(); // 第 2 種方式，使用內部類
        // initView3(); // 第 3 種方式，使用匿名內部類

        /*第 4 種方式，Activity 繼承 View.OnClickListener，由 Activity 實現 OnClick(View view)方法，
        在 OnClick(View view) 方法中用 switch-case 對不同 id 代表的 button 進行相對應處理 */
        initView4();
    }

    /**
     * 初始化 View
     */
    public void initView1() {
        mButton = (Button) findViewById(R.id.button);
    }

    /**
     * 初始化 View
     */
    public void initView2() {
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new MyClickListener());
    }

    /**
     * 初始化 View
     */
    public void initView3() {
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"點擊 Button !!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 初始化 View
     */
    public void initView4() {
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }

    /**
     *
     * @param view
     */
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button:
                Toast.makeText(MainActivity.this,"點擊 Button !!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.button:
                    Toast.makeText(MainActivity.this,"點擊 Button !!", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }

}
