package edu.polytech.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity{

    TextView tv;
    ImageButton addTaraeButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        tv = (TextView) findViewById(R.id.textView);
        addTaraeButton = (ImageButton)findViewById(R.id.addMainTarae_btn);
        addTaraeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MaintaraeActivity.class);
                startActivity(intent);
            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_menu1:
                        tv.setText("1");
                        break;
                    case R.id.navigation_menu2:
                        tv.setText("2");
                        break;
                    case R.id.navigation_menu3:
                        tv.setText("3");
                        break;
                    case R.id.navigation_menu4:
                        tv.setText("4");
                        break;
                    case R.id.navigation_menu5:
                        tv.setText("5");
                        Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
    }
}