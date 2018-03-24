package com.akshayboth.tapit.dashboard;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.akshayboth.tapit.BottomBarUtil;
import com.akshayboth.tapit.R;
import com.akshayboth.tapit.ScanActivity;
import com.akshayboth.tapit.pojo.DashboardItem;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    DashboardGridAdapter adapter;


    int NOTIFICATION_ID = 234;
    private SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        sharedpreferences = getSharedPreferences(getResources().getString(R.string.shared_preference_key), Context.MODE_PRIVATE);
        if (sharedpreferences.getBoolean("firstTime", true)) {
            setupFirstNotification();

            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean("firstTime", false);
            editor.apply();
            editor.commit();
        }

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

    private void setupFirstNotification() {
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        String CHANNEL_ID = "my_channel_01";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            CharSequence name = "my_channel";
            String Description = "This is my channel";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            mChannel.setDescription(Description);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            mChannel.setShowBadge(false);
            notificationManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Welcome aboard")
                .setContentText("Your payment journey will be simplified with your life");

        Intent resultIntent = new Intent(getApplicationContext(), ScanActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
        stackBuilder.addParentStack(ScanActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(resultPendingIntent);

        notificationManager.notify(NOTIFICATION_ID, builder.build());
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
