package ronharvey.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseHandler db = new DatabaseHandler(this);
    private User user;
    private static final int CODE = 100;
    private static final int RETURN = 200;
    private TextView tv;
    private String coupon = "No Coupon";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //view hooks
        final Button btn_location = (Button) findViewById(R.id.btn_location);
        btn_location.setOnClickListener(this);
        final Button btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        final Button btn_menu = (Button) findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(this);
        final Button btn_coupons = (Button) findViewById(R.id.btn_coupons);
        btn_coupons.setOnClickListener(this);
        final Button btn_logout = (Button) findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(this);


        ImageView splash = (ImageView) findViewById(R.id.img_welcome_splash);
        splash.setImageResource(R.drawable.welcome_splash);

    }

    public void onClick(View v) {

        switch (v.getId()) {
            //sends user to location page
            case R.id.btn_location:

                Intent intent = new Intent(MainActivity.this, Location.class);
                startActivity(intent);
                break;
            //sends user to login page
            case R.id.btn_login:

                Intent intent2 = new Intent(MainActivity.this, Login.class);
                startActivityForResult(intent2, CODE);
                break;
            //sends user to menu page if user is logged in, else gives error toast
            case R.id.btn_menu:

                if (user == null){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please login", Toast.LENGTH_LONG);
                    toast.show();
                    break;
                }
                Intent intent3 = new Intent(MainActivity.this, ronharvey.final_project.Menu.class);
                intent3.putExtra("loginMain", user);
                intent3.putExtra("coup", coupon);
                startActivity(intent3);
                break;
            //sends user to coupon page if user is logged in, else gives error toast
            case R.id.btn_coupons:

                if (user == null){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please login", Toast.LENGTH_LONG);
                    toast.show();
                    break;
                }
                Intent intent4 = new Intent(MainActivity.this, Coupons.class);
                intent4.putExtra("loginMain", user);
                startActivity(intent4);
                break;
            //logs out current user by setting user to null
            case R.id.btn_logout:
                if (user != null) {
                    Toast toast3 = Toast.makeText(getApplicationContext(), user.getName() + " logged out", Toast.LENGTH_LONG);
                    toast3.show();
                    user = null;
                    tv.setText("Not logged in");
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "No one logged in", Toast.LENGTH_LONG);
                    toast.show();
                }
                break;
        }
    }
    //main is looking for the user object result from login
    @Override
    protected void onActivityResult(int RequestCode, int resultCode, Intent data) {

        tv = (TextView) findViewById(R.id.txt_user);

        if (RequestCode == CODE && resultCode == RETURN) {
            user = data.getParcelableExtra("user");
        }

        if (user != null)
        {

            tv.setText("Welcome " + user.getName());
        }
        else {
            tv.setText("Not Logged In");
        }
    }
}
