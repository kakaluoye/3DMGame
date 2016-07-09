package com.lin.a3dmgame;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lin.a3gmgame.fragment.ChapterFragment;
import com.lin.a3gmgame.fragment.ForumFragment;
import com.lin.a3gmgame.fragment.GameFragment;

/**
 * ……………………study
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private FrameLayout frameLayout;
    private RadioGroup radioGroup;
    private RadioButton rb_chapter, rb_forum, rb_game;

    private Fragment fragment_chapter, fragment_forum, fragment_game;
    private FragmentTransaction transaction;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("aaa", "main来了");
        initView();
        initListener();
        //这里先把默认的文字碎片放在onCreate方法里，让它一启动就加载显示。
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_Activity_framelayout, fragment_chapter);
        transaction.commit();
    }

    private void initView() {
        frameLayout = (FrameLayout) findViewById(R.id.main_Activity_framelayout);
        radioGroup = (RadioGroup) findViewById(R.id.main_bottom_rg);
        rb_chapter = (RadioButton) findViewById(R.id.main_Activity_rb_chapter);
        rb_forum = (RadioButton) findViewById(R.id.main_Activity_rb_forum);
        rb_game = (RadioButton) findViewById(R.id.main_Activity_rb_game);
        //初始化View  有ID的找ID,是碎片的，new碎片。
        fragment_chapter = new ChapterFragment();
        fragment_forum = new ForumFragment();
        fragment_game = new GameFragment();//这里有的时候获取不到，是因为gamefragment自动导包没导v4包。
    }

    private void initListener() {
        rb_chapter.setOnClickListener(this);
        rb_forum.setOnClickListener(this);
        rb_game.setOnClickListener(this);
    }

    private void initData() {
        //这里不需要初始化数据，在各自的碎片中初始化数据。
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_Activity_rb_chapter:
                //交易对象交易前，每次由需要碎片管理者来启动交易。
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_Activity_framelayout, fragment_chapter);
                transaction.commit();
                break;
            case R.id.main_Activity_rb_forum:
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_Activity_framelayout, fragment_forum);
                transaction.commit();
                break;
            case R.id.main_Activity_rb_game:
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_Activity_framelayout, fragment_game);
                transaction.commit();
                break;
        }
    }
}
