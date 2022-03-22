package edu.demo.livedinner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.demo.livedinner.api.Api;
import edu.demo.livedinner.api.service.FoodService;
import edu.demo.livedinner.model.Food;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddFoodActivity extends AppCompatActivity {
    private TextView head;
    private EditText id, name, dec, price, type;
    private Activity activity = this;
    private boolean edit = false;
    private String EditId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        Bundle extras = getIntent().getExtras();
        try {

            edit = (boolean) extras.get("edit");
            EditId = (String) extras.get("id");

        } catch (NullPointerException e) {

        }
        this.head = findViewById(R.id.foodAdHead);
        this.id = findViewById(R.id.foodAdId);
        this.name = findViewById(R.id.foodAdName);
        this.dec = findViewById(R.id.foodAdDec);
        this.price = findViewById(R.id.foodAdPrice);
        this.type = findViewById(R.id.foodAdType);
        if (edit) {
            this.head.setText("Edit Food");
            this.id.setText(EditId);
            this.id.setEnabled(false);
        }
    }

    public void AddFood(View view) {
        if (edit) {
            Api.getClient().create(FoodService.class).UpdateFood(EditId, new Food(Integer.parseInt(EditId), name.getText().toString(), Double.parseDouble(price.getText().toString()), type.getText().toString(), dec.getText().toString(), "available"))
                    .enqueue(new Callback<Food>() {
                        @Override
                        public void onResponse(Call<Food> call, Response<Food> response) {
                            if (response.code() == 200) {
                                Toast.makeText(activity, "Saved .!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(activity, "Have Some Error .!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Food> call, Throwable t) {
                            Toast.makeText(activity, "Have Some Error .!", Toast.LENGTH_SHORT).show();
                        }
                    });
        } else {
            Api.getClient().create(FoodService.class).AddFood(new Food(Integer.parseInt(id.getText().toString()), name.getText().toString(), Double.parseDouble(price.getText().toString()), type.getText().toString(), dec.getText().toString(), "available"))
                    .enqueue(new Callback<Food>() {
                        @Override
                        public void onResponse(Call<Food> call, Response<Food> response) {
                            if (response.code() == 200) {
                                Toast.makeText(AddFoodActivity.this, "Added .!", Toast.LENGTH_SHORT).show();
                                activity.finish();
                                startActivity(new Intent(activity.getApplicationContext(), ManageFoods.class));
                            }
                        }

                        @Override
                        public void onFailure(Call<Food> call, Throwable t) {
                            Toast.makeText(AddFoodActivity.this, "Have Some Errors", Toast.LENGTH_SHORT).show();

                        }
                    });
        }
    }
}
