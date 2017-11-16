package ronharvey.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Login extends AppCompatActivity implements View.OnClickListener {

    DatabaseHandler db = new DatabaseHandler(this);
    private static final int RETURN = 200;

    EditText e_name;
    EditText e_pass;
    private User user;

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
        final Button btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(this);

        e_name = (EditText) findViewById(R.id.edit_login_name);
        e_pass = (EditText) findViewById(R.id.edit_login_pass);
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
                user = db.getUser(e_name.getText().toString(), e_pass.getText().toString());


                if (user == null) {
                    Toast toast3 = Toast.makeText(getApplicationContext(), "Username/password wrong", Toast.LENGTH_LONG);
                    toast3.show();
                    e_name.setText("");
                    e_pass.setText("");

                    Log.d("Reading: ", "Reading all users..");
                    List<User> users = db.getAllUsers();

                    for (User cn : users) {
                        String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Pass: " + cn.getPassword() + " ,Email: " + cn.getEmail() + " ,Street: " + cn.getStreet();
                        // Writing Contacts to log
                        Log.d("Name: ", log);
                    }
                } else {
                    String log = "Id: " + user.getID() + " ,Name: " + user.getName() + " ,Pass: " + user.getPassword() + " ,Email: " + user.getEmail() + " ,Street: " + user.getStreet();
                    Log.d("User ", log);

                    Intent i = new Intent(Login.this, MainActivity.class);
                    i.putExtra("user", user);
                    setResult(RETURN, i);
                    finish();
                }

                break;
            case R.id.btn_delete:

                user = db.getUser(e_name.getText().toString(), e_pass.getText().toString());
                if (user != null) {
                    Toast toast = Toast.makeText(getApplicationContext(), "User: " + user.getName() + " deleted", Toast.LENGTH_LONG);
                    toast.show();
                    db.deleteUser(user);
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Username/password wrong", Toast.LENGTH_LONG);
                    toast.show();
                    e_name.setText("");
                    e_pass.setText("");
                }
                break;
        }
    }
}