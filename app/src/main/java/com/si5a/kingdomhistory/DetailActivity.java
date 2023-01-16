package com.si5a.kingdomhistory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.net.UriCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private TextView tvNama, tvTentang;
    private ImageView ivFoto;
    private String yNama, yTentang, yFoto, getLokasi;
    private Button btnLokasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle("Kingdom");

        initView();

        Intent terima = getIntent();
        yNama = terima.getStringExtra("xNama");
        yTentang = terima.getStringExtra("xTentang");
        yFoto = terima.getStringExtra("xFoto");

        tvNama.setText(yNama);
        tvTentang.setText(yTentang);

        Glide
                .with(DetailActivity.this)
                .load(yFoto)
                .into(ivFoto);

        btnLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLokasi = yNama;

                Uri location = Uri.parse("geo:0,0?q=" + getLokasi);
                Intent bukaLokasi = new Intent(Intent.ACTION_VIEW, location);
                startActivity(bukaLokasi);
            }
        });
    }

    private void initView(){
        tvNama = findViewById(R.id.tv_nama_kingdom);
        tvTentang = findViewById(R.id.tv_tentang_kingdom);
        ivFoto = findViewById(R.id.iv_foto);
        btnLokasi = findViewById(R.id.btn_lokasi);
    }
}