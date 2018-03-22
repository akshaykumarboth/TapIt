package com.akshayboth.tapit.budget;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.akshayboth.tapit.DashboardGridAdapter;
import com.akshayboth.tapit.R;
import com.akshayboth.tapit.pojo.BudgetItem;

import java.util.List;

/**
 * Created by akshayboth on 21/03/18.
 */

public class BudgetListAdapter extends RecyclerView.Adapter<BudgetListAdapter.ViewHolder> {
    private List<BudgetItem> android;
    private Context context;

    public BudgetListAdapter(Context context, List<BudgetItem> android) {
        this.android = android;
        this.context = context;
    }

    @Override
    public BudgetListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.budget_item, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(BudgetListAdapter.ViewHolder viewHolder, int i) {

        viewHolder.budgetName.setText(android.get(i).getBudgetName());
        viewHolder.budgetType.setText(android.get(i).getBudgetType());
        viewHolder.img_android.setImageResource(android.get(i).getResId());
        viewHolder.img_android.setColorFilter(ContextCompat.getColor(context, R.color.theme_blue), PorterDuff.Mode.MULTIPLY);
        viewHolder.progressBar.setMax(android.get(i).getBudgetAmount());
        viewHolder.progressBar.setProgress(android.get(i).getSpentAmount());
        viewHolder.budgetAmount.setText("Budget: " + context.getResources().getString(R.string.Rs) + " " + android.get(i).getBudgetAmount());
        viewHolder.spentAmount.setText("Spent: " + context.getResources().getString(R.string.Rs) + " " + android.get(i).getSpentAmount());

        //viewHolder.progressBar.setScaleY(3f);

        try {
            LayerDrawable progressBarDrawable = (LayerDrawable) viewHolder.progressBar.getProgressDrawable();
            progressBarDrawable.getDrawable(0).setColorFilter(ContextCompat.getColor(context, R.color.theme_blue_light_bg_alpha), PorterDuff.Mode.SRC_IN);
            progressBarDrawable.getDrawable(2).setColorFilter(ContextCompat.getColor(context, R.color.theme_yellow), PorterDuff.Mode.SRC_IN);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
                /*Intent theIntent = null;
                if (android.get(x).getTitle().equalsIgnoreCase("Pay Money")) {
                    theIntent = new Intent(context, EnterPayActivity.class);
                } else if (android.get(x).getTitle().equalsIgnoreCase("Budget")) {//Bank Acounts
                    theIntent = new Intent(context, BudgetActivity.class);
                }

                if (theIntent != null) {
                    theIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(theIntent);
                }*/

            }
        });
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView budgetName, budgetType, budgetAmount, spentAmount;
        private LinearLayout rootView;
        private ImageView img_android;
        private ProgressBar progressBar;

        public ViewHolder(View view) {
            super(view);

            rootView = (LinearLayout)view.findViewById(R.id.rootview);
            budgetName = (TextView)view.findViewById(R.id.tv_budgetName);
            budgetType = (TextView)view.findViewById(R.id.tv_budgetType);
            budgetAmount = (TextView)view.findViewById(R.id.tv_budgetAmount);
            spentAmount = (TextView)view.findViewById(R.id.tv_spentAmount);
            img_android = (ImageView) view.findViewById(R.id.img);
            progressBar = (ProgressBar) view.findViewById(R.id.progress);
        }
    }

}


