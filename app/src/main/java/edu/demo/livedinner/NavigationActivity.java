package edu.demo.livedinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import edu.demo.livedinner.model.Reservation;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
    }


    public void ReservationButton(View view) {
        startActivity(new Intent(NavigationActivity.this, ReservationActivity.class));
    }

    public void ManageReservationButton(View view) {
        startActivity(new Intent(NavigationActivity.this, ManageReservationActivity.class));
    }


    public void ManageEmp(View view) {
        startActivity(new Intent(NavigationActivity.this, ManageEmp.class));

    }

    public void ManageFood(View view) {
        startActivity(new Intent(NavigationActivity.this, ManageFoods.class));
    }

    public void AddInq(View view) {
        startActivity(new Intent(NavigationActivity.this, addInquiryActivity.class));
    }

    public void ManageInq(View view) {
        startActivity(new Intent(NavigationActivity.this, InquiryManagementActivity.class));
    }
}
