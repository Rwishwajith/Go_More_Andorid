package com.example.asus.finaltime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity4 extends AppCompatActivity {
    private  Button button,button1,button2,button3,button4,button5,button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        button=(Button) findViewById(R.id.btn1);
        button2=(Button) findViewById(R.id.btn7);
        button3=(Button) findViewById(R.id.btn8);
        button6=(Button) findViewById(R.id.btn9);
        button4=(Button) findViewById(R.id.btn10);
        button5=(Button) findViewById(R.id.btn11);
        button1=(Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                openActivity2();
            }
        });
        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                openActivity8();
            }
        });
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                openActivity7();
            }
        });
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                openActivity6();
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                openActivity5();
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                openActivity4();
            }
        });

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                openActivity3();
            }
        });
    }
    public void openActivity2(){
        Intent intent=new Intent(this,Activity5.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent=new Intent(this,Activity7.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent=new Intent(this,Activity8.class);
        startActivity(intent);
    }
    public void openActivity5(){
        Intent intent=new Intent(this,Activity9.class);
        startActivity(intent);
    }
    public void openActivity6(){
        Intent intent=new Intent(this,Activity10.class);
        startActivity(intent);
    }
    public void openActivity7(){
        Intent intent=new Intent(this,Activity11.class);
        startActivity(intent);
    }
    public void openActivity8(){
        Intent intent=new Intent(this,Activity12.class);
        startActivity(intent);
    }
}
