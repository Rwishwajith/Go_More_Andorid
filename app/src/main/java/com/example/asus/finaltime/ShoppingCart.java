package com.example.asus.finaltime;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import java.math.BigDecimal;

public class ShoppingCart extends AppCompatActivity {
    TextView m_response;
    PayPalConfiguration m_configuration;
    String m_paypalClientId="AamXwPDpaxyffViOM2Hf828v0y7DEH0DDJQLiLl8jAWwm0k9vULNYbX3pwUbm5y91nJ9HBN-v-UKN5rv";
    Intent m_service;
    int m_paypalRequestCode=999;
    Cart m_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        LinearLayout list=(LinearLayout)findViewById(R.id.list);
        m_response=(TextView)findViewById(R.id.response);
        m_configuration=new PayPalConfiguration()
                .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
                .clientId(m_paypalClientId);
        m_service=new Intent(this,PayPalService.class);
        m_service.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,m_configuration);
        startService(m_service);
        m_cart=new Cart();
        Product products[]={
                new Product("Mayura Raksha",109.13),
                new Product("Raksha",426.59),
                new Product("Wall Hanger",64.29),
                new Product("Hand Bag",34.92),
                new Product("Reedware Box",8.73),
                new Product("Hand Bag",43.65),
                new Product("Oxidize Elephant",42.06),
                new Product("Buddha Statue",396.83),
                new Product("Brass Lamp",55.56),
                new Product("Natarajah",89.80),
                new Product("Ratnakuta",56.75),
                new Product("God Ghanesha",79.37),
        };
        for(int i=0;i<products.length;i++){
            Button button=new Button(this);
            button.setText(products[i].getName()+"-"+products[i].getValue()+"$");
            button.setTag(products[i]);
            button.setTextSize(40);
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200,Gravity.CENTER);
            layoutParams.setMargins(20,50,20,50);
            button.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    Button button=(Button) view;
                    Product product=(Product) button.getTag();
                    m_cart.addToCart(product);
                    m_response.setText("Total cart Value= "+String.format("%.2f",m_cart.getValue())+" $");
                }
            });
            list.addView(button);
        }

    }
    void reset(View view){
        m_response.setText("Total cart value=0 $");
        m_cart.empty();
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==m_paypalRequestCode){
            if(requestCode==Activity.RESULT_OK){
                PaymentConfirmation confirmation=data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if(confirmation!=null){
                     String state=confirmation.getProofOfPayment().getState();
                     if(state.equals("approved"))
                         m_response.setText("Payment approved");
                     else
                         m_response.setText("Error in the Payment");
                }
                else
                    m_response.setText("Confirmation is null");
            }
        }

    }
    void pay(View view){
        PayPalPayment cart=new PayPalPayment(new BigDecimal(m_cart.getValue()),"USD","Cart",PayPalPayment.PAYMENT_INTENT_SALE);
        Intent intent=new Intent(this,PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,m_configuration);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT,cart);
        startActivityForResult(intent,m_paypalRequestCode);
    }
    void viewCart(View view){
        Intent intent=new Intent(this,ViewCart.class);
        GlobalApplication.m_cart=m_cart;
        startActivity(intent);
    }
}
