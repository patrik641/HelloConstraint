package com.example.helloconstraint;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
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

        showCount = findViewById(R.id.show_count);
        zeroButton = findViewById(R.id.button_zero);
        countButton = findViewById(R.id.button_count);
    }

    private int count = 0;
    private TextView showCount;
    private Button zeroButton;
    private Button countButton;

// in onCreate, after the ViewCompat block:


    public void showToast(View view) {
        Toast.makeText(this, "Count: " + count, Toast.LENGTH_SHORT).show();
    }

    public void countUp(View view) {
        count++;
        showCount.setText(String.valueOf(count));
        zeroButton.setBackgroundTintList(ColorStateList.valueOf(
                ContextCompat.getColor(this, R.color.colorZeroActive)));

        countButton.setBackgroundTintList( ColorStateList.valueOf(
                ContextCompat.getColor(this, R.color.green))
        );
    }

    public void zero(View view) {
        count = 0;
        showCount.setText(String.valueOf(count));
        zeroButton.setBackgroundTintList(ColorStateList.valueOf(
                ContextCompat.getColor(this, R.color.colorZeroGray)));

        countButton.setBackgroundTintList( ColorStateList.valueOf(
                ContextCompat.getColor(this, R.color.colorPrimary)));
    }
}