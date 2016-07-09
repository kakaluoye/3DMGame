package com.lin.a3gmgame.fragment;

import android.annotation.SuppressLint;
//import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lin.a3dmgame.R;
import com.lin.a3gmgame.adapter.MainchapterFragmentViewPagerAdapter;
import com.lin.a3gmgame.view.MainChapterFragmentViewpager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/7/6.
 */
public class ChapterFragment extends Fragment {

    private int typeid;
    private MainchapterFragmentViewPagerAdapter pagerAdapter;

    public ChapterFragment() {
    }

    @SuppressLint("ValidFragment")
    public ChapterFragment(int typeid) {
        Log.i("aaa", "构造方法传来typeid===" + typeid);
        this.typeid = typeid;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_chapterfragment, null);
        //在文章碎片里，把数据得到，显示出来。谁替换加载这碎片，就会初始化这碎片，这碎片就会显示布局和内容。





        return view;
    }
}
