package com.example.assignment2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SharedPrefActivity extends AppCompatActivity {

    EditText name, email, password;
    Button saveBtn, showBtn;
    TextView result;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        saveBtn = findViewById(R.id.saveBtn);
        showBtn = findViewById(R.id.showBtn);
        result = findViewById(R.id.result);

        // ✅ create shared preferences file
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);

        // SAVE DATA
        saveBtn.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("name", name.getText().toString());
            editor.putString("email", email.getText().toString());
            editor.putString("password", password.getText().toString());

            editor.apply(); // IMPORTANT

            result.setText("Data Saved Successfully");
        });

        // SHOW DATA
        showBtn.setOnClickListener(v -> {
            String n = sharedPreferences.getString("name", "");
            String e = sharedPreferences.getString("email", "");
            String p = sharedPreferences.getString("password", "");

            result.setText("Name: " + n + "\nEmail: " + e + "\nPassword: " + p);
        });
    }
}