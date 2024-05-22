package com.example.converter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Convert(View view) {

        // Number Input Reference
        EditText editText = findViewById(R.id.editTextNumber2);

        // Text Label Reference
        TextView textView = findViewById(R.id.textView);

        // Reading the value stored in the Input Field
        String dollar = editText.getText().toString();

        // Checking if 'dollar' is not an empty string
        if(!dollar.equals("")) {
            // Converting dollar to euro
            Float euro = Float.valueOf(dollar) * 0.85f;

            // Displaying the result
            textView.setText(euro.toString());
        } else {
            // Changing the TextView text
            textView.setText(R.string.you_did_not_enter_any_value);
        }

    }
}