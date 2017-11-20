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
    double topping_price=0.0;
    int counter=0;
    boolean boo_pepperoni = false;
    boolean boo_pineapple = false;
    boolean boo_peppers = false;
    boolean boo_onions = false;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);

        CheckBox pepperoni = (CheckBox)findViewById(R.id.chk_pepperoni);
        CheckBox pineapple = (CheckBox)findViewById(R.id.chk_pineapple);
        CheckBox peppers = (CheckBox)findViewById(R.id.chk_peppers);
        CheckBox onions = (CheckBox)findViewById(R.id.chk_onions);
        final ImageView v= (ImageView) findViewById(R.id.v1);
        final Button submit= (Button) findViewById(R.id.bttn_submit);

        Intent intent = getIntent();
        String type = intent.getStringExtra("PIZZA_TYPE");
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
                    v.setImageResource(R.drawable.meat);
                }
                else if (boo_pepperoni == true && boo_onions == false && boo_pineapple == true && boo_peppers == true) {
                    v.setImageResource(R.drawable.bbq);
                }
                else if (boo_pepperoni == true && boo_onions == true && boo_pineapple == false && boo_peppers == true) {
                    v.setImageResource(R.drawable.cheese);
                }
                else if (boo_pepperoni == true && boo_onions == true && boo_pineapple == true && boo_peppers == false) {
                    v.setImageResource(R.drawable.meat);
                }

                //if(boo_pepperoni==true) v.setImageResource(R.drawable.meat);
                //if(boo_onions==true) {v.setImageResource(R.drawable.cheese);}
                //if(boo_pineapple==true) {v.setImageResource(R.drawable.cheese);}
                //if(boo_peppers==true) {v.setImageResource(R.drawable.bbq);}
                //if(boo_pepperoni==true && boo_onions==true  ) v.setImageResource(R.drawable.bbq);
            }
        });



    }



    }


