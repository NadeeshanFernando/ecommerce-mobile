package edu.demo.livedinner.adapter;

import android.app.Activity;
import android.content.Context;
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

import edu.demo.livedinner.R;
import edu.demo.livedinner.api.Api;
import edu.demo.livedinner.api.service.ReservationService;
import edu.demo.livedinner.model.Reservation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResAdapter extends RecyclerView.Adapter<ResAdapter.ViewHolder> {
    private Context context;
    private List<Reservation> ReservationArrayList;
    private Activity activity;

    public ResAdapter(Context context, Activity activity, List<Reservation> ReservationArrayList) {
        this.context = context;
        this.ReservationArrayList = ReservationArrayList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ResAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_res, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ResAdapter.ViewHolder holder, int position) {
        Reservation reservation = ReservationArrayList.get(position);
        holder.firstName.setText(reservation.getFirstname());
        holder.email.setText(reservation.getEmail());
        holder.phoneNo.setText(reservation.getPhone());
        holder.restCount.setText(reservation.getNumguest() + "");
        holder.dateAndTime.setText(reservation.getDate() + " " + reservation.getTime());
        holder.itemResDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Api.getClient().create(ReservationService.class).DeleteRes(reservation.getId() + "")
                        .enqueue(new Callback<Object>() {
                            @Override
                            public void onResponse(Call<Object> call, Response<Object> response) {

                                if (response.code() == 200) {
                                    Toast.makeText(context, "Deleted ", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(context, "Have Some Error", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Object> call, Throwable t) {

                            }
                        });

            }
        });
    }

    @Override
    public int getItemCount() {
        return ReservationArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView firstName, email, phoneNo, dateAndTime, restCount;
        ImageView itemResDelete;
        ConstraintLayout ResItem;

        ViewHolder(View itemView) {
            super(itemView);
            //
            this.firstName = itemView.findViewById(R.id.InqName);
            this.email = itemView.findViewById(R.id.InqEmail);
            this.phoneNo = itemView.findViewById(R.id.InqPhone);
            this.dateAndTime = itemView.findViewById(R.id.InqType);
            this.restCount = itemView.findViewById(R.id.ResCount);
            this.itemResDelete = itemView.findViewById(R.id.itemResDelete);
            this.ResItem = itemView.findViewById(R.id.ResItem);

        }

    }

}
