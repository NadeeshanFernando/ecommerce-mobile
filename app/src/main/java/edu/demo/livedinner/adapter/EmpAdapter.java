package edu.demo.livedinner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.demo.livedinner.R;
import edu.demo.livedinner.api.Api;
import edu.demo.livedinner.api.service.EmployeeService;
import edu.demo.livedinner.model.Employee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.ViewHolder> {
    private Context context;
    private List<Employee> employeeArrayList;

    public EmpAdapter(Context context, List<Employee> employeeArrayList) {
        this.context = context;
        this.employeeArrayList = employeeArrayList;
    }

    @NonNull
    @Override
    public EmpAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_emp, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpAdapter.ViewHolder holder, int position) {
        Employee employee = employeeArrayList.get(position);
        holder.name.setText(employee.getUsername());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Api.getClient().create(EmployeeService.class).DeleteEmployee(employee.getId() + "")
                        .enqueue(new Callback() {
                            @Override
                            public void onResponse(Call call, Response response) {
                                if (response.code() == 200) {
                                    Toast.makeText(context, "Deleted ", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(context, "Have Some Error", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call call, Throwable t) {
                                Toast.makeText(context, "Have Some Error", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    @Override
    public int getItemCount() {
        return employeeArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView btnDelete;

        ViewHolder(View itemView) {
            super(itemView);
            //
            this.btnDelete = itemView.findViewById(R.id.itemDelete);
            this.name = itemView.findViewById(R.id.name);

        }

    }

}
