package com.akshayboth.tapit;

/**
 * Created by akshayboth on 18/03/18.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.akshayboth.tapit.pojo.ProfileFeatureItem;

import java.util.List;

public class ProfileGridAdapter extends RecyclerView.Adapter<ProfileGridAdapter.ViewHolder> {
    private List<ProfileFeatureItem> android;
    private Context context;

    public ProfileGridAdapter(Context context, List<ProfileFeatureItem> android) {
        this.android = android;
        this.context = context;
    }

    @Override
    public ProfileGridAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.profile_grid_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileGridAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_android.setText(android.get(i).getTitle());
        viewHolder.img_android.setImageResource(android.get(i).getResId());
        //Picasso.with(context).load(android.get(i).getAndroid_image_url()).resize(240, 120).into(viewHolder.img_android);
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_android;
        private ImageView img_android;
        public ViewHolder(View view) {
            super(view);

            tv_android = (TextView)view.findViewById(R.id.tv_android);
            img_android = (ImageView) view.findViewById(R.id.img_android);
        }
    }

}
