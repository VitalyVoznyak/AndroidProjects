package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainOrderActivity extends AppCompatActivity {
    private static final String EXTRA_NAME = "userName";

    private TextView textViewGreetings,textViewAdditives;
    private RadioGroup radioGroupDrinks;
    private RadioButton radioButtonTea,radioButtonCoffe;
    private CheckBox checkboxSugar,checkboxMilk,checkboxLemon;
    private Spinner spinnerTea,spinnerCoffe;
    private Button buttonMakeOrder;
    private String name;
    private String drink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_order);

        initViews();
        setupUserName();

        radioGroupDrinks.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int Id) {
                if(Id == radioButtonTea.getId()){
                    onUserChoseTea();
                }else if (Id == radioButtonCoffe.getId()){
                    onUserChoseCoffe();
                }
            }
        });

        radioButtonTea.setChecked(true);

        buttonMakeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onUserMadeOrder();
            }
        });
    }

    public static Intent newIntent(Context context,String name){
        Intent intent = new Intent(context, MainOrderActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        return intent;
    }
    private void setupUserName(){
        String name = getIntent().getStringExtra(EXTRA_NAME);
        String greetings = getString(R.string.greetings,name);
        textViewGreetings.setText(greetings);
        this.name = name;
    }
    private void initViews(){
        textViewGreetings = findViewById(R.id.textViewGreetings);
        textViewAdditives = findViewById(R.id.textViewAdditives);
        radioGroupDrinks = findViewById(R.id.radioGroupDrinks);
        radioButtonTea = findViewById(R.id.radioButtonTea);
        radioButtonCoffe = findViewById(R.id.radioButtonCoffe);
        checkboxSugar = findViewById(R.id.checkboxSugar);
        checkboxMilk = findViewById(R.id.checkboxMilk);
        checkboxLemon = findViewById(R.id.checkboxLemon);
        spinnerTea = findViewById(R.id.spinnerTea);
        spinnerCoffe = findViewById(R.id.spinnerCoffe);
        buttonMakeOrder = findViewById(R.id.buttonMakeOrder);
    }
    private void onUserChoseTea(){
        drink = getString(R.string.tea);
        String additivesLabel = getString(R.string.additives,getString(R.string.tea));
        textViewAdditives.setText(additivesLabel);
        checkboxLemon.setVisibility(View.VISIBLE);
        spinnerTea.setVisibility(View.VISIBLE);
        spinnerCoffe.setVisibility(View.INVISIBLE);
    }
    private void onUserChoseCoffe(){
        drink = getString(R.string.coffe);
        String additivesLabel = getString(R.string.additives,getString(R.string.coffe));
        textViewAdditives.setText(additivesLabel);
        checkboxLemon.setVisibility(View.INVISIBLE);
        spinnerTea.setVisibility(View.INVISIBLE);
        spinnerCoffe.setVisibility(View.VISIBLE);
    }
    private void onUserMadeOrder(){
        ArrayList<String> additives = new ArrayList<>();
        if(checkboxSugar.isChecked()){
            additives.add(checkboxSugar.getText().toString());
        }
        if(checkboxMilk.isChecked()){
            additives.add(checkboxMilk.getText().toString());
        }
        if(radioButtonTea.isChecked() || checkboxLemon.isChecked()){
            additives.add(checkboxLemon.getText().toString());
        }

        String drinkType = "";
        if(radioButtonTea.isChecked()){
            drinkType = spinnerTea.getSelectedItem().toString();
        }else if(radioButtonCoffe.isChecked()){
            drinkType = spinnerCoffe.getSelectedItem().toString();
        }

        if (name != null){
            Log.d("Yee",name);}
        if (drink != null){
            Log.d("Yee",drink);}
        if (drinkType != null){
            Log.d("Yee",drinkType);}
        if (additives != null){
            Log.d("Yee",additives.toString());}


        Intent intent = OrderDetailActivity.newIntent(
                MainOrderActivity.this,
                name,
                drink,
                additives.toString(),
                drinkType);
        startActivity(intent);
    }
}