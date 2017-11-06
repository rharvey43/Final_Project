package ronharvey.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity implements View.OnClickListener {

    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button btn_login_cancel = (Button) findViewById(R.id.btn_login_cancel);
        btn_login_cancel.setOnClickListener(this);
        final Button btn_login_signup = (Button) findViewById(R.id.btn_login_signup);
        btn_login_signup.setOnClickListener(this);
        final Button btn_login_submit = (Button) findViewById(R.id.btn_login_submit);
        btn_login_submit.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_login_cancel:

                finish();
                break;

            case R.id.btn_login_signup:

                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
                break;

            case R.id.btn_login_submit:
                
                finish();
                break;
        }
    }
}