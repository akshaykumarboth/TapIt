package com.akshayboth.tapit.transaction;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.akshayboth.tapit.R;
import com.github.siyamed.shapeimageview.CircularImageView;

import java.util.ArrayList;
import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

public class TransactionsActivity extends AppCompatActivity {

    private SectionedRecyclerViewAdapter sectionAdapter;


    AppBarLayout appbar;
    RelativeLayout headerContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);


        appbar = (AppBarLayout) findViewById(R.id.appbar);

        headerContainer = (RelativeLayout) findViewById(R.id.rl_header_con1);

        setRecycler();
        setappBar();
    }

    public void setRecycler() {
        sectionAdapter = new SectionedRecyclerViewAdapter();

        //for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
        List<TransactionItem> contacts = prepareData();

        if (contacts.size() > 0) {
            sectionAdapter.addSection(new TransactionSection("9 May. 18", contacts));
        }
        //}

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv_transacations);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setAdapter(sectionAdapter);
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


    /*private List<TransactionItem> getListWithDate(String letter) {
        List<TransactionItem> contacts =

        for (TransactionItem contact : contacts) {
            if (contact.getDate().equals( letter)) {
                contacts.add(contact);
            }
        }

        return contacts;
    }*/

    private List<TransactionItem> prepareData() {

        List<TransactionItem> items = new ArrayList<>();
        items.add(new TransactionItem("9 May. 18", "DEBIT", 3000, "Sent To Nina",R.mipmap.ic_swap_vertical_circle_white_36dp));
        items.add(new TransactionItem("9 May. 18", "DEBIT", 3000, "Sent To Nina",R.mipmap.ic_swap_vertical_circle_white_36dp));
        items.add(new TransactionItem("9 May. 18", "DEBIT", 3000, "Sent To Nina",R.mipmap.ic_swap_vertical_circle_white_36dp));
        items.add(new TransactionItem("9 May. 18", "DEBIT", 3000, "Sent To Nina",R.mipmap.ic_swap_vertical_circle_white_36dp));
        items.add(new TransactionItem("9 May. 18", "DEBIT", 3000, "Sent To Nina",R.mipmap.ic_swap_vertical_circle_white_36dp));
        items.add(new TransactionItem("9 May. 18", "DEBIT", 3000, "Sent To Nina",R.mipmap.ic_swap_vertical_circle_white_36dp));

        return items;
    }


    //

    private class TransactionSection extends StatelessSection {

        String title;
        List<TransactionItem> list;

        TransactionSection(String title, List<TransactionItem> list) {
            super(SectionParameters.builder()
                    .itemResourceId(R.layout.transaction_child_item)
                    .headerResourceId(R.layout.transaction_header_item)
                    .build());

            this.title = title;
            this.list = list;
        }

        @Override
        public int getContentItemsTotal() {
            return list.size();
        }

        @Override
        public RecyclerView.ViewHolder getItemViewHolder(View view) {
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
            final ItemViewHolder itemHolder = (ItemViewHolder) holder;

            TransactionItem item = list.get(position);
            itemHolder.tvDesc.setText(item.getDescritpion());
            itemHolder.tvAmount.setText("" + item.getAmount());

            //itemHolder.tvItem.setText(name);
            itemHolder.imgItem.setImageResource(R.drawable.bg);

            itemHolder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getBaseContext(),
                            String.format("Clicked on position #%s of Section %s",
                                    sectionAdapter.getPositionInSection(itemHolder.getAdapterPosition()),
                                    title),
                            Toast.LENGTH_SHORT).show();

                    /*Intent theIntent = new Intent(EnterPayActivity.this, PayAmountActivity.class);
                    theIntent.putExtra("name", itemHolder.tvItem.getText().toString().trim());
                    startActivity(theIntent);*/

                    //itemHolder.rootView.setBackgroundColor(getResources().getColor(R.color.theme_blue));
                    //itemHolder.tvItem.setTextColor(getResources().getColor(R.color.theme_yellow));

                }
            });
        }

        @Override
        public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
            return new HeaderViewHolder(view);
        }

        @Override
        public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
            headerHolder.tvTitle.setText(title);
        }
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvTitle;

        HeaderViewHolder(View view) {
            super(view);

            tvTitle = (TextView) view.findViewById(R.id.tv_date);
        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        private final View rootView;
        private final CircularImageView imgItem;
        private final TextView tvDesc, tvAmount;

        ItemViewHolder(View view) {
            super(view);

            rootView = view;
            imgItem = (CircularImageView) view.findViewById(R.id.imgItem);
            tvDesc = (TextView) view.findViewById(R.id.tv_desc);
            tvAmount = (TextView) view.findViewById(R.id.tv_Amount);
        }
    }
}
