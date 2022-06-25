package com.example.asus.finaltime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity15 extends AppCompatActivity {
    private Button button1,button2,button3,button4,button5,button6,button7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_15);
        button1=(Button) findViewById(R.id.btn20);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });
        button2=(Button) findViewById(R.id.btn21);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        button3=(Button) findViewById(R.id.btn23);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        button4=(Button) findViewById(R.id.btn24);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
        button5=(Button) findViewById(R.id.btn25);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });
        button6=(Button) findViewById(R.id.btn26);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity6();
            }
        });
        button7=(Button) findViewById(R.id.btn22);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity7();
            }
        });
    }
    public void openActivity1(){
        Intent intent=new Intent(this,Activity16.class);
        startActivity(intent);
    }
    public void openActivity2(){
        Intent intent=new Intent(this,Activity17.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent=new Intent(this,Activity18.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent=new Intent(this,Activity19.class);
        startActivity(intent);
    }
    public void openActivity5(){
        Intent intent=new Intent(this,Activity20.class);
        startActivity(intent);
    }
    public void openActivity6(){
        Intent intent=new Intent(this,Activity21.class);
        startActivity(intent);
    }
    public void openActivity7(){
        Intent intent=new Intent(this,Activity22.class);
        startActivity(intent);
    }
}
