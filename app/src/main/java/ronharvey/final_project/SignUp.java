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

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private String Sname = "";
    private String Spass = "";
    private String SpassC = "";
    private String Semail = "";
    private String Sstreet = "";
    EditText name;
    EditText pass;
    EditText passC;
    EditText email;
    EditText street;

    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final Button btn_cancel = (Button) findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(this);
        final Button btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(this);

        name = (EditText) findViewById(R.id.edit_name);
        pass = (EditText) findViewById(R.id.edit_pass);
        passC = (EditText) findViewById(R.id.edit_pass_confirm);
        email = (EditText) findViewById(R.id.edit_email);
        street = (EditText) findViewById(R.id.edit_street);

    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_cancel:

                finish();
                break;
            case R.id.btn_submit:

                Sname = name.getText().toString();
                Spass = pass.getText().toString();
                SpassC = passC.getText().toString();
                Semail = email.getText().toString();
                Sstreet = street.getText().toString();

                if (Sname.equals("") || Spass.equals("") || SpassC.equals("") || Semail.equals("") || Sstreet.equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "A field is empty", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (!Spass.equals(SpassC)) {
                    Toast toast2 = Toast.makeText(getApplicationContext(), "Passwords don't match", Toast.LENGTH_SHORT);
                    toast2.show();

                } else {
                    User user = new User(Sname, Spass, Semail, Sstreet);

                    db.addUser(user);

                    Log.d("Reading: ", "Reading all users..");
                    List<User> users = db.getAllUsers();

                    for (User cn : users) {
                        String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Pass: " + cn.getPassword() + " ,Email: " + cn.getEmail() + " ,Street: " + cn.getStreet();
                        // Writing Contacts to log
                        Log.d("Name: ", log);
                    }
                    Toast toast3 = Toast.makeText(getApplicationContext(), "User added successfully", Toast.LENGTH_SHORT);
                    toast3.show();
                    finish();
                }

                break;
        }
    }
}
