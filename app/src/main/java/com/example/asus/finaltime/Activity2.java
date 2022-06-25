package com.example.asus.finaltime;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;

import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;
import ir.mirrajabi.searchdialog.core.Searchable;

public class Activity2 extends AppCompatActivity {
    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3, floatingActionButton4, floatingActionButton5, floatingActionButton6;
    ViewFlipper v_flipper;
    private Button button;
    private Button button1,button2,button3,button4,button5,button6,button7;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
          button1=(Button) findViewById(R.id.btn4);
        button4=(Button) findViewById(R.id.btn6);
        button5=(Button) findViewById(R.id.btn3);
        button6=(Button) findViewById(R.id.btn1);
        //button7=(Button) findViewById(R.id.log);
          button1.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  openActivity2();
              }
          });
//        button7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openActivity9();
//            }
//        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity8();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity6();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity7();
            }
        });
        button2=(Button) findViewById(R.id.btn5);
        button3=(Button) findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
//        button1=(Button) findViewById(R.id.btn4);
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View V){
//                openActivity2();
//            }
//        });
//        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.social_floating_menu);
//        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.floating_facebook);
//        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.floating_twitter);
//
//        floatingActionButton4 = (FloatingActionButton) findViewById(R.id.floating_google_plus);
//        floatingActionButton5 = (FloatingActionButton) findViewById(R.id.floating_instagram);
//
//
//        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                //TODO something when floating action menu first item clicked
//                Intent facebookIntent = getOpenFacebookIntent(Activity2.this);
//                startActivity(facebookIntent);
//
//            }
//        });
//        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                //TODO something when floating action menu second item clicked
//                Intent twitterIntent = getOpenTwitterIntent(Activity2.this);
//                startActivity(twitterIntent);
//
//            }
//        });
//
//
//        floatingActionButton4.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                //TODO something when floating action menu first item clicked
//                Intent googleplusIntent = getOpenGPlusIntent(Activity2.this);
//                startActivity(googleplusIntent);
//            }
//        });
//        floatingActionButton5.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                //TODO something when floating action menu second item clicked
//                Intent instagramIntent = getOpenInstagramIntent(Activity2.this);
//                startActivity(instagramIntent);
//            }
//        });





        findViewById(R.id.btnSearch).setOnClickListener(new View.OnClickListener(){
            @Override
           public void onClick(View v) {
                new SimpleSearchDialogCompat(Activity2.this, "Search...", "What are you loking for...?", null, initData(), new SearchResultListener<Searchable>() {
                   @Override
                   public void onSelected(BaseSearchDialogCompat baseSearchDialogCompat, Searchable searchable, int i) {
                        Toast.makeText(Activity2.this,""+searchable.getTitle(),Toast.LENGTH_SHORT).show();
                       baseSearchDialogCompat.dismiss();
                    }
               }).show();
          }
        });



        int images[]={R.drawable.ab,R.drawable.n,R.drawable.o};
        v_flipper=findViewById(R.id.v_flipper);
        for(int image:images){
            flipperImages(image);
        }
//        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer);
//        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
//        mDrawerLayout.addDrawerListener(mToggle);
//        mToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public  void flipperImages(int image){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000);
        v_flipper.setAutoStart(true);


        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setInAnimation(this,android.R.anim.slide_out_right);
    }
    private ArrayList<Searchmodel> initData(){
        ArrayList<Searchmodel> items=new ArrayList<>();
        items.add(new Searchmodel("yala"));
        items.add(new Searchmodel("Wilpatu"));
        items.add(new Searchmodel("Kandy"));
        items.add(new Searchmodel("Matala"));
        items.add(new Searchmodel("Mirisa"));
        items.add(new Searchmodel("Wasgamuwa"));
        items.add(new Searchmodel("Sigiri"));
        return items;
    }
    public void openActivity2(){
        Intent intent=new Intent(this,Activity4.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent=new Intent(this,Activity6.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent=new Intent(this,MapsActivity.class);
        startActivity(intent);
    }
    public void openActivity7(){
        Intent intent=new Intent(this,Activity13.class);
        startActivity(intent);
    }
    public void openActivity6(){
        Intent intent=new Intent(this,Activity14.class);
        startActivity(intent);
    }
    public void openActivity8(){
        Intent intent=new Intent(this,Activity15.class);
        startActivity(intent);
    }
//    public void openActivity9(){
//        Intent intent=new Intent(this,MainActivity.class);
//        startActivity(intent);
//    }
}
//    public static Intent getOpenFacebookIntent(Context context) {
//
//        try {
//            context.getPackageManager()
//                    .getPackageInfo("com.facebook.katana", 0); //Checks if FB is even installed.
//            return new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("fb://page/376227335860239")); //Trys to make intent with FB's URI
//        } catch (Exception e) {
//            return new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("https://www.facebook.com/karthikofficialpage")); //catches and opens a url to the desired page
//        }
//    }
//
//    public static Intent getOpenTwitterIntent(Context context) {
//
//        try {
//            context.getPackageManager()
//                    .getPackageInfo("com.twitter.android", 0); //Checks if Twitter is even installed.
//            return new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("https://twitter.com/drkarthiik")); //Trys to make intent with Twitter's's URI
//        } catch (Exception e) {
//            return new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("https://twitter.com/drkarthiik")); //catches and opens a url to the desired page
//        }
//    }
//
//    public static Intent getOpenLinkdinIntent(Context context) {
//
//        try {
//            context.getPackageManager()
//                    .getPackageInfo("com.linkedin.android", 0); //Checks if Linkdin is even installed.
//            return new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("https://www.linkedin.com/in/karthikm128")); //Trys to make intent with Linkdin's URI
//        } catch (Exception e) {
//            return new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("https://www.linkedin.com/in/karthikm128")); //catches and opens a url to the desired page
//        }
//    }
//
//    public static Intent getOpenGPlusIntent(Context context) {
//
//        try {
//            context.getPackageManager()
//                    .getPackageInfo("com.google.android.apps.plus", 0); //Checks if G+ is even installed.
//            return new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("https://plus.google.com/u/0/+KarthikM128")); //Trys to make intent with G+'s URI
//        } catch (Exception e) {
//            return new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("https://plus.google.com/u/0/+KarthikM128")); //catches and opens a url to the desired page
//        }
//    }
//
//    public static Intent getOpenInstagramIntent(Context context) {
//
//        try {
//            context.getPackageManager()
//                    .getPackageInfo("com.instagram.android", 0); //Checks if Instagram is even installed.
//            return new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("https://www.instagram.com/accounts/login/")); //Trys to make intent with Instagram's URI
//        } catch (Exception e) {
//            return new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("https://www.instagram.com/accounts/login/")); //catches and opens a url to the desired page
//        }
//    }
//
//    public static Intent getOpenYouTubeIntent(Context context) {
//
//        try {
//            context.getPackageManager()
//                    .getPackageInfo("com.google.android.youtube", 0); //Checks if YT is even installed.
//            return new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("https://www.youtube.com/karthikm128")); //Trys to make intent with YT's URI
//        } catch (Exception e) {
//            return new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("https://www.youtube.com/karthikm128")); //catches and opens a url to the desired page
//        }
//
//    }
    //    public void openActivity5(){
//        Intent intent=new Intent(this,Activity4.class);
//        startActivity(intent);
//    }
//    public boolean onOptionsItemSelected(MenuItem item){
//        if(mToggle.onOptionsItemSelected(item)){
//            return true;
//        }
//        return  super.onOptionsItemSelected(item);
//    }}
