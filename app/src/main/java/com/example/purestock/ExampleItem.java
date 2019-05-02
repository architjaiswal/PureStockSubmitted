package com.example.purestock;
public class ExampleItem {
    private String ticker; // ticker symbol for the stock
    private String comName; // company name of the stock
    private double tranPrice; // transaction price of the stock


    // constructor for the ExampleItem class
    public ExampleItem (String ticker, String comName, Double tranPrice ){
        this.ticker = ticker;
        this.comName = comName;
        this.tranPrice = tranPrice;

    }

    /*
    The variables of ExampleItem are private hence we will need the below mentioned functions to return
    needed items.
     */
    public String getTicker(){ // returns ticker symbol
        return ticker;
    }

    public String getCompanyName(){ // returns company name of the stock
        return comName;
    }

    public double getTransactionPrice(){  // returns the price of at which stock was bought or sold
        return tranPrice;
    }
}