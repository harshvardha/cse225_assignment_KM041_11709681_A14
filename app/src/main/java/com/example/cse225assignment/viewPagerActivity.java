package com.example.cse225assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class viewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private int[] layouts = {R.layout.first_slide,R.layout.second_slide,R.layout.third_slide,R.layout.fourth_slide};
    private myPagerAdapter myPagerAdapter;
    private LinearLayout dotsLayout;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        if(Build.VERSION.SDK_INT >= 19){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        else{
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        myPagerAdapter = new myPagerAdapter(layouts,this);
        viewPager.setAdapter(myPagerAdapter);
        dotsLayout = (LinearLayout)findViewById(R.id.dotsLayout);
        createDots(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void createDots(int currentPosition){
        if(dotsLayout!=null){
            dotsLayout.removeAllViews();
        }
        dots = new ImageView[layouts.length];
        for(int i=0;i<layouts.length;i++){
            dots[i] = new ImageView(this);
            if(i==currentPosition){
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active_dots));
            }
            else{
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.inactive_dots));
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4,0,4,0);
            dotsLayout.addView(dots[i],params);
        }
    }
}
