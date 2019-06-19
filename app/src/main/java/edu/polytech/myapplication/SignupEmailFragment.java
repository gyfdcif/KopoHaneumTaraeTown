package edu.polytech.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import edu.polytech.myapplication.domain.UserInfo;

public class SignupEmailFragment extends Fragment {

    View view;
    TextInputEditText email_id;
    ImageButton nextButton;


    public static SignupEmailFragment newInstance() {
        Bundle args = new Bundle();
        SignupEmailFragment fragment = new SignupEmailFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_signup_email, container, false);
        email_id = (TextInputEditText) view.findViewById(R.id.e_id);
        nextButton = (ImageButton) view.findViewById(R.id.enext_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RegisterActivity.class);
                UserInfo userInfo = new UserInfo();
                userInfo.setUserID(email_id.getText().toString());
                userInfo.setEmail(email_id.getText().toString());
                userInfo.setPhoneNumber("");

                intent.putExtra("userinfo", userInfo);

                startActivity(intent);
            }
        });

        return view;
    }

}
