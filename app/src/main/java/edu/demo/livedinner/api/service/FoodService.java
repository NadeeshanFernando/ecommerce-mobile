package edu.demo.livedinner.api.service;


import java.util.List;

import edu.demo.livedinner.model.Food;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface FoodService {
    @POST("addnewfood")
    Call<Food> AddFood(@Body Food f);

    @GET("listallfood")
    Call<List<Food>> AllFood();

    @PUT("editfoodbyid/{id}")
    Call<Food> UpdateFood(@Path("id") String id, @Body Food food);

    @DELETE("deletefoodbyid/{id}")
    Call<Object> DeleteFood(@Path("id")String id);

}
