/*
package com.example.purestock;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.purestock.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.purestock.DatabaseHelper.TRANSACTIONS_TABLE;

public class historyActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;


    DatabaseHelper dbHelper = new DatabaseHelper(this);
    ArrayList<String> stockIDs;
    ArrayList<String> comNames; // Do the same as stockIDs with this!
    ArrayList<Double> transPrices;



    private String GetStockNameByID(String stockID)
    {
        String result = "";
        Cursor stockCursor = dbHelper.getData("select NAME from " + DatabaseHelper.STOCKS_TABLE + " WHERE ID=\"" +
                stockID + "\"");

        if (stockCursor != null) {
            if (stockCursor.moveToFirst()) {
                result = stockCursor.getString(stockCursor.getColumnIndex("NAME"));
            }
        }

        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Toolbar toolbar = findViewById(R.id.top_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("History");

        User us = new User();
        int uid = us.getUid();

        LoadTransactionStock(String.valueOf(uid)); //this will load everything
        ArrayList<ExampleItem> exampleList = new ArrayList<>();

//        Log.d("arr list size",String.valueOf(stockIDs.size()) );

        for(int i=0; i<stockIDs.size() ; i++) {

//            Log.d("arr count",String.valueOf(i));
//            Log.d("arr list",String.valueOf(stockIDs.get(i)));

            exampleList.add(new ExampleItem(stockIDs.get(i),comNames.get(i), transPrices.get(i)));
        }

//        Toast.makeText(this, stockIDs.get(0) , Toast.LENGTH_SHORT);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }



    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu); //here attach menu object
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Item1 selected", Toast.LENGTH_SHORT);
                return true;

            case R.id.item2:
                Toast.makeText(this, "Item2 selected", Toast.LENGTH_SHORT);
                return true;


        }
        return super.onOptionsItemSelected(item);
    }


    private void LoadTransactionStock(String UID) // UID must go as a string so that database can understand it
    {


        Cursor historyCusror = dbHelper.getData("SELECT * FROM " + DatabaseHelper.TRANSACTIONS_TABLE + " WHERE UID=\"" +
                UID + "\"");

        String stockID;
        Double price;

        historyCusror.moveToFirst(); //keeps the cursor at the top

        if((stockIDs != null) && (stockIDs.size() > 0)) {
            stockIDs.clear();
            comNames.clear();
            transPrices.clear();
        }

        //Log.d("History test",historyCusror.getString(3).toString());
        //String arr[] = new String[historyCusror.getColumnCount()];
        //Log.d("cursor length", String.valueOf(historyCusror.getColumnCount()));//tells the length of total SID column

        if (historyCusror != null) {

            stockIDs = new ArrayList<String>();
            comNames = new ArrayList<String>();
            transPrices = new ArrayList<Double>();

            int i=0;
            while (!historyCusror.isAfterLast()){


//                Log.d("History test0", String.valueOf(historyCusror.getString(2)));
//                Log.d("History test1", String.valueOf(historyCusror.getString(2)));
//                Log.d("History test2", String.valueOf(historyCusror.getString(2)));


                // arr[i] = String.valueOf(historyCusror.getString(2));
                stockID = String.valueOf(historyCusror.getString(2));
                price = historyCusror.getDouble(3);

//                Log.d("History test Arr", arr[i]);


                if(stockIDs != null) {
                    stockIDs.add(stockID);
                    comNames.add(GetStockNameByID(stockID));
                    transPrices.add(price);
                }

                historyCusror.moveToNext(); //incrementing the cursor to next row
//                Log.d("count",String.valueOf(i));

            }

        }

    }



}
*/


package com.example.purestock;


import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.purestock.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.purestock.DatabaseHelper.TRANSACTIONS_TABLE;

public class historyActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;


    DatabaseHelper dbHelper = new DatabaseHelper(this);
    ArrayList<String> stockIDs;
    ArrayList<String> comNames; // Do the same as stockIDs with this!
    ArrayList<Double> transPrices;



    private String GetStockNameByID(String stockID)
    {
        String result = "";
        Cursor stockCursor = dbHelper.getData("select NAME from " + DatabaseHelper.STOCKS_TABLE + " WHERE ID=\"" +
                stockID + "\"");

        if (stockCursor != null) {
            if (stockCursor.moveToFirst()) {
                result = stockCursor.getString(stockCursor.getColumnIndex("NAME"));
            }
        }

        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Toolbar toolbar = findViewById(R.id.top_toolbar);
        setSupportActionBar(toolbar);

        User us = new User();
        int uid = us.getUid();

        LoadTransactionStock(String.valueOf(uid)); //this will load everything
        ArrayList<ExampleItem> exampleList = new ArrayList<>();

//        Log.d("arr list size",String.valueOf(stockIDs.size()) );

        for(int i=0; i<stockIDs.size() ; i++) {

//            Log.d("arr count",String.valueOf(i));
//            Log.d("arr list",String.valueOf(stockIDs.get(i)));

            exampleList.add(new ExampleItem(stockIDs.get(i),comNames.get(i), transPrices.get(i)));
        }

//        Toast.makeText(this, stockIDs.get(0) , Toast.LENGTH_SHORT);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }



    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu); //here attach menu object
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Item1 selected", Toast.LENGTH_SHORT);
                return true;

            case R.id.item2:
                Toast.makeText(this, "Item2 selected", Toast.LENGTH_SHORT);
                return true;


        }
        return super.onOptionsItemSelected(item);
    }


    private void LoadTransactionStock(String UID) // UID must go as a string so that database can understand it
    {


        Cursor historyCusror = dbHelper.getData("SELECT * FROM " + DatabaseHelper.TRANSACTIONS_TABLE + " WHERE UID=\"" +
                UID + "\"");

        String stockID;
        Double price;

        historyCusror.moveToFirst(); //keeps the cursor at the top

        if((stockIDs != null) && (stockIDs.size() > 0)) {
            stockIDs.clear();
            comNames.clear();
            transPrices.clear();
        }

        //Log.d("History test",historyCusror.getString(3).toString());
        //String arr[] = new String[historyCusror.getColumnCount()];
        //Log.d("cursor length", String.valueOf(historyCusror.getColumnCount()));//tells the length of total SID column

        if (historyCusror != null) {

            stockIDs = new ArrayList<String>();
            comNames = new ArrayList<String>();
            transPrices = new ArrayList<Double>();

            int i=0;
            while (!historyCusror.isAfterLast()){


//                Log.d("History test0", String.valueOf(historyCusror.getString(2)));
//                Log.d("History test1", String.valueOf(historyCusror.getString(2)));
//                Log.d("History test2", String.valueOf(historyCusror.getString(2)));


                // arr[i] = String.valueOf(historyCusror.getString(2));
                stockID = String.valueOf(historyCusror.getString(2));
                price = historyCusror.getDouble(3);

//                Log.d("History test Arr", arr[i]);


                if(stockIDs != null) {
                    stockIDs.add(stockID);
                    comNames.add(GetStockNameByID(stockID));
                    transPrices.add(price);
                }

                historyCusror.moveToNext(); //incrementing the cursor to next row
//                Log.d("count",String.valueOf(i));

            }

        }

    }



}

