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
    private User user = getIntent().getExtras().getParcelable("login");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        final Button btn_login_order = (Button) findViewById(R.id.btn_order);
        btn_login_order.setOnClickListener(this);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        rG = (RadioGroup) findViewById(R.id.rb_group);
        tv = (TextView) findViewById(R.id.txt_order);
        rG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.pickup) {
                    radioChoice ="pickup";
                }
                else {
                    radioChoice = "delivery";
                }
            }
        });
        pickup = (RadioButton) findViewById(R.id.pickup);
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
                tv.setText(user.getName() + " your order is::w");
                break;
        }
    }

}