package edu.demo.livedinner;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.time();
    }

    private void time() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                int success;
                finish();
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }

        }, 5000);
        // 5 sec
    }
}
