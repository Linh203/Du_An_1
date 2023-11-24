package com.example.du_an_1;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.du_an_1.adapter.viewpager_adapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    private FragmentManager frgMana =getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ViewPager viewPager = findViewById(R.id.viewpager);
        BottomNavigationView nav_bottom = findViewById(R.id.nav_bottom);
        viewpager_adapter adapter= new viewpager_adapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        nav_bottom.getMenu().findItem(R.id.home).setChecked(true);
                        break;
                    case 1:
                        nav_bottom.getMenu().findItem(R.id.banan).setChecked(true);
                        break;
                    case 2:
                        nav_bottom.getMenu().findItem(R.id.thongke).setChecked(true);
                        break;
                    case 3:
                        nav_bottom.getMenu().findItem(R.id.caidat).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        nav_bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    viewPager.setCurrentItem(0);
                } else if (itemId == R.id.banan) {
                    viewPager.setCurrentItem(1);
                } else if (itemId == R.id.thongke) {
                    viewPager.setCurrentItem(2);
                } else if (itemId == R.id.caidat) {
                    viewPager.setCurrentItem(3);
                }
                return true;
            }
        });
    }
}