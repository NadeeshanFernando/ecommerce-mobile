package edu.demo.livedinner.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.demo.livedinner.AddFoodActivity;
import edu.demo.livedinner.ManageFoods;
import edu.demo.livedinner.R;
import edu.demo.livedinner.api.Api;
import edu.demo.livedinner.api.service.FoodService;
import edu.demo.livedinner.model.Food;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private Context context;
    private List<Food> FoodArrayList;
    private Activity activity;

    public FoodAdapter(Context context, Activity activity, List<Food> FoodArrayList) {
        this.context = context;
        this.FoodArrayList = FoodArrayList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder holder, int position) {
        Food Food = FoodArrayList.get(position);
        holder.name.setText(Food.getName());
        holder.dec.setText(Food.getDescription());
        holder.foodItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edu.demo.livedinner.model.Food food = FoodArrayList.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("id", food.getId() + "");
                bundle.putBoolean("edit", true);

                Intent intent = new Intent(activity, AddFoodActivity.class);
                intent.putExtras(bundle);
                intent.putExtra("id", food.getId() + "");
                intent.putExtra("edit", true);

                activity.finish();
                context.startActivity(intent);
            }
        });
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Api.getClient().create(FoodService.class).DeleteFood(Food.getId() + "")
                        .enqueue(new Callback<Object>() {
                            @Override
                            public void onResponse(Call<Object> call, Response<Object> response) {
                                Log.d("FA", "onResponse: " + response);
                                if (response.code() == 200) {
                                    Toast.makeText(context, "Deleted ", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(context, "Have Some Error", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Object> call, Throwable t) {
                                Toast.makeText(context, "Deleted ", Toast.LENGTH_SHORT).show();
                                activity.finish();
                                context.startActivity(new Intent(context, ManageFoods.class));
                            }
                        });
            }
        });
    }

    @Override
    public int getItemCount() {
        return FoodArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, dec;
        ImageView btnDelete;
        ConstraintLayout foodItem;

        ViewHolder(View itemView) {
            super(itemView);
            //
            this.foodItem = itemView.findViewById(R.id.foodItem);
            this.btnDelete = itemView.findViewById(R.id.itemDelete);
            this.name = itemView.findViewById(R.id.FoodName);
            this.dec = itemView.findViewById(R.id.FoodDec);

        }

    }

}
