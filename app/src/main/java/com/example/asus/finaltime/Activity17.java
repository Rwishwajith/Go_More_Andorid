package com.example.asus.finaltime;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class Activity17 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText name,phone,email,people;
    Spinner spin;
    Button insert;
    FirebaseDatabase database;
    DatabaseReference ref;
    WaterRafting user;
    private static final String TAG="Activity17";
    private TextView mDisplayData;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_17);

        name=(EditText)findViewById(R.id.name1);
        phone=(EditText)findViewById(R.id.phone1);
        email=(EditText)findViewById(R.id.email1);
        people=(EditText)findViewById(R.id.people);
        spin=(Spinner) findViewById(R.id.spiner1);
        mDisplayData=(TextView)findViewById(R.id.tvDate);
        insert=(Button)findViewById(R.id.regbtn);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("WaterRafting");
        user=new WaterRafting();

        mDisplayData=(TextView)findViewById(R.id.tvDate);
        mDisplayData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog=new DatePickerDialog(Activity17.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month=month+1;
                Log.d(TAG,"onDateSet: mm/dd/yyy: "+ month +"/" +day+ "/" +year);
                String date=month+"/"+day+"/"+year;
                mDisplayData.setText(date);
            }
        };
        Spinner spinner=findViewById(R.id.spiner1);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.numbers3,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();
    }
    private void getValues(){
        user.setName(name.getText().toString());
        user.setPhone(phone.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPeople(people.getText().toString());
        user.setSelect(spin.getSelectedItem().toString());
        user.setDate(mDisplayData.getText().toString());
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void btnInsert(View view){
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getValues();
                ref.child("User01").setValue(user);
                Toast.makeText(Activity17.this,"DATA INSERT...",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Activity17.this,"Not Insert",Toast.LENGTH_LONG).show();
            }
        });
    }
}
