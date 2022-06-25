package com.example.asus.finaltime;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Activity3 extends AppCompatActivity {
    private EditText et_name,et_email,et_phone,et_password,et_cpassword;
    private String name,email,phone,password,cpassword;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private Button buttonRegister;
    Button regbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        et_name=(EditText) findViewById(R.id.name);
        et_email=(EditText) findViewById(R.id.email);
        et_phone=(EditText) findViewById(R.id.phone);
        et_password=(EditText) findViewById(R.id.passworde);
        et_cpassword=(EditText) findViewById(R.id.cpassword);
        regbtn=(Button) findViewById(R.id.regbtn);
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
       });
        //buttonRegister.setOnClickListener(this);
    }
//    private void registerUser(){
//        String name=et_name.getText().toString().trim();
//        String password=et_password.getText().toString().trim();
//
//        String email=et_email.getText().toString().trim();
//        String phone=et_phone.getText().toString().trim();
//
//        String cpassword=et_cpassword.getText().toString().trim();
//        if(TextUtils.isEmpty(name)){
//            Toast.makeText(this,"Please Enter Name",Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if(TextUtils.isEmpty(password)){
//            Toast.makeText(this,"Please Enter Password",Toast.LENGTH_SHORT).show();
//            return;
//        }
//        progressDialog.setMessage("Registering User...");
//        progressDialog.show();
//        firebaseAuth.createUserWithEmailAndPassword(name,password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//                            Toast.makeText(Activity3.this,"Register Successfully",Toast.LENGTH_SHORT).show();
//
//                        }else{
//                            Toast.makeText(Activity3.this,"Could not register",Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
  //  }

//    @Override
//    public void onClick(View v) {
//        if(v==buttonRegister){
//            registerUser();
//        }
//
//    }
    public void register(){
        intialize();
        if(!validate()){
            Toast.makeText(this,"Singup has Failed",Toast.LENGTH_SHORT).show();
}
        else{
            onSignupSuccess();
        }

    }
    public void onSignupSuccess(){
        progressDialog.setMessage("Registering User...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Activity3.this,"Register Successfully",Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(Activity3.this,"Could not register",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

}
    public boolean validate(){
        boolean valid=true;
        if(password.isEmpty() || password.length()>32){
            et_name.setError("Please Enter valid password");
            valid=false;
        }
        if(email.isEmpty()){
            et_email.setError("Please Enter valid Email Address");
            valid=false;
        }
        return valid;

    }

    public void intialize(){
        name=et_name.getText().toString().trim();
        email=et_email.getText().toString().trim();
        phone=et_phone.getText().toString().trim();
        password=et_password.getText().toString().trim();
        cpassword=et_cpassword.getText().toString().trim();
    }


}
