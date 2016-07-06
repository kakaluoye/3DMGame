package com.lin.a3gmgame.fragment;

import android.annotation.SuppressLint;
//import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
        this.typeid = typeid;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_chapterfragment, null);
        //再获取Fragment中的ViewPager 。注意：ViewPager，和ListView，一样，都是需要填充的，ViewPager横着有内容，ListView竖着有内容。
        MainChapterFragmentViewpager viewpager = (MainChapterFragmentViewpager) view.findViewById(R.id.main_chapterfragment_vp);
        //想填充ViewPager，需要数据、适配器。注意：：这是里面的图片滑动的ViewPager。和外面的大的ViewPager分开。
        //数据就三张图片

        int[] imageRsid = {R.drawable.main_center_default1, R.drawable.main_center_default2, R.drawable.main_center_default3};

        List<ImageView> imageViews = new ArrayList<>();
        //for循环就是为了把数据，也就是3图片放到集合里，在放到适配器中。
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(getActivity());
            //new了一个图片对象，图片对象
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(imageRsid[i]);//这里的图片对象只是个框架，需要设置具体的图片资源，里面是ID,所=所以需要上面的int数组放3图片ID。
            imageViews.add(imageView);
        }
        //数据有了  放适配器
        pagerAdapter = new MainchapterFragmentViewPagerAdapter(imageViews);
        viewpager.setAdapter(pagerAdapter);


        //……………………………………这里对ViewPager就配置好了。
        //下面是布局里的 textview。

        TextView tv = (TextView) view.findViewById(R.id.main_chapterfragment_tv);

        tv.setText(typeid + "");
        return view;//记得，碎片的oncreatview，连接了整个碎片布局，返回的是它。
    }
}
