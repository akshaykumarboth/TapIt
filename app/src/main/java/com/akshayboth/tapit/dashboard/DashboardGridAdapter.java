package com.akshayboth.tapit.dashboard;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.akshayboth.tapit.BankAccountsActivity;
import com.akshayboth.tapit.EnterPayActivity;
import com.akshayboth.tapit.R;
import com.akshayboth.tapit.ScheduleActivity;
import com.akshayboth.tapit.budget.BudgetActivity;
import com.akshayboth.tapit.pojo.DashboardItem;
import com.akshayboth.tapit.transaction.TransactionsActivity;

import java.util.List;

/**
 * Created by akshayboth on 18/03/18.
 */

public class DashboardGridAdapter extends RecyclerView.Adapter<DashboardGridAdapter.ViewHolder> {
    private List<DashboardItem> android;
    private Context context;

    public DashboardGridAdapter(Context context, List<DashboardItem> android) {
        this.android = android;
        this.context = context;
    }

    @Override
    public DashboardGridAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dashboard_grid_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DashboardGridAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_android.setText(android.get(i).getTitle());
        viewHolder.img_android.setImageResource(android.get(i).getResId());
        final int x = i;
        //Picasso.with(context).load(android.get(i).getAndroid_image_url()).resize(240, 120).into(viewHolder.img_android);

        /*main_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moduleIntent = new Intent(context, ModuleActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("course", coursePOJO);
                moduleIntent.putExtras(bundle);
                context.startActivity(moduleIntent);
                ((Activity) context).overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
                ((Activity) context).finish();
            }
        });*/

        viewHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent theIntent = null;
               if (android.get(x).getTitle().equalsIgnoreCase("Pay Money")) {
                   theIntent = new Intent(context, EnterPayActivity.class);
               }else if (android.get(x).getTitle().equalsIgnoreCase("Recieve Money")) {
                   theIntent = new Intent(context, EnterPayActivity.class);
               } else if (android.get(x).getTitle().equalsIgnoreCase("Schedule")) {
                   theIntent = new Intent(context, ScheduleActivity.class);
               } else if (android.get(x).getTitle().equalsIgnoreCase("Transactions")) {//
                   theIntent = new Intent(context, TransactionsActivity.class);
               } else if (android.get(x).getTitle().equalsIgnoreCase("Budget")) {//Bank Acounts
                   theIntent = new Intent(context, BudgetActivity.class);
               } else if (android.get(x).getTitle().equalsIgnoreCase("Bank Acounts")) {//
                   theIntent = new Intent(context, BankAccountsActivity.class);
               }

               if (theIntent != null) {
                   theIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   context.startActivity(theIntent);
                }




            }
        });
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_android;
        private LinearLayout rootView;
        private ImageView img_android;
        public ViewHolder(View view) {
            super(view);

            rootView = (LinearLayout)view.findViewById(R.id.rootview);
            tv_android = (TextView)view.findViewById(R.id.tv_android);
            img_android = (ImageView) view.findViewById(R.id.img_android);
        }
    }

}

