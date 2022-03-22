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
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.demo.livedinner.R;
import edu.demo.livedinner.api.Api;
import edu.demo.livedinner.api.service.InquiryService;
import edu.demo.livedinner.api.service.ReservationService;
import edu.demo.livedinner.model.Inquiry;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InqAdapter extends RecyclerView.Adapter<InqAdapter.ViewHolder> {
    private Context context;
    private List<Inquiry> InquiryArrayList;
    private Activity activity;

    public InqAdapter(Context context, Activity activity, List<Inquiry> InquiryArrayList) {
        this.context = context;
        this.InquiryArrayList = InquiryArrayList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public InqAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_inq, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull InqAdapter.ViewHolder holder, int position) {
        Inquiry reservation = InquiryArrayList.get(position);
        holder.firstName.setText(reservation.getFirstname());
        holder.email.setText(reservation.getEmail());
        holder.phoneNo.setText(reservation.getPhone());
        holder.type.setText(reservation.getType() + "");
        holder.dec.setText(reservation.getDescription());

        holder.itemResDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Api.getClient().create(InquiryService.class).DeleteInquiry(reservation.getId() + "")
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
        return InquiryArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView firstName, email, phoneNo, type, dec;
        ImageView itemResDelete;


        ViewHolder(View itemView) {
            super(itemView);
            //
            this.firstName = itemView.findViewById(R.id.InqName);
            this.email = itemView.findViewById(R.id.InqEmail);
            this.phoneNo = itemView.findViewById(R.id.InqPhone);
            this.type = itemView.findViewById(R.id.InqType);
            this.itemResDelete = itemView.findViewById(R.id.itemInqDelete);
            this.dec = itemView.findViewById(R.id.InqDec);

        }

    }

}
