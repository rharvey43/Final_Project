package ronharvey.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Payment extends Activity implements View.OnClickListener{

    private EditText cardNum;
    private EditText cvv;
    private RadioGroup rG;
    private RadioButton pickup;
    private RadioButton delivery;
    private String radioChoice;
    private TextView tv;
    private User user;
    private String totalprice;
    private String coupon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //user = getIntent().getExtras().getParcelable("login");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        user = getIntent().getExtras().getParcelable("loginC");
        coupon = getIntent().getExtras().getString("couponC");
        totalprice = getIntent().getExtras().getString("TOTAL_PRICE");
        final Button btn_login_order = (Button) findViewById(R.id.btn_order);
        btn_login_order.setOnClickListener(this);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        cardNum = (EditText) findViewById(R.id.edit_card);
        cvv = (EditText) findViewById(R.id.edit_cvv);
        rG = (RadioGroup) findViewById(R.id.rb_group);
        tv = (TextView) findViewById(R.id.txt_order);
        tv.setText(user.getName() + " " + totalprice);
        rG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.pickup) {
                    radioChoice ="pickup";
                }
                else if(checkedId == R.id.delivery){
                    radioChoice = "delivery";
                }
            }
        });
        pickup = (RadioButton) findViewById(R.id.pickup);
        pickup.setEnabled(true);
        delivery = (RadioButton) findViewById(R.id.delivery);


        List<String> list = new ArrayList<>();
        list.add("Visa");
        list.add("Discover");
        list.add("American Express");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, list);

        spinner.setAdapter(dataAdapter);
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_order:

                if (cardNum.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "No CreditCard entered", Toast.LENGTH_LONG);
                    toast.show();
                }
                else if (cvv.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "No CVV entered", Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    if (radioChoice.equals("delivery")) {
                        tv.setText(user.getName()+"\n" +
                                "Your order total is " + totalprice +  " and being delivered in 15 minutes to: " + user.getStreet() +"\n" +
                                "Email receipt is being sent to " + user.getEmail() +"\n" +
                                "Coupon: " + coupon);
                    }
                    else if (radioChoice.equals("pickup")) {

                        tv.setText(user.getName()+"\n" +
                                "Your order total is " + totalprice +  " and is ready to be picked up in 15 minutes\n" +
                                "Email receipt is being sent to " + user.getEmail() +"\n" +
                                "Coupon: " + coupon);
                    }
                }
                break;
        }
    }

}
