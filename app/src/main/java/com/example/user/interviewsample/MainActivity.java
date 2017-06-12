package com.example.user.interviewsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * 測試 Button 點擊事件 4 種寫法
 * 備註 : Button 的 setOnClickListener 優先等級比 xml 中 android:onClick 高，如果同時設置點擊事件，只有 setOnClickListener 有效。
 *  Tool Sample 使用到 menu 檔案夾
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView(); // 初始化 Toolbar

        //initView1(); // 第 1 種方式，xml檔中加入 onClick 屬性
        // initView2(); // 第 2 種方式，使用內部類
        // initView3(); // 第 3 種方式，使用匿名內部類

        /*第 4 種方式，Activity 繼承 View.OnClickListener，由 Activity 實現 OnClick(View view)方法，
                在 OnClick(View view) 方法中用 switch-case 對不同 id 代表的 button 進行相對應處理 */
        initView4();
    }

    /**
     *  初始化 Toolbar
     */
    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        // 以下程式碼結果與 onCreateOptionsMenu 結果相同
        mToolbar.inflateMenu(R.menu.toolbar_menu);

        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // action menu 操作選單按鈕監聽動作
                switch (item.getItemId()) {
                    case R.id.share:
                        Toast.makeText(MainActivity.this, getString(R.string.SHARE), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.version:
                        Toast.makeText(MainActivity.this, getString(R.string.VERSION), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.setting:
                        Toast.makeText(MainActivity.this, getString(R.string.SETTING), Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        // 导航按钮的点击事件
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
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
                Toast.makeText(MainActivity.this,"點擊 Button !", Toast.LENGTH_SHORT).show();
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
            case R.id.button: //  確認
                startSecondActivity();
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
                    Toast.makeText(MainActivity.this,"點擊 Button !", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 開啟分頁
     * Activity 切換動畫
     */
    public void startSecondActivity() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
        // overridePendingTransition(R.anim.up_in, R.anim.up_out);
    }

}
