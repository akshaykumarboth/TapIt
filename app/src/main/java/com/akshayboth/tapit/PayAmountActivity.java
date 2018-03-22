package com.akshayboth.tapit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PayAmountActivity extends AppCompatActivity {
    TextView contact_name;
    Button continueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_amount);


        contact_name = (TextView) findViewById(R.id.tv_contact_name);
        continueBtn = (Button) findViewById(R.id.btn_amount_continue);

        Intent i= getIntent();
        if (i != null) {
            String x = i.getStringExtra("name");
            contact_name.setText(x);
        }

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent theIntent = new Intent(PayAmountActivity.this, SummaryPayActivity.class);
                theIntent.putExtra("name", contact_name.getText().toString().trim());
                startActivity(theIntent);
            }
        });

    }
}
