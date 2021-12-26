package com.example.testapponjava;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    protected int quantity = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    HashMap<String, Double> goodsMap;
    String goodsName;
    double price;
    EditText userNameEdTx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameEdTx = findViewById(R.id.edTextUserName);
        crateSpinner();
        createMap();
    }

    void crateSpinner() {
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");
        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    void createMap() {
        goodsMap = new HashMap();
        goodsMap.put("guitar", 500.0);
        goodsMap.put("drums", 700.0);
        goodsMap.put("keyboard", 1500.0);
    }

//    public void setPriceToOne(View view) {
//        this.pricex++;
//        TextView tvPrice = findViewById(R.id.tvPrice);
//        tvPrice.setText(String.valueOf(pricex));
////        if (price % 2 == 0) {
////            Intent i;
////            i = new Intent(this, SecondActivity.class);
////            startActivity(i);
////        }
//    }

    public void clickPlus(View view) {
        quantity++;
        TextView textView = findViewById(R.id.tvQuantity);
        textView.setText(String.valueOf(quantity));
        TextView priceTextView = findViewById(R.id.tvPrice);
        priceTextView.setText(String.valueOf(quantity * price));
    }

    public void clickMinus(View view) {
        if (quantity > 0) {
            quantity--;
            TextView textView = findViewById(R.id.tvQuantity);
            textView.setText(String.valueOf(quantity));
            TextView priceTextView = findViewById(R.id.tvPrice);
            priceTextView.setText(String.valueOf(quantity * price));
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        goodsName = spinner.getSelectedItem().toString();
        price = goodsMap.get(goodsName);
        TextView priceTextView = findViewById(R.id.tvPrice);
        priceTextView.setText(String.valueOf(quantity * price));
        ImageView ivGoods = findViewById(R.id.ivGoods);
        switch (goodsName) {
            case "guitar":
                ivGoods.setImageResource(R.drawable.guitar1);
                break;
            case "drums":
                ivGoods.setImageResource(R.drawable.guitar2);
                break;
            case "keyboard":
                ivGoods.setImageResource(R.drawable.guitar2);
                break;
            default:
                ivGoods.setImageResource(R.drawable.guitar1);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void addToCart(View view) {
        Order order = new Order();
        order.userName = userNameEdTx.getText().toString();
        Log.d("printCart", order.userName);
        order.goodsName = goodsName;
        Log.d("printCart", order.goodsName);
        order.quantity = quantity;
        Log.d("printCart", String.valueOf(order.quantity));
        order.orderPrice = quantity*price;
        Log.d("printCart", String.valueOf(order.orderPrice));
    }
}