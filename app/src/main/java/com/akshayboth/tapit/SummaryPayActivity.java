package com.akshayboth.tapit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class SummaryPayActivity extends AppCompatActivity {
    Spinner spinner2;

    String[] spinnerValues = {"PNB", "HDFC", "IDBC", "ICICICI", "SBI",};
    int total_images[] = {R.drawable.bg, R.drawable.bg, R.drawable.bg, R.drawable.bg, R.drawable.bg, R.drawable.bg};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_pay);
        spinner2 = (Spinner) findViewById(R.id.spinner);
        TextView contact_name = (TextView) findViewById(R.id.tv_contact_name);
        Button sendBtn = (Button) findViewById(R.id.btn_amount_continue);

        spinner2.setAdapter(new MyAdapter(this, R.layout.custom_spinner,
                spinnerValues));

        Intent i= getIntent();
        if (i != null) {
            String x = i.getStringExtra("name");
            contact_name.setText(x);
        }

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                //TransactionStatusActivity
                //Intent theIntent = new Intent(SummaryPayActivity.this, TransactionStatusActivity.class);
                //theIntent.putExtra("name", contact_name.getText().toString().trim());
                //startActivity(theIntent);

            }
        });
    }

    public class MyAdapter extends ArrayAdapter<String> {

        public MyAdapter(Context ctx, int txtViewResourceId, String[] objects) {
            super(ctx, txtViewResourceId, objects);
        }

        @Override
        public View getDropDownView(int position, View cnvtView, ViewGroup prnt) {
            return getCustomView(position, cnvtView, prnt);
        }

        @Override
        public View getView(int pos, View cnvtView, ViewGroup prnt) {
            return getCustomView(pos, cnvtView, prnt);
        }

        public View getCustomView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = getLayoutInflater();
            View mySpinner = inflater.inflate(R.layout.custom_spinner, parent, false);
            TextView main_text = (TextView) mySpinner.findViewById(R.id.text_main_seen);
            main_text.setText(spinnerValues[position]);
            ImageView left_icon = (ImageView) mySpinner.findViewById(R.id.left_pic);
            left_icon.setImageResource(total_images[position]);
            return mySpinner;
        }
    }


}
