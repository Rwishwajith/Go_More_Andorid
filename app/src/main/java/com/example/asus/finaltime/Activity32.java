package com.example.asus.finaltime;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Activity32 extends AppCompatActivity {
    private Toolbar mToolbar;
    private Button ResetPasswordSendEmailButton;
    private EditText ResetEmailInput;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_32);
        mAuth=FirebaseAuth.getInstance();
        ResetPasswordSendEmailButton=(Button)findViewById(R.id.sendemail);
        ResetEmailInput=(EditText)findViewById(R.id.txtEmailLogin);
        ResetPasswordSendEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userEmail=ResetEmailInput.getText().toString();
                if(TextUtils.isEmpty(userEmail)){
                    Toast.makeText(Activity32.this,"Please write your valid email address first...",Toast.LENGTH_SHORT).show();
                }
                else{
                    mAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                           if(task.isSuccessful()){
                               Toast.makeText(Activity32.this,"Please Check your Email Account...",Toast.LENGTH_SHORT).show();
                               startActivity(new Intent(Activity32.this,MainActivity.class));
                           }else{String message=task.getException().getMessage();
                               Toast.makeText(Activity32.this,"Error..."+message,Toast.LENGTH_SHORT).show();
                           }
                        }
                    });
                }
            }
        });
    }
}
