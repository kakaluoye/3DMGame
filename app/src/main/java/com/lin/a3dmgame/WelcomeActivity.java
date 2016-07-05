package com.lin.a3dmgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Toast;

import com.lin.a3gmgame.Service.DownLoadService;
import com.lin.a3gmgame.utils.NetUtils;

import pl.droidsonroids.gif.GifImageView;

public class WelcomeActivity extends AppCompatActivity {

    private GifImageView gifImageView;
    private Animation animation;
    boolean netOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        gifImageView = (GifImageView) findViewById(R.id.welcome_gifiv);
        animation = new AlphaAnimation(0, 1.0f);
        animation.setDuration(3000);
        gifImageView.startAnimation(animation);
        Log.i("aaa","start");
        //animation，动画对象，只是一个动画的模式。gif图片本身开启一个这样的动画模式。下面是动画模式监听。
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                netOpen = NetUtils.netConnect(WelcomeActivity.this);
                if (netOpen) {
                    Intent intent = new Intent(WelcomeActivity.this, DownLoadService.class);
                    startService(intent);
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.i("aaa","onAnimationEnd执行了留恋");
                if (!netOpen) {
                    Toast.makeText(WelcomeActivity.this, "请连接您的网路", Toast.LENGTH_SHORT).show();
                }
                isFirstLogin();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void isFirstLogin() {
        Log.i("aaa","isFirstLogin执行了");
        SharedPreferences sharedPreferences = getSharedPreferences("isFirstLogin", Context.MODE_PRIVATE);
        boolean isLogin = sharedPreferences.getBoolean("isLogin", false);
        Log.i("aaa",isLogin+"^^^^^^^^^^");
        if (!isLogin) {
            Log.i("aaa","跳转");
            Intent intent = new Intent(WelcomeActivity.this, GuideActivity.class);
            startActivity(intent);
            finish();
        } else {
            Log.i("aaa","跳转main");
            Intent intent1 = new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(intent1);
            finish();
        }
    }
}
