package ronharvey.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn_location = (Button) findViewById(R.id.btn_location);
        btn_location.setOnClickListener(this);
    }

    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.btn_location:

                Intent intent = new Intent(MainActivity.this, Location.class);
                startActivity(intent);
                break;
        }
    }
}
