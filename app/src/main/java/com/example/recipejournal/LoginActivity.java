package com.example.recipejournal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    Button button;
    EditText password;
    TextView tv;

    private boolean isPasswordValid(@Nullable Editable text) {
        return text != null && text.length() >= 8;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = (Button)findViewById(R.id.login_button);
        password = (EditText)findViewById(R.id.password_edit_text);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!isPasswordValid(password.getText())){
                    Toast.makeText(getApplicationContext(), "Invalid Password", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                    Intent moveIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(moveIntent);
                }
            }
        });
    }
}
