package edu.demo.livedinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.demo.livedinner.api.Api;
import edu.demo.livedinner.api.service.ReservationService;
import edu.demo.livedinner.model.Reservation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReservationActivity extends AppCompatActivity {
    private EditText date, time, nop, name, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        this.date = findViewById(R.id.RDate);
        this.time = findViewById(R.id.RTime);
        this.nop = findViewById(R.id.RgustCount);
        this.name = findViewById(R.id.gustName);
        this.email = findViewById(R.id.gustEmail);
        this.phone = findViewById(R.id.gustPhoneNo);
    }

    public void Back(View view) {
        startActivity(new Intent(ReservationActivity.this, NavigationActivity.class));
        finish();
    }

    public void Save(View view) {
        Api.getClient().create(ReservationService.class).AddReservation(new Reservation(0,name.getText().toString(),email.getText().toString(),phone.getText().toString(),Integer.parseInt(nop.getText().toString()),date.getText().toString()
        ,time.getText().toString()))
                .enqueue(new Callback<Reservation>() {
                    @Override
                    public void onResponse(Call<Reservation> call, Response<Reservation> response) {
                        if (response.code() == 200) {
                            Toast.makeText(ReservationActivity.this, "Added .!", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(ReservationActivity.this, "Check Details", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Reservation> call, Throwable t) {
                        Toast.makeText(ReservationActivity.this, "Have a Some error", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
