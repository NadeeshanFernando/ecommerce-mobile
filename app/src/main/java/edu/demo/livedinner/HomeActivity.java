package edu.demo.livedinner;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void Next(View view) {

        startActivity(new Intent(HomeActivity.this, NavigationActivity.class));
        finish();
    }

    public void Call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+94 72 66 1818 5"));
        startActivity(intent);
    }

    public void Mail(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "anton@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Live Dinner");
        startActivity(intent);
    }

    public void Location(View view) {
        String location = "https://www.google.com/maps/search/45+Mankuliya+Rd,+Negombo/@7.2024991,79.8304079,14z";
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse(location));
        startActivity(intent);
    }
}
