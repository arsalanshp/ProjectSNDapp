package com.example.root.tebsoundapp1;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.root.tebsoundapp1.Adaptors.BaseSoundAdapter;
import com.example.root.tebsoundapp1.Model.Sound;

import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener ,SearchView.OnQueryTextListener {

    private RecyclerView recyclerView;
    private BaseSoundAdapter baseAdapter;
    private ArrayList<Sound> soundsList = new ArrayList<>();
    public LinearLayoutManager baseLayoutManager;
    boolean loading;
    public int visibleItemCount,pastVisiblesItems,pageIndex,totalItemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        Toolbar baseToolbar = (Toolbar)findViewById(R.id.base_toolbar);
        setSupportActionBar(baseToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        getSupportActionBar().setIcon(R.drawable.music);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        baseToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent homeIntent = new Intent(getApplicationContext() ,MainActivity.class);
                startActivity(homeIntent);
            }
        });

    }

    private void init_soundView() {

        recyclerView = (RecyclerView) findViewById(R.id.base_activity_recycler_view);
        baseAdapter = new BaseSoundAdapter(soundsList);
        baseLayoutManager = new LinearLayoutManager(this); //getApplicationContext()
        baseLayoutManager =new LinearLayoutManager(getApplicationContext());


        recyclerView.setLayoutManager(baseLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(baseAdapter);
        recyclerView.setHasFixedSize(true);
        //paging part
        getSounds(pageIndex);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                visibleItemCount = baseLayoutManager.getChildCount();
                totalItemCount = baseLayoutManager.getItemCount();
                pastVisiblesItems = baseLayoutManager.findFirstVisibleItemPosition();
                if (!loading) {
                    if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                        pageIndex++;
                        /*progressBar.setVisibility(View.VISIBLE);*/
                        getSounds(pageIndex);
                    }
                }
            }
        });
    }


    private void getSounds(int pageIndex) {
//        if (Utils.isOnline(this)) {
//            Globals.ion.with(this).load(WebserviceUrl.GET_COMMENT)
//                    .setHeader("token_id", Globals.userToken)
//                    .setBodyParameter("ID", String.valueOf(bookId))
//                    .setBodyParameter("PageSize", "10")
//                    .setBodyParameter("PageIndex",String.valueOf(pageIndex))
//                    .as(CommentsList.class)
//                    .setCallback(new FutureCallback<CommentsList>() {
//                        @Override
//                        public void onCompleted(Exception e, CommentsList result) {
//                            if (e == null) {
//                                Log.i("etgg", result + "");
//                                commentList = result.getComments();
//                                commentsAdapter.commentsList.addAll(result.getComments());
//                                commentsAdapter.notifyDataSetChanged();
////                                prepareMovieData();
//                            }
//                        }
//                    });
//        } else {
//            Toast.makeText(this, getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show();
//        }
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

    @Override
    public void onClick(View v) {


    }
}
