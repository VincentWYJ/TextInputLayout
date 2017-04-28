package com.dylan.textinputlayout;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
    private TextInputLayout mTILUsername;
    private EditText mETUsername;
    private TextInputLayout mTILEmail;
    private EditText mETEmail;
    private TextInputLayout mTILPassword;
    private EditText mETPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mTILUsername = (TextInputLayout) findViewById(R.id.til_username);
        mETUsername = (EditText) findViewById(R.id.et_username);
        mTILEmail = (TextInputLayout) findViewById(R.id.til_email);
        mETEmail = (EditText) findViewById(R.id.et_email);
        mTILPassword = (TextInputLayout) findViewById(R.id.til_password);
        mETPassword = (EditText) findViewById(R.id.et_password);

        mETUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 10) {
                    mTILUsername.setErrorEnabled(true);
                    mTILUsername.setError("Username max length is 10.");
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
                if (!EMAIL_PATTERN.matcher(s.toString().trim()).matches()) {
                    mTILEmail.setErrorEnabled(true);
                    mTILEmail.setError("Please input correct email.");
                } else {
                    mTILEmail.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        mETPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 6) {
                    mTILPassword.setErrorEnabled(true);
                    mTILPassword.setError("Password min length is 6.");
                } else {
                    mTILPassword.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}
