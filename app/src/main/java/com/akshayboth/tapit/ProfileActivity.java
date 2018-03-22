package com.akshayboth.tapit;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.akshayboth.tapit.pojo.ProfileFeatureItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        new BottomBarUtil().setupBottomBar(bottomNavigationView, ProfileActivity.this, R.id.profile);
        setQrBtn();
        initRecyclerViews();

        ScrollView sv = (ScrollView) findViewById(R.id.scrollView);
        sv.smoothScrollTo(0, 0);
    }

    private void setQrBtn() {
        final Button toggleQR = (Button) findViewById(R.id.btn_show_qr);
        //final ImageButton qrCode = (ImageButton) findViewById(R.id.qr_code);
        final LinearLayout qrContainer = (LinearLayout) findViewById(R.id.ll_qr_con);
        toggleQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qrContainer.getVisibility() == View.GONE) {
                    // Its invisible
                    toggleQR.setText("Hide QR Code");
                    toggleQR.setCompoundDrawablesWithIntrinsicBounds( R.mipmap.ic_arrow_drop_down_white_36dp, 0, 0, 0);
                    qrContainer.setVisibility(View.VISIBLE);
                } else {
                    // Its visible
                    toggleQR.setText("Show QR Code");
                    toggleQR.setCompoundDrawablesWithIntrinsicBounds( R.mipmap.ic_arrow_drop_up_white_36dp, 0, 0, 0);
                    qrContainer.setVisibility(View.GONE);
                }
            }
        });
    }

    private void initRecyclerViews(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.grid);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        List<ProfileFeatureItem> items = prepareData();
        ProfileGridAdapter adapter = new ProfileGridAdapter(ProfileActivity.this,items);
        recyclerView.setAdapter(adapter);

    }

    private List<ProfileFeatureItem> prepareData(){

        List<ProfileFeatureItem> items = new ArrayList<>();
        items.add(new ProfileFeatureItem("Edit Profile",R.mipmap.ic_border_color_white_36dp));
        items.add(new ProfileFeatureItem("Bank Accounts",R.mipmap.ic_border_color_white_36dp));
        items.add(new ProfileFeatureItem("Invite & earn",R.mipmap.ic_border_color_white_36dp));
        items.add(new ProfileFeatureItem("Change Language",R.mipmap.ic_border_color_white_36dp));
        items.add(new ProfileFeatureItem("Security",R.mipmap.ic_security_white_36dp));
        items.add(new ProfileFeatureItem("Help",R.mipmap.ic_live_help_white_36dp));
        items.add(new ProfileFeatureItem("Policies",R.mipmap.ic_assignment_late_white_36dp));
        items.add(new ProfileFeatureItem("LOGOUT",R.mipmap.ic_power_settings_new_white_36dp));

        return items;
    }

}
