package com.si.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.l_username);
        password = findViewById(R.id.l_password);
        save = findViewById(R.id.login);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String un = "", pwd = "";
                if (!TextUtils.isEmpty(username.getText().toString())) {
                    un = username.getText().toString();

                    if (!TextUtils.isEmpty(password.getText().toString())) {
                        pwd = password.getText().toString();
                    } else {
                        password.setError("Please enter password");
                        return;
                    }

                } else {
                    username.setError("Please enter username");
                    return;
                }

                if (un.equals("pranish") && pwd.equals("password")) {
                    Toast.makeText(LoginActivity.this, "Welcome " + un, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                    intent.putExtra("username",un);

                    startActivity(intent);
                    username.setText("");
                    password.setText("");
                } else {
                    Toast.makeText(LoginActivity.this, "Login failed." , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
