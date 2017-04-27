package com.dylan.textinputlayout;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout mTILUsername;
    private TextInputLayout mTILEmail;
    private EditText mETUsername;
    private EditText mETEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mTILUsername = (TextInputLayout) findViewById(R.id.til_username);
        mTILEmail = (TextInputLayout) findViewById(R.id.til_email);
        mETUsername = (EditText) findViewById(R.id.et_username);
        mETEmail = (EditText) findViewById(R.id.et_email);

        mETUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 5) {
                    mTILUsername.setErrorEnabled(true);
                    mTILUsername.setError("Max length is 5.");
                } else {
                    mTILUsername.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        mETEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 5) {
                    mTILEmail.setErrorEnabled(true);
                    mTILEmail.setError("Max length is 5.");
                } else {
                    mTILEmail.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}
