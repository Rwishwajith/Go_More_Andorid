package com.example.asus.finaltime;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button button,button1,button2;
    RelativeLayout rellay1,rellay2;
    private EditText txtEmailLogin;
    private EditText txtpwd;
    private FirebaseAuth firebaseAuth;
    Handler handler=new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmailLogin=(EditText)findViewById(R.id.txtEmailLogin);
        txtpwd=(EditText)findViewById(R.id.txtPasswordLogin);
        firebaseAuth=FirebaseAuth.getInstance();

        rellay1=(RelativeLayout) findViewById(R.id.rellay1);
        rellay2=(RelativeLayout) findViewById(R.id.rellay2);

        handler.postDelayed(runnable,2000);
        button=(Button) findViewById(R.id.button);
        button1=(Button) findViewById(R.id.button1);
        button2=(Button) findViewById(R.id.foget);
        //button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View V){
//                openActivity2();
//            }
//        });
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                openActivity3();
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                openActivity4();
            }
        });
    }
//    public void openActivity2(){
//        Intent intent=new Intent(this,Activity2.class);
//        startActivity(intent);
//    }
    public void openActivity3(){
        Intent intent=new Intent(this,Activity3.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent=new Intent(this,Activity32.class);
        startActivity(intent);
    }
    public void btnUserLogin_Click(View v){
        final ProgressDialog progressDialog=ProgressDialog.show(MainActivity.this,"Please wait...","Proccessing....",true);
        (firebaseAuth.signInWithEmailAndPassword(txtEmailLogin.getText().toString(),txtpwd.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"LoginSuccessful",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(MainActivity.this,Activity2.class);
                    i.putExtra("Email",firebaseAuth.getCurrentUser().getEmail());
                    startActivity(i);
                }else{
                    Log.e("Error",task.getException().toString());
                    Toast.makeText(MainActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
