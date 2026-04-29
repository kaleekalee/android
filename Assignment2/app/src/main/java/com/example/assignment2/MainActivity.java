package com.example.assignment2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login, register;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ✅ Toolbar setup (IMPORTANT for menu)
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginBtn);
        register = findViewById(R.id.registerBtn);

        db = new DatabaseHelper(this);

        // LOGIN
        login.setOnClickListener(v -> {
            if (db.loginUser(
                    username.getText().toString(),
                    password.getText().toString())) {

                startActivity(new Intent(MainActivity.this, ContactsActivity.class));

            } else {
                Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT).show();
            }
        });

        // REGISTER
        register.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
        });
    }

    // ✅ MENU (3 dots)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // ✅ MENU CLICK HANDLING
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_notification) {
            startActivity(new Intent(this, NotificationActivity.class));
        }

        else if (id == R.id.menu_browser) {
            startActivity(new Intent(this, BrowserActivity.class));
        }

        else if (id == R.id.menu_intent) {
            startActivity(new Intent(this, IntentActivity.class));
        }

        else if (id == R.id.menu_sharedpref) {
            startActivity(new Intent(this, SharedPrefActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}