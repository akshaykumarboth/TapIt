package com.akshayboth.tapit;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.akshayboth.tapit.pojo.DashboardItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    DashboardGridAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initRecyclerViews();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        new BottomBarUtil().setupBottomBar(bottomNavigationView, DashboardActivity.this, R.id.dashboard);
    }


    private void initRecyclerViews(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.grid);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        List<DashboardItem> items = prepareData();
        adapter = new DashboardGridAdapter(DashboardActivity.this,items);
        recyclerView.setAdapter(adapter);

    }


    private List<DashboardItem> prepareData(){
        List<DashboardItem> items = new ArrayList<>();
        items.add(new DashboardItem("Pay Money",R.mipmap.ic_send_white_36dp));
        items.add(new DashboardItem("Recieve Money",R.mipmap.ic_call_received_white_36dp));
        items.add(new DashboardItem("Budget",R.mipmap.ic_save_white_36dp));
        items.add(new DashboardItem("Schedule",R.mipmap.ic_event_note_white_36dp));
        items.add(new DashboardItem("Transactions",R.mipmap.ic_swap_vertical_circle_white_36dp));
        items.add(new DashboardItem("Bank Acounts",R.mipmap.ic_account_balance_white_36dp));
        items.add(new DashboardItem("Legal",R.mipmap.ic_assignment_late_white_36dp));
        items.add(new DashboardItem("Help",R.mipmap.ic_live_help_white_36dp));

        return items;
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter.notifyDataSetChanged();
    }
}
