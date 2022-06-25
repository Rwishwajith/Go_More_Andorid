package com.example.asus.finaltime;

import ir.mirrajabi.searchdialog.core.Searchable;

public class Searchmodel implements Searchable {
    private String mTitle;
    public Searchmodel(String mTitle){
        this.mTitle=mTitle;
    }
    public void setTitle(String mTitle){
        this.mTitle=mTitle;
    }
    @Override
    public String getTitle() {
        return mTitle;
    }
}
