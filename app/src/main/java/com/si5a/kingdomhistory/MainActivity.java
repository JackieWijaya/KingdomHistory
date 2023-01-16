package com.si5a.kingdomhistory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvKingdom;
    private ArrayList<ModelKingdom> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvKingdom = findViewById(R.id.rv_kingdom);
        rvKingdom.setHasFixedSize(true);

        data.addAll(DataKingdom.ambilDataKingdom());
        tampilDataCard();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top_right, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_card:
                tampilDataCard();
                break;
            case R.id.menu_grid:
                tampilDataGrid();
                break;
            case R.id.menu_about:
                tampilDataAbout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void tampilDataCard() {
        rvKingdom.setLayoutManager(new LinearLayoutManager(this));
        AdapterCard colokanCard = new AdapterCard(data);
        rvKingdom.setAdapter(colokanCard);

        colokanCard.setOnItemCallBack(new AdapterGrid.OnItemClickCallBack() {
            @Override
            public void onItemClicked(ModelKingdom data) {
                Intent pindah = new Intent(MainActivity.this, DetailActivity.class);
                pindah.putExtra("xNama", data.getNama());
                pindah.putExtra("xTentang", data.getTentang());
                pindah.putExtra("xFoto", data.getFoto());
                startActivity(pindah);
            }
        });
    }

    private void tampilDataGrid(){
        rvKingdom.setLayoutManager(new GridLayoutManager(this,2));
        AdapterGrid colokanGrid = new AdapterGrid(data);
        rvKingdom.setAdapter(colokanGrid);

        colokanGrid.setOnItemCallBack(new AdapterGrid.OnItemClickCallBack() {
            @Override
            public void onItemClicked(ModelKingdom data) {
                Toast.makeText(MainActivity.this, "Nama Kingdom: " + data.getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void tampilDataAbout(){
        startActivity(new Intent(MainActivity.this, AboutActivity.class));
    }
}