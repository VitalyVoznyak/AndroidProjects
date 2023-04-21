package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OrderDetailActivity extends AppCompatActivity {

    private static  final String EXTRA_USER_NAME = "userName";
    private static  final String EXTRA_USER_DRINK = "drink";
    private static  final String EXTRA_USER_ADDITIVES = "additives";
    private static  final String EXTRA_USER_DRINK_TYPE = "drinkType";

    private String userName,drink,additives,drinkType;
    private TextView textViewName,textViewDrink,textViewDrinkType,textViewAdditives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        initViewsAndValues();
        setValuesToTextView();
    }
    public static Intent newIntent(Context context, String name, String drink, String additives, String drinkType ){
        Intent intent = new Intent(context, OrderDetailActivity.class);
        intent.putExtra(EXTRA_USER_NAME, name);
        intent.putExtra(EXTRA_USER_DRINK, drink);
        intent.putExtra(EXTRA_USER_ADDITIVES, additives);
        intent.putExtra(EXTRA_USER_DRINK_TYPE, drinkType);
        return intent;
    }

    private void initViewsAndValues(){
        textViewName = findViewById(R.id.textViewName);
        textViewDrink = findViewById(R.id.textViewDrink);
        textViewDrinkType = findViewById(R.id.textViewDrinkType);
        textViewAdditives = findViewById(R.id.textViewAdditives);

        userName = getIntent().getStringExtra(EXTRA_USER_NAME);
        drink = getIntent().getStringExtra(EXTRA_USER_DRINK);
        additives = getIntent().getStringExtra(EXTRA_USER_ADDITIVES);
        drinkType = getIntent().getStringExtra(EXTRA_USER_DRINK_TYPE);
    }
    private void setValuesToTextView(){
        textViewName.setText(userName);
        textViewDrink.setText(drink);
        textViewAdditives.setText(additives);
        textViewDrinkType.setText(drinkType);

    }
}