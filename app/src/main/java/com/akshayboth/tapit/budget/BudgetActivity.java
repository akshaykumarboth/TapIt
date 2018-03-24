package com.akshayboth.tapit.budget;

import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.akshayboth.tapit.R;
import com.akshayboth.tapit.pojo.BudgetItem;

import java.util.ArrayList;
import java.util.List;

public class BudgetActivity extends AppCompatActivity {
    private BudgetListAdapter adapter;
    RecyclerView recyclerView;

    AppBarLayout appbar;
    RelativeLayout headerContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);


        appbar = (AppBarLayout) findViewById(R.id.appbar);

        headerContainer = (RelativeLayout) findViewById(R.id.rl_header_con);
        recyclerView = (RecyclerView) findViewById(R.id.rv_budgetlist);

        initRecyclerViews();
        setappBar();
    }

    private void setappBar() {
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                headerContainer.setAlpha(1.0f - Math.abs(verticalOffset / (float) appBarLayout.getTotalScrollRange()));//for scroll fade

                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    //collapsingToolbarLayout.setTitle("Title");
                    isShow = true;
                } else if (isShow) {
                    //collapsingToolbarLayout.setTitle("titles ");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });
    }

    private void initRecyclerViews(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        List<BudgetItem> items = prepareData();
        adapter = new BudgetListAdapter(BudgetActivity.this,items);
        recyclerView.setAdapter(adapter);
    }



    private List<BudgetItem> prepareData(){
        List<BudgetItem> items = new ArrayList<>();
        // BudgetItem(String budgetName, String budgetType, int budgetAmount, int spentAmount, int resId)
        items.add(new BudgetItem("Cab Budget", "MONTHLY",5000, 2000,R.mipmap.ic_assignment_late_white_36dp));
        items.add(new BudgetItem("Drinks Budget", "MONTHLY",8000, 4000,R.mipmap.ic_event_note_white_36dp));
        items.add(new BudgetItem("Savings", "MONTHLY",6000, 4000,R.mipmap.ic_save_white_36dp));
        items.add(new BudgetItem("Food Budget", "MONTHLY",4500, 4500,R.mipmap.ic_live_help_white_36dp));
        items.add(new BudgetItem("Cab Budget", "MONTHLY",34000, 1000,R.mipmap.ic_swap_vertical_circle_white_36dp));

        return items;
    }

}
