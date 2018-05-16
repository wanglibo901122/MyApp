package com.bawei.mynewdayview;

import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoView;

public class MainActivity extends AppCompatActivity {
    private HackyViewPager hvpPhoto;
    private List<String> images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hvpPhoto= (HackyViewPager) findViewById(R.id.hvp_photo);
        images=new ArrayList<>();
        images.add("http://pic.jj20.com/up/allimg/1011/05241G14F4/1F524114F4-6.jpg");
        images.add("http://attach.bbs.miui.com/forum/201308/19/120939b33n3ufz02tlttci.jpg");
        images.add("http://pic.jj20.com/up/allimg/1011/05241G14F4/1F524114F4-4.jpg");
        images.add("http://www.pp3.cn/uploads/201505/2015052111.jpg");

        hvpPhoto.setAdapter(new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                PhotoView photoView=new PhotoView(container.getContext());
                Picasso.with(container.getContext()).load(images.get(position)).into(photoView);
                container.addView(photoView);
                return photoView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);

            }

            @Override
            public int getCount() {
                return images.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
        });
    }
}


