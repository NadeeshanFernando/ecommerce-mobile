package edu.demo.livedinner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.demo.livedinner.adapter.ResAdapter;
import edu.demo.livedinner.api.Api;
import edu.demo.livedinner.api.service.ReservationService;
import edu.demo.livedinner.model.Reservation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManageReservationActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_reservation);
        this.recyclerView = findViewById(R.id.manage_res_rec);
        Api.getClient().create(ReservationService.class).AllReservation()
                .enqueue(new Callback<List<Reservation>>() {
                    @Override
                    public void onResponse(Call<List<Reservation>> call, Response<List<Reservation>> response) {
                        if (response.code() == 200) {
                            ArrayList<Reservation> res = new ArrayList<>();
                            if (response.code() == 200) {
                                for (Reservation f :
                                        response.body()) {
                                    res.add(f);
                                }
                                ResAdapter adepter = new ResAdapter(getApplicationContext(), activity, res);

                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                                recyclerView.setAdapter(adepter);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Reservation>> call, Throwable t) {

                    }
                });
    }

    public void Back(View view) {
        startActivity(new Intent(ManageReservationActivity.this, NavigationActivity.class));
        finish();
    }
}
