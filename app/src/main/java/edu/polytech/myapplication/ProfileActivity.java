package edu.polytech.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.polytech.myapplication.domain.UserInfo;

public class ProfileActivity extends AppCompatActivity {
    private char gender;
    private EditText age;
    private Button btn_send;
    UserInfo userinfo;

    Toolbar mToolbar;
    ImageButton male, female;
    Intent intent;
    TextView addr_txt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);

        mToolbar = findViewById(R.id.Profile_Toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intent = getIntent();
        userinfo = (UserInfo) intent.getExtras().getSerializable("userinfo");
        userinfo.setState("A0101");

        male = findViewById(R.id.male_button);
        female = findViewById(R.id.female_button);
        age = findViewById(R.id.age_txt);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male.setPressed(true);
                female.setPressed(false);
                gender = 'M';
                userinfo.setGender('M');
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female.setPressed(true);
                male.setPressed(false);
                gender = 'F';
                userinfo.setGender('F');
            }
        });
        addr_txt = (TextView)findViewById(R.id.addr_txt);
        btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userinfo.setAge(Integer.parseInt(age.getText().toString()));
                userinfo.setAddr(addr_txt.getText().toString());
                InsertUser insertUser = new InsertUser();
                insertUser.execute(userinfo);
            }
        });
    }

    public void mOnPopupClick(View v){
        Intent intent2 = new Intent(this, AddressActivity.class);
        startActivityForResult(intent2, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("result");
                addr_txt.setText(result);
            }
        }
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

    private class InsertUser extends AsyncTask<UserInfo, String, String> {

        String serverUrl = "http://54.180.118.27/tarae/insertuser.php";

        @Override
        protected String doInBackground(UserInfo... userInfos) {

            String result = "";

            try {
                String postData = "USER_ID=" + userinfo.getUserID() + "&" + "EMAIL=" + userinfo.getEmail() + "&" + "PHONENUM=" + userinfo.getPhoneNumber() + "&" +
                        "PASSWD=" + userinfo.getPassword() + "&" + "GENDER=" + userinfo.getGender() + "&" + "AGE=" + userinfo.getAge() + "&" +
                        "ADDRESS=" + userinfo.getAddr() + "&" + "STATE=" + userinfo.getState();

                URL url = new URL(serverUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");
                conn.setConnectTimeout(5000);
                conn.setDoOutput(true);
                conn.setDoInput(true);

                OutputStream outputStream = conn.getOutputStream();
                outputStream.write(postData.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();

                StringBuilder jsonHtml = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

                String line = null;

                while ((line = reader.readLine()) != null)
                    jsonHtml.append(line);

                reader.close();
                result = jsonHtml.toString();
                conn.disconnect();
            } catch (Exception e) {
                Log.d("PHP", e.toString());
                return null;
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            Toast.makeText(ProfileActivity.this, "정상적으로 등록됨", Toast.LENGTH_SHORT).show();

            Intent intent4 = new Intent(getApplicationContext(), SigninActivity.class);
            startActivity(intent4);
            finish();
        }
    }
}
