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

import com.google.android.material.textfield.TextInputEditText;

import edu.polytech.myapplication.domain.UserInfo;

public class RegisterActivity extends AppCompatActivity {
    final static String TAG = "RegisterActivity";
    String email_id;
    String phone_id;
    Toolbar mToolbar;

    TextInputEditText passwd;
    ImageButton nextActivity;
    UserInfo userinfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mToolbar = findViewById(R.id.Register_Toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        userinfo = (UserInfo) intent.getExtras().getSerializable("userinfo");

        passwd = findViewById(R.id.pass_wd);
        nextActivity = findViewById(R.id.Register_Next_Button);

        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                userinfo.setPassword(passwd.getText().toString());
                intent.putExtra("userinfo", userinfo);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}

