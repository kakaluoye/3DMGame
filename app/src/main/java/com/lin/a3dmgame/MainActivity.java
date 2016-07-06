package com.lin.a3dmgame;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.lin.a3gmgame.adapter.MainFragmentViewPagerAdapter;
import com.lin.a3gmgame.fragment.ChapterFragment;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener,RadioGroup.OnCheckedChangeListener{

    private HorizontalScrollView hsv;
    private RadioGroup radioGroup_top;
    private RadioButton rb01_top, rb02_top, rb03_top, rb04_top, rb05_top, rb06_top, rb07_top, rb08_top, rb09_top, rb10_top;
    private ViewPager viewPager_center;
    private RadioGroup radioGroup_bottom;
    private RadioButton rb1_bottom, rb2_bottom, rb3_bottom;

    private List<Fragment> fragments;
    private MainFragmentViewPagerAdapter fragmentviewadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("aaa", "main来了");
        initView();
        initData();
        initLIstener();
    }

    private void initLIstener() {
        radioGroup_bottom.setOnCheckedChangeListener(this);
        radioGroup_top.setOnCheckedChangeListener(this);
        //对ViewPager添加监听，现在用add。
//        viewPager_center.setOnPageChangeListener(this);
        viewPager_center.addOnPageChangeListener(this);
    }

    private void initData() {
        fragments =  new ArrayList<Fragment>();
        ChapterFragment f1 = new ChapterFragment(1);
        ChapterFragment f2 = new ChapterFragment(2);
        ChapterFragment f3 = new ChapterFragment(3);
        ChapterFragment f4 = new ChapterFragment(4);
        ChapterFragment f5 = new ChapterFragment(5);
        ChapterFragment f6 = new ChapterFragment(6);
        ChapterFragment f7 = new ChapterFragment(7);
        ChapterFragment f8 = new ChapterFragment(8);
        ChapterFragment f9 = new ChapterFragment(9);
        ChapterFragment f10 = new ChapterFragment(10);
        fragments.add(f1);
        fragments.add(f2);
        fragments.add(f3);
        fragments.add(f4);
        fragments.add(f5);
        fragments.add(f6);
        fragments.add(f7);
        fragments.add(f8);
        fragments.add(f9);
        fragments.add(f10);
        //中间的这个大ViewPager对应着上面的10个RodiaButton，所以需要有10个这样的碎片。
        fragmentviewadapter = new MainFragmentViewPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager_center.setAdapter(fragmentviewadapter);
    }

    private void initView() {
        hsv = (HorizontalScrollView) findViewById(R.id.main_top_hsv);
        radioGroup_top = (RadioGroup) findViewById(R.id.main_top_rg);
        rb01_top = (RadioButton) findViewById(R.id.main_top_rb1);
        rb02_top = (RadioButton) findViewById(R.id.main_top_rb2);
        rb03_top = (RadioButton) findViewById(R.id.main_top_rb3);
        rb04_top = (RadioButton) findViewById(R.id.main_top_rb4);
        rb05_top = (RadioButton) findViewById(R.id.main_top_rb5);
        rb06_top = (RadioButton) findViewById(R.id.main_top_rb6);
        rb07_top = (RadioButton) findViewById(R.id.main_top_rb7);
        rb08_top = (RadioButton) findViewById(R.id.main_top_rb8);
        rb09_top = (RadioButton) findViewById(R.id.main_top_rb9);
        rb10_top = (RadioButton) findViewById(R.id.main_top_rb10);
        viewPager_center = (ViewPager) findViewById(R.id.main_center_vp);
        radioGroup_bottom = (RadioGroup) findViewById(R.id.main_bottom_rg);
        rb1_bottom = (RadioButton) findViewById(R.id.main_bottom_rb1);
        rb2_bottom = (RadioButton) findViewById(R.id.main_bottom_rb2);
        rb3_bottom = (RadioButton) findViewById(R.id.mian_bottom_rb3);
        //初始化控件的时候，注意，要给界面各个选项的默认值，都是第一个。
        rb01_top.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.main_top_rb1:
                viewPager_center.setCurrentItem(0);
                Toast.makeText(MainActivity.this,"top rb01",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb2:
                viewPager_center.setCurrentItem(1);
                Toast.makeText(MainActivity.this,"top rb02",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb3:
                viewPager_center.setCurrentItem(2);
                Toast.makeText(MainActivity.this,"top rb03",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb4:
                viewPager_center.setCurrentItem(3);
                Toast.makeText(MainActivity.this,"top rb04",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb5:
                viewPager_center.setCurrentItem(4);
                Toast.makeText(MainActivity.this,"top rb05",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb6:
                viewPager_center.setCurrentItem(5);
                Toast.makeText(MainActivity.this,"top rb06",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb7:
                viewPager_center.setCurrentItem(6);
                Toast.makeText(MainActivity.this,"top rb07",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb8:
                viewPager_center.setCurrentItem(7);
                Toast.makeText(MainActivity.this,"top rb08",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb9:
                viewPager_center.setCurrentItem(8);
                Toast.makeText(MainActivity.this,"top rb09",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb10:
                viewPager_center.setCurrentItem(9);
                Toast.makeText(MainActivity.this,"top rb010",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_bottom_rb1:
                viewPager_center.setCurrentItem(2);
                Toast.makeText(MainActivity.this,"bottom rb01",Toast.LENGTH_SHORT).show();
                hsv.smoothScrollTo(0,0);//这个？？？？知道移动到前面第一位
                break;
            case R.id.main_bottom_rb2:
                break;
            case R.id.mian_bottom_rb3:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        hsv.setVisibility(View.VISIBLE);
        radioGroup_top.setVisibility(View.VISIBLE);//取消试试。
        //上面设置可见，下面得到你点击的上门的那个按钮，设置点击为真。
        RadioButton radiobutton = (RadioButton) radioGroup_top.getChildAt(position);
        radiobutton.setChecked(true);
        //根据中间viewpager与左面的距离，让上面的HorizontalScrollView，也移动相同的距离，就行了。
        int left = viewPager_center.getLeft();
        Log.i("aaa","left=="+left);
        hsv.smoothScrollTo(left,0);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
