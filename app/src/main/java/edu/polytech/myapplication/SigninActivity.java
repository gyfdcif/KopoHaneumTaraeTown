package edu.polytech.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SigninActivity extends AppCompatActivity {
    Toolbar mToolbar;

    TextInputEditText userid_input, userpw_input;
    Button loginBtn;
    String userid, userpw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mToolbar = findViewById(R.id.Signin_Toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        userid_input = findViewById(R.id.userid_input);
        userpw_input = findViewById(R.id.userpw_input);



        loginBtn = findViewById(R.id.Signin_Login_Button);
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

    @Override
    protected void onStart() {
        super.onStart();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userid = userid_input.getText().toString();
                userpw = userpw_input.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("UserID", userid);

                startActivity(intent);
//                SelectUser su = new SelectUser();
//                su.execute();
            }
        });
    }

    private class SelectUser extends AsyncTask<String, Void, String> {

        String serverUrl = "http://54.180.118.27/tarae/selectuser.php";

        @Override
        protected String doInBackground(String... arg0){

            String result = "";

            try {
                String postData = "USER_ID=" + userid + "&PASSWD=" +  userpw;
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

                while ((line = reader.readLine()) != null){
                    jsonHtml.append(line);
                }

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
        protected void onPostExecute(String result){
            if(result.equals("loginok")){
                Toast.makeText(SigninActivity.this, userid + "님 로그인 되었습니다.", Toast.LENGTH_LONG);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("UserID", userid);

                startActivity(intent);
            } else {
                Toast.makeText(SigninActivity.this, "아이디 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_LONG);
                userid_input.setText("");
                userpw_input.setText("");
                userid = "";
                userpw = "";
            }

        }
    }
}