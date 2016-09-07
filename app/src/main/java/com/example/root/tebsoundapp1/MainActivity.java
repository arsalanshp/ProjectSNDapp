package com.example.root.tebsoundapp1;

import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.root.tebsoundapp1.Adaptors.SubCategoryAdapter;
import com.example.root.tebsoundapp1.Adaptors.TabAdapter;
import com.example.root.tebsoundapp1.Fragments.HomeFragment;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Spinner subCategorySpinner;
    private ViewPager viewPager;
    private Toolbar baseToolbar;
    private TabLayout tabLayout;
    private int priviousTab =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseToolbar = (Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(baseToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setIcon(R.drawable.music);

        initTabViewPager();


//        initSubCategory(String[] categories , int[] categories_id)

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.base_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.search_menu_item);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        // User pressed the search button
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        // User changed the text
        return false;
    }

    public void initSubCategory(String[] categories , int[] categories_id){

        subCategorySpinner = (Spinner)findViewById(R.id.spinner);
        SubCategoryAdapter adapter = new SubCategoryAdapter(this,categories,categories_id);
        subCategorySpinner.setAdapter(adapter);
        subCategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), categories[position],Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


    public void initTabViewPager(){
        viewPager = (ViewPager) findViewById(R.id.main_tab_viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        setupTabIcons();
    }

    private void setupViewPager(ViewPager viewPager) {
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment(), "ONE");
        viewPager.setAdapter(adapter);
        adapter.addFrag(new HomeFragment(), "TWO");
        viewPager.setAdapter(adapter);
        adapter.addFrag(new HomeFragment(), "THERe");
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        final int[] tabIcons = {
                R.mipmap.ic_home_black_24dp,
                R.mipmap.ic_favorite_black_24dp,
                R.mipmap.ic_face_black_24dp
        };
        if (tabLayout.getTabCount() >0) {
            tabLayout.getTabAt(0).setIcon(tabIcons[2]);

//        System.out.println(this.categorySize);
            for (int i = 1; i < 3; i++) {
                tabLayout.getTabAt(i).setIcon(tabIcons[i % 2]);
                tabLayout.getTabAt(i).getIcon().setAlpha(128);
            }
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
                @Override
                public void onPageSelected(int position) {

                    tabLayout.getTabAt(priviousTab).getIcon().setAlpha(128);
                    tabLayout.getTabAt(position).getIcon().setAlpha(255);
                    priviousTab = position;

                }
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }
                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }

    }

}
