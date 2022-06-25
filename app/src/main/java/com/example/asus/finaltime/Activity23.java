package com.example.asus.finaltime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity23 extends AppCompatActivity {
    private  Button button1,button2,button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_23);
        button1=(Button) findViewById(R.id.bt);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });
        button2=(Button) findViewById(R.id.bt1);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        button3=(Button) findViewById(R.id.bt2);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        button4=(Button) findViewById(R.id.bt3);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
    }
    public void openActivity1(){
        Intent intent=new Intent(this,Activity28.class);
        startActivity(intent);
    }
    public void openActivity2(){
        Intent intent=new Intent(this,Activity29.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent=new Intent(this,Activity30.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent=new Intent(this,Activity31.class);
        startActivity(intent);
    }
}
