package edu.demo.livedinner;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.demo.livedinner.adapter.EmpAdapter;
import edu.demo.livedinner.api.Api;
import edu.demo.livedinner.api.service.EmployeeService;
import edu.demo.livedinner.model.Employee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManageEmp extends AppCompatActivity {
    private static final String TAG = "EMP";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_emp);
        this.recyclerView = findViewById(R.id.rcyEmp);
        loadEmp();

        Api.getClient().create(EmployeeService.class).getAllEmp().
                enqueue(new Callback<List<Employee>>() {
                    @Override
                    public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                        Log.d(TAG, "onResponse: "+response.code());
                        if (response.code() == 200) {
                            if (response.body() != null) {
                                Log.d(TAG, "onResponse: " + response.body());

                                EmpAdapter adepter = new EmpAdapter(getApplicationContext(), response.body());
                                recyclerView.setAdapter(adepter);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Employee>> call, Throwable t) {
                        Log.d(TAG, "onFailure: "+t.getMessage());
                    }
                });
    }

    public void Back(View view) {
        startActivity(new Intent(ManageEmp.this, NavigationActivity.class));
        finish();
    }

    public void Add(View view) {
    }

    private void loadEmp() {

    }
}
