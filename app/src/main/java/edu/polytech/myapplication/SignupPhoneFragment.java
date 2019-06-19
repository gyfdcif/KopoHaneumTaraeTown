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

public class SignupPhoneFragment extends Fragment {

    View view;
    TextInputEditText phone_id;
    ImageButton nextButton;

    public static SignupPhoneFragment newInstance() {
        Bundle args = new Bundle();
        SignupPhoneFragment fragment = new SignupPhoneFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_signup_phone, container, false);
        phone_id = (TextInputEditText) view.findViewById(R.id.p_id);
        nextButton = (ImageButton) view.findViewById(R.id.pnext_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RegisterActivity.class);
                UserInfo userInfo = new UserInfo();
                userInfo.setEmail("");
                userInfo.setUserID(phone_id.getText().toString());
                userInfo.setPhoneNumber(phone_id.getText().toString());

                intent.putExtra("userinfo", userInfo);

                startActivity(intent);
            }
        });

        return view;
    }
}
