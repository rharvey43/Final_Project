package ronharvey.final_project;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;


public class Customize extends AppCompatActivity {


    String toppings="";
    String type ="";
    double total_price=0.0;
    double counter=0;
    boolean boo_pepperoni = false;
    boolean boo_pineapple = false;
    boolean boo_peppers = false;
    boolean boo_onions = false;
    User user;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);

        user = getIntent().getExtras().getParcelable("loginM");

        CheckBox pepperoni = (CheckBox)findViewById(R.id.chk_pepperoni);
        pepperoni.setChecked(true);
        counter += 1;
        boo_pepperoni=true;
        CheckBox pineapple = (CheckBox)findViewById(R.id.chk_pineapple);
        pineapple.setChecked(true);
        boo_pineapple=true;
        counter += 1;
        CheckBox peppers = (CheckBox)findViewById(R.id.chk_peppers);
        boo_peppers=true;
        counter += 1;
        peppers.setChecked(true);
        CheckBox onions = (CheckBox)findViewById(R.id.chk_onions);
        onions.setChecked(true);
        counter += 1;
        boo_onions=true;
        final ImageView v= (ImageView) findViewById(R.id.v1);
        final Button submit= (Button) findViewById(R.id.bttn_submit);
        final Button cancel= (Button) findViewById(R.id.bttn_cancel);
        final Button payment= (Button) findViewById(R.id.bttn_payment);

        Intent intent = getIntent();
        type = intent.getStringExtra("PIZZA_TYPE");
        String price = intent.getStringExtra("UNIT_PRICE");
         double unit_p=Double.parseDouble(price);


         if(type.equals("BBQ")) {
             v.setImageResource(R.drawable.bbq);

             unit_p=8.0;


         }

        if(type.equals("CHEESE")) {
            v.setImageResource(R.drawable.cheese);
            unit_p=6.0;
        }

        if(type.equals("MEAT")) {
            v.setImageResource(R.drawable.meat);
            unit_p=8.0;
        }
        if(type.equals("CUSTOM")) {
            v.setImageResource(R.drawable.custom);
            unit_p=4.0;
        }

        pepperoni.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    boo_pepperoni=true;
                    counter+=1;
                }

                else {
                    boo_pepperoni=false;
                    counter-=1;
                }

            }
        });
        pineapple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    boo_pineapple=true;
                    counter+=1;
                }
                else {
                    boo_pineapple=false;
                    counter-=1;
                }

            }
        });
        onions.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                   boo_onions=true;
                    counter+=1;
                }

                else {
                    boo_onions=false;
                    counter-=1;
                }

            }
        });
        peppers.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    boo_peppers=true;
                    counter += 1;
                }

                else {
                    boo_peppers=false;
                    counter-=1;
                }

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (boo_pepperoni == true && boo_onions == true && boo_pineapple == true && boo_peppers == true) {
                    v.setImageResource(R.drawable.all_toppings);
                }

                else if(boo_pepperoni == false && boo_onions == true && boo_pineapple == true && boo_peppers == true) {
                    v.setImageResource(R.drawable.oni_pepper_pine);
                }
                else if (boo_pepperoni == true && boo_onions == false && boo_pineapple == true && boo_peppers == true) {
                    v.setImageResource(R.drawable.pepperoni_pepp_pine);
                }
                else if (boo_pepperoni == true && boo_onions == true && boo_pineapple == false && boo_peppers == true) {
                    v.setImageResource(R.drawable.pepperoni_oni_pepp);
                }
                else if (boo_pepperoni == true && boo_onions == true && boo_pineapple == true && boo_peppers == false) {
                    v.setImageResource(R.drawable.pepperoni_oni_pine);
                }

                else if (boo_pepperoni == true && boo_onions == true && boo_pineapple == false && boo_peppers == false) {
                    v.setImageResource(R.drawable.pepperoni_onion);
                }

                else if (boo_pepperoni == true && boo_onions == false && boo_pineapple == true&& boo_peppers == false) {
                    v.setImageResource(R.drawable.pepperoni_pine);
                }

                else if (boo_pepperoni == true && boo_onions == false && boo_pineapple == false && boo_peppers == true) {
                    v.setImageResource(R.drawable.pepperoni_pepper);
                }

                else if (boo_pepperoni == false && boo_onions == true && boo_pineapple == true && boo_peppers == false) {
                    v.setImageResource(R.drawable.onions_pine);
                }

                else if (boo_pepperoni == false && boo_onions == true && boo_pineapple == false && boo_peppers == true) {
                    v.setImageResource(R.drawable.onion_pepper);
                }

                else if (boo_pepperoni == false && boo_onions == false && boo_pineapple == true && boo_peppers == true) {
                    v.setImageResource(R.drawable.pine_pepper);
                }

                else if (boo_pepperoni == true && boo_onions == false && boo_pineapple == false && boo_peppers == false) {
                    v.setImageResource(R.drawable.pepperoni_only);
                }

                else if (boo_pepperoni == false && boo_onions == true && boo_pineapple == false && boo_peppers == false) {
                    v.setImageResource(R.drawable.onions_only);
                }

                else if (boo_pepperoni == false && boo_onions == false && boo_pineapple == true && boo_peppers == false) {
                    v.setImageResource(R.drawable.pineapple_only);
                }

                else if (boo_pepperoni == false && boo_onions == false && boo_pineapple == false && boo_peppers == true) {
                    v.setImageResource(R.drawable.peppers_only);
                }

                else if (boo_pepperoni == false && boo_onions == false && boo_pineapple == false && boo_peppers == false && type.equals("MEAT")) {
                    v.setImageResource(R.drawable.meat);
                }

                else if (boo_pepperoni == false && boo_onions == false && boo_pineapple == false && boo_peppers == false && type.equals("BBQ")) {
                    v.setImageResource(R.drawable.bbq);
                }

                else if (boo_pepperoni == false && boo_onions == false && boo_pineapple == false && boo_peppers == false && type.equals("CHEESE")) {
                    v.setImageResource(R.drawable.cheese);
                }

                else if (boo_pepperoni == false && boo_onions == false && boo_pineapple == false && boo_peppers == false && type.equals("CUSTOM")) {
                    v.setImageResource(R.drawable.custom);
                }


            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Customize.this,Menu.class);
                startActivity(intent);
            }
        });

        total_price=unit_p + (counter*2.0);

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(Customize.this,Payment.class);
                intent2.putExtra("TOTAL_PRICE",Double.toString(total_price));
                intent2.putExtra("login", user);
                startActivity(intent2);
            }
        });



    }



    }


