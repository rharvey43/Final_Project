package ronharvey.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn_location = (Button) findViewById(R.id.btn_location);
        btn_location.setOnClickListener(this);
        final Button btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        final Button btn_menu = (Button) findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(this);
        final Button btn_coupons = (Button) findViewById(R.id.btn_coupons);
        btn_coupons.setOnClickListener(this);

        ImageView splash = (ImageView) findViewById(R.id.img_welcome_splash);
        splash.setImageResource(R.drawable.welcome_splash);

    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_location:

                Intent intent = new Intent(MainActivity.this, Location.class);
                startActivity(intent);
                break;

            case R.id.btn_login:

                Intent intent2 = new Intent(MainActivity.this, Login.class);
                startActivity(intent2);
                break;

            case R.id.btn_menu:

                Intent intent3 = new Intent(MainActivity.this, ronharvey.final_project.Menu.class);
                startActivity(intent3);
                break;

            case R.id.btn_coupons:

                Intent intent4 = new Intent(MainActivity.this, Coupons.class);
                startActivity(intent4);
                break;
        }
    }
}
