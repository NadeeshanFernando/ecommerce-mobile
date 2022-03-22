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

import edu.demo.livedinner.adapter.InqAdapter;
import edu.demo.livedinner.api.Api;
import edu.demo.livedinner.api.service.InquiryService;
import edu.demo.livedinner.model.Inquiry;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InquiryManagementActivity extends AppCompatActivity {

    private Activity activity = this;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry_management);
        this.recyclerView = findViewById(R.id.manage_inq_rec);
        Api.getClient().create(InquiryService.class).AllInquiry()
                .enqueue(new Callback<List<Inquiry>>() {
                    @Override
                    public void onResponse(Call<List<Inquiry>> call, Response<List<Inquiry>> response) {
                        if (response.code() == 200) {
                            ArrayList<Inquiry> res = new ArrayList<>();
                            if (response.code() == 200) {
                                for (Inquiry f :
                                        response.body()) {
                                    res.add(f);
                                }
                                InqAdapter adepter = new InqAdapter(getApplicationContext(), activity, res);

                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                                recyclerView.setAdapter(adepter);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Inquiry>> call, Throwable t) {

                    }
                });
    }

    public void Back(View view) {
        startActivity(new Intent(InquiryManagementActivity.this, NavigationActivity.class));
        finish();
    }

    public void Add(View view) {
startActivity(new Intent(InquiryManagementActivity.this,addInquiryActivity.class));
    }
}
