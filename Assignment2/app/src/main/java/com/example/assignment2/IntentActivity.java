package com.example.assignment2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IntentActivity extends AppCompatActivity {

    EditText url;
    Button implicitBtn, explicitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        url = findViewById(R.id.url);
        implicitBtn = findViewById(R.id.implicitBtn);
        explicitBtn = findViewById(R.id.explicitBtn);

        // IMPLICIT → default browser
        implicitBtn.setOnClickListener(v -> {
            String link = url.getText().toString();

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(link));

            startActivity(intent);
        });

        // EXPLICIT → open inside app
        explicitBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, BrowserActivity.class);
            startActivity(intent);
        });
    }
}