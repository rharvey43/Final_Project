package ronharvey.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener {


    String pizza_choice ="";
    double unit_price;
    static final int RETURN=150;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

      final Button bttn_meat = (Button) findViewById(R.id.meat);
      bttn_meat.setOnClickListener(this);
      final Button bttn_bbq = (Button) findViewById(R.id.bbq);
        bttn_bbq.setOnClickListener(this);
      final Button bttn_cheese = (Button) findViewById(R.id.cheese6);
        bttn_cheese.setOnClickListener(this);
      final Button bttn_custom = (Button) findViewById(R.id.custom_pizza);
        bttn_custom.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.meat:

                pizza_choice="MEAT";
                unit_price=8.0;
                Intent intent = new Intent(Menu.this, Customize.class);
                intent.putExtra("PIZZA_TYPE",pizza_choice);
                intent.putExtra("UNIT_PRICE",unit_price);
                setResult(RETURN,intent);
                startActivity(intent);
                finish();
                break;


            case R.id.bbq:

                pizza_choice="BBQ";
                unit_price=8.0;
                Intent intent2 = new Intent(Menu.this, Customize.class);
                intent2.putExtra("PIZZA_TYPE",pizza_choice);
                intent2.putExtra("UNIT_PRICE",unit_price);
                setResult(RETURN,intent2);
                startActivity(intent2);
                finish();
                break;

            case R.id.cheese6:

                pizza_choice="CHEESE";
                unit_price=6.0;
                Intent intent3 = new Intent(Menu.this, Customize.class);
                intent3.putExtra("PIZZA_TYPE",pizza_choice);
                intent3.putExtra("UNIT_PRICE",unit_price);
                setResult(RETURN,intent3);
                startActivity(intent3);
                finish();
                break;

            case R.id.custom_pizza:

                pizza_choice="CUSTOM";
                unit_price=4.0;
                Intent intent4 = new Intent(Menu.this, Customize.class);
                intent4.putExtra("PIZZA_TYPE",pizza_choice);
                intent4.putExtra("UNIT_PRICE",unit_price);
                setResult(RETURN,intent4);
                startActivity(intent4);
                finish();
                break;


        }

    }


}
