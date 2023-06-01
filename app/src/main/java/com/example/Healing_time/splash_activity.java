package com.example.Healing_time;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class splash_activity extends AppCompatActivity {

    // 스플래시 화면을 표시할 시간( 밀리 초 )
    private static final int SPLASH_DELAY = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        // 일정 시간 후에 메인 액티비티로 이동
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash_activity.this, MainActivity.class);
                startActivity(intent);

                // overridePendingTransition을 통해 메인 화면이 슬라이드하면서 등장함.
                // overridePendingTransition(R.anim.horizon_enter, R.anim.none);

                finish();
            }
        }, SPLASH_DELAY);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}