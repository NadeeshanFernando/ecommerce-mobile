package edu.demo.livedinner.api.service;

import java.util.List;

import edu.demo.livedinner.model.Reservation;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ReservationService {
    @POST("addnewreservation")
    Call<Reservation> AddReservation(@Body Reservation reservation);

    @GET("listallreservation")
    Call<List<Reservation>> AllReservation();

    @DELETE("deletereservationbyid/{id}")
    Call<Object> DeleteRes(@Path("id") String id);

}