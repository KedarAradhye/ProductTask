package com.android.producttask.view.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;

import com.android.producttask.R;
import com.android.producttask.view.Adapter.BoughtAdapter;
import com.android.producttask.view.Adapter.MyAdapter;
import com.android.producttask.view.Adapter.RatingAdapter;
import com.android.producttask.view.Adapter.SlidingImage_Adapter;
import com.google.android.material.tabs.TabLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private TextView mCartItemCount;
    private TextView mWhishlistItemCount;
    TabLayout tabLayout;
    ViewPager viewPager;
    private ViewPager Pager;
    private int[] urls = new int[]{
            R.drawable.shopping,
            R.drawable.shopping_images,
            R.drawable.download1,
            R.drawable.download2

    };
    private static int NUM_PAGES = 0;
    private static int currentPage = 0;
    private RecyclerView mRatingRecyclerview;
    private RecyclerView mBoughtRecyclerview;
    private RatingAdapter mRatingAdapter;
    private BoughtAdapter mBoughtAdapter;
    private TextView mProductDiscount;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        final MenuItem menuItem = menu.findItem(R.id.action_cart);
        View actionView = MenuItemCompat.getActionView(menuItem);
        mWhishlistItemCount = (TextView) actionView.findViewById(R.id.cart_badge);
        mCartItemCount = (TextView) actionView.findViewById(R.id.cart_badge);
        mCartItemCount.setText(String.valueOf(2));
//        mWhishlistItemCount.setText(String.valueOf(2));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setToolbar();
        setViews();
        setTabs();
    }

    private void setTabs() {

        tabLayout.addTab(tabLayout.newTab().setText("All"));
        tabLayout.addTab(tabLayout.newTab().setText("Whole Spices"));
        tabLayout.addTab(tabLayout.newTab().setText("Powdered Spices"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final MyAdapter adapter = new MyAdapter(this,getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void setViews() {
        mRatingAdapter = new RatingAdapter(this);
        mRatingRecyclerview.setHasFixedSize(true);
        mRatingRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRatingRecyclerview.setAdapter(mRatingAdapter);

        mBoughtAdapter = new BoughtAdapter(this);
        mBoughtRecyclerview.setHasFixedSize(true);
        mBoughtRecyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
        mBoughtRecyclerview.setAdapter(mBoughtAdapter);

        mProductDiscount.setPaintFlags(mProductDiscount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        Pager.setAdapter(new SlidingImage_Adapter(this, urls));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(Pager, true);

        NUM_PAGES = urls.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                Pager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        Pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
    }

    private void setToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_24);
    }

    private void initView() {
        mToolbar = findViewById(R.id.toolbar);
//        mDrawerLayout = findViewById(R.id.drawer_layout);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        Pager = findViewById(R.id.pager);
        mRatingRecyclerview = findViewById(R.id.rv_rating);
        mBoughtRecyclerview = findViewById(R.id.rv_bought);
        mProductDiscount = findViewById(R.id.tv_product_discount);
    }
}