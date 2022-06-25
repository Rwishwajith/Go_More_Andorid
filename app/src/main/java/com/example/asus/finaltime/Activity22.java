package com.example.asus.finaltime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity22 extends AppCompatActivity {
    private  Button button1,button2,button3,button4,button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_22);
        button1=(Button) findViewById(R.id.bt);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });
        button2=(Button) findViewById(R.id.bt4);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        button3=(Button) findViewById(R.id.bt1);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        button4=(Button) findViewById(R.id.bt2);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
        button5=(Button) findViewById(R.id.bt3);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });
    }
    public void openActivity1(){
        Intent intent=new Intent(this,Activity24.class);
        startActivity(intent);
    }
    public void openActivity2(){
        Intent intent=new Intent(this,Activity23.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent=new Intent(this,Activity25.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent=new Intent(this,Activity26.class);
        startActivity(intent);
    }
    public void openActivity5(){
        Intent intent=new Intent(this,Activity27.class);
        startActivity(intent);
    }
}
