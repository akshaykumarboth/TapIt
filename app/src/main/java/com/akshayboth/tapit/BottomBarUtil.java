package com.akshayboth.tapit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import java.lang.reflect.Field;

/**
 * Created by akshayboth on 18/03/18.
 */


public class BottomBarUtil {
    public void setupBottomBar(BottomNavigationView bottomNavigationView, final Context context, int i){
        removeShiftMode(bottomNavigationView);
        bottomNavigationView.setSelectedItemId(i);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.dashboard:
                                if(((Activity)context) instanceof DashboardActivity){
                                    System.out.println("Dont call dashboard in dashboard ... ... .... ");
                                }else {
                                    Intent i = new Intent(context, DashboardActivity.class);
                                    context.startActivity(i);
                                    ((Activity) context).overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
                                    ((Activity) context).finish();
                                }
                                break;
                            case R.id.scan:
                                if(((Activity)context) instanceof ScanActivity) {
                                    System.out.println("Dont call scan in scan ... ... .... ");

                                }else {
                                    Intent ii = new Intent(context, ScanActivity.class);
                                    context.startActivity(ii);
                                    ((Activity) context).overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
                                    ((Activity) context).finish();
                                }
                                break;
                            /*case R.id.challenge:
                                *//*if(((Activity)context) instanceof SessionActivity) {
                                    System.out.println("Dont call Job in Job ... ... .... ");

                                }else {
                                    Intent ii = new Intent(context, SessionActivity.class);
                                    context.startActivity(ii);
                                    ((Activity) context).overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
                                }*//*
                                break;
                            case R.id.job:
                                if(((Activity)context) instanceof AssessmentReport) {
                                    System.out.println("Dont call Job in Job ... ... .... ");

                                }else {
                                    Intent ii = new Intent(context, AssessmentReport.class);
                                    context.startActivity(ii);
                                    ((Activity) context).overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
                                }
                                break;*/
                            case R.id.profile:
                                if(((Activity)context) instanceof ProfileActivity) {
                                    System.out.println("Dont call profile in profile ... ... .... ");

                                }else {
                                    Intent ii = new Intent(context, ProfileActivity.class);
                                    context.startActivity(ii);
                                    ((Activity) context).overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
                                    ((Activity) context).finish();
                                }
                                break;
                        }
                        return true;
                    }
                });
    }

    static void removeShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("ERROR NO SUCH FIELD", "Unable to get shift mode field");
        } catch (IllegalAccessException e) {
            Log.e("ERROR ILLEGAL ALG", "Unable to change value of shift mode");
        }
    }


}

