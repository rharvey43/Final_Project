package ronharvey.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Coupons extends AppCompatActivity implements View.OnClickListener{

    private RadioGroup rG;
    private RadioButton fiveoff;
    private RadioButton twoliter;
    private RadioButton kids;
    private RadioButton tues;
    private String radioChoice;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons);

        user = getIntent().getExtras().getParcelable("loginMain");

        final Button btn_cancel = (Button) findViewById(R.id.bttn_cancel);
        btn_cancel.setOnClickListener(this);
        final Button btn_submit = (Button) findViewById(R.id.bttn_save);
        btn_submit.setOnClickListener(this);
        rG = (RadioGroup) findViewById(R.id.rad_coupon);

        rG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.rad_five_off) {
                    radioChoice ="FIVE_OFF";
                }
                else if(checkedId == R.id.rad_two_liter){
                    radioChoice = "TWO_LITER";
                }
                else if(checkedId == R.id.rad_kids_meal){
                    radioChoice = "KIDS";
                }
                else if(checkedId == R.id.rad_fift_off){
                    radioChoice = "TUES";
                }
            }
        });
        fiveoff = (RadioButton) findViewById(R.id.rad_five_off);
        fiveoff.setEnabled(true);
        twoliter = (RadioButton) findViewById(R.id.rad_two_liter);
        kids=(RadioButton) findViewById(R.id.rad_kids_meal);
        tues=(RadioButton) findViewById(R.id.rad_fift_off);
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bttn_cancel:
                finish();
                break;

            case R.id.bttn_save:

                if (radioChoice.equals("FIVE_OFF")) {
                    Intent intent1 = new Intent(Coupons.this, Menu.class);
                    intent1.putExtra("loginMain", user);
                    intent1.putExtra("coup", radioChoice);
                    startActivity(intent1);
                    }
                else if (radioChoice.equals("TWO_LITER")) {

                    Intent intent1 = new Intent(Coupons.this, Menu.class);
                    intent1.putExtra("loginMain", user);
                    intent1.putExtra("coup", radioChoice);
                    startActivity(intent1);
                }
                else if (radioChoice.equals("KIDS")) {

                    Intent intent1 = new Intent(Coupons.this, Menu.class);
                    intent1.putExtra("loginMain", user);
                    intent1.putExtra("coup", radioChoice);
                    startActivity(intent1);
                }
                else if (radioChoice.equals("TUES")) {

                    Intent intent1 = new Intent(Coupons.this, Menu.class);
                    intent1.putExtra("loginMain", user);
                    intent1.putExtra("coup", radioChoice);
                    startActivity(intent1);
                }

                break;
        }
    }
}
