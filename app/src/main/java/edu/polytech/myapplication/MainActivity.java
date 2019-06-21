package edu.polytech.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity{
    Toolbar mToolbar;
    ImageButton addTaraeButton;

    ListActivity fragment1;
    StoredActivity fragment2;
    TopActivity fragment3;
    ARActivity fragment4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.Signup_Toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        fragment1 = new ListActivity();
        fragment2 = new StoredActivity();
        fragment3 = new TopActivity();
        fragment4 = new ARActivity();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
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
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment1).commit();
                        break;
                    case R.id.navigation_menu2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment2).commit();
                        break;
                    case R.id.navigation_menu3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment3).commit();
                        break;
                    case R.id.navigation_menu4:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment4).commit();
                        break;
                    case R.id.navigation_menu5:
                        Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
    }
}