package edu.demo.livedinner.api.service;


import java.util.List;

import edu.demo.livedinner.model.Employee;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EmployeeService {
    String Url = "listallemployee";

    @GET("listallemployee")
    Call<List<Employee>> getAllEmp();

    @DELETE("deleteemployeebyid/{id}")
    Call DeleteEmployee(@Path("id")String id);
//    Call<Employee> payment(@Header("authorization") String apiKey, @Path("rentalId") String rentalId, @Body Employee paymentReqDataModel);
}
