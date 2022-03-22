package edu.demo.livedinner.api.service;

import java.util.List;

import edu.demo.livedinner.model.Inquiry;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface InquiryService {
    @POST("addnewinquiry")
    Call<Inquiry> AddInquiry(@Body Inquiry inquiry);

    @GET("listallinquiry")
    Call<List<Inquiry>> AllInquiry();

    @DELETE("deleteinquirybyid/{id}")
    Call<Object> DeleteInquiry(@Path("id") String id);

}