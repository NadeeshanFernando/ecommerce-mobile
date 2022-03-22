package edu.demo.livedinner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.demo.livedinner.adapter.FoodAdapter;
import edu.demo.livedinner.api.Api;
import edu.demo.livedinner.api.service.FoodService;
import edu.demo.livedinner.model.Food;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManageFoods extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String TAG = "FOOD";
    private Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_foods);
        this.recyclerView = findViewById(R.id.manage_food_rec);
        Api.getClient().create(FoodService.class).AllFood()
                .enqueue(new Callback<List<Food>>() {
                    @Override
                    public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                        ArrayList<Food> foods = new ArrayList<>();
                        if (response.code() == 200) {
                            for (Food f :
                                    response.body()) {
                                foods.add(f);
                            }
                            FoodAdapter adepter = new FoodAdapter(getApplicationContext(), activity, foods);

                            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            recyclerView.setAdapter(adepter);

                        }
                    }

                    @Override
                    public void onFailure(Call<List<Food>> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }

    public void Back(View view) {
        startActivity(new Intent(ManageFoods.this, NavigationActivity.class));
        finish();
    }

    public void Add(View view) {
        startActivity(new Intent(ManageFoods.this, AddFoodActivity.class));
    }
}
