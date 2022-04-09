package com.example.seekdiscomfort;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    SearchView mySearchView;
    ListView myList;

    ArrayList <String> list;
    ArrayAdapter <String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mySearchView = findViewById(R.id.searchView);
        myList = findViewById(R.id.myList);

        list = new ArrayList<String>();

        list.add("Seeker LS Tee");
        list.add("Seeker Fashion Tee");
        list.add("Black Align High Rise Pant");
        list.add("Seeker Sweatpants");
        list.add("Seeker SweatShirt");
        list.add("Seek Discomfort Ring");
        list.add("Rope Bracelet - Silver Bolt");
        list.add("Extra Necklace Chain");
        list.add("Love Over Fear Ring");
        list.add("Mantra Necklace");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        myList.setAdapter(adapter);


        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }
        });

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String myItem = adapter.getItem(position).toString();

                Intent intent = new Intent(SearchActivity.this, ProductActivity.class);
                intent.putExtra("item", myItem);
                startActivity(intent);
            }
        });
    }
}