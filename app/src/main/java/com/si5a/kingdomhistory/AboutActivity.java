package com.si5a.kingdomhistory;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {
    private TextView tvCreateBy, tvJackie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        tvCreateBy = findViewById(R.id.tv_create_by);
        tvJackie = findViewById(R.id.tv_jackie);
    }
}
