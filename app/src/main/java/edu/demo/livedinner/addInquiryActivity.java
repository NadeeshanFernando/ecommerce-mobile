package edu.demo.livedinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.demo.livedinner.api.Api;
import edu.demo.livedinner.api.service.InquiryService;
import edu.demo.livedinner.model.Inquiry;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class addInquiryActivity extends AppCompatActivity {
    private EditText name, email, phone, desc, type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inquiry);
        this.name = findViewById(R.id.ItName);
        this.email = findViewById(R.id.IEmail);
        this.phone = findViewById(R.id.IPhoneNo);
        this.desc = findViewById(R.id.Idesc);
        this.type = findViewById(R.id.Itype);
    }

    public void Save(View view) {
        Api.getClient().create(InquiryService.class).AddInquiry(new Inquiry(0, name.getText().toString(), email.getText().toString(), phone.getText().toString(), desc.getText().toString(), type.getText().toString()))
                .enqueue(new Callback<Inquiry>() {
                    @Override
                    public void onResponse(Call<Inquiry> call, Response<Inquiry> response) {
                        if (response.code() == 200) {
                            Toast.makeText(addInquiryActivity.this, "Added .!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(addInquiryActivity.this, "Check Details .!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Inquiry> call, Throwable t) {
                        Toast.makeText(addInquiryActivity.this, "have Some Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void Back(View view) {
        startActivity(new Intent(this, NavigationActivity.class));
        finish();
    }
}
