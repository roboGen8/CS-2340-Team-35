package com.example.ben.cs2340.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ben.cs2340.DemoClass;
import com.example.ben.cs2340.R;

public class SearchActivity extends AppCompatActivity {
    private EditText mCategorySearch;
    private EditText mItemNameSearch;

    private Button mCategoryBtn;
    private Button mItemNameBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mCategorySearch = findViewById(R.id.categorySearch);
        mItemNameSearch = findViewById(R.id.itemNameSearch);

        mCategoryBtn = findViewById(R.id.searchByCategoryButton);
        mItemNameBtn = findViewById(R.id.searchByItemName);


    }

    public void onSearchByCategoryPressed(View view) {
        String categoryStr = mCategorySearch.getText().toString();
        DemoClass.message = categoryStr;
        Intent intent = new Intent(this, SearchByCategoryActivity.class);
        startActivity(intent);
    }

    public void onSearchByItemNamePressed(View view) {
        String itemNameStr = mItemNameSearch.getText().toString();
        DemoClass.message = itemNameStr;
        Intent intent = new Intent(this, SearchByItemNameActivity.class);
        startActivity(intent);
    }
}
