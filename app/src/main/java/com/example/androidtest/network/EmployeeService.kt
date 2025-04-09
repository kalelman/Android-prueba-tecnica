package com.example.androidtest.network

import com.example.androidtest.model.Employee
import retrofit2.http.GET
import retrofit2.http.Path

interface EmployeeService {
    @GET("/api/v1/employees")
    suspend fun getEmployees(): List<Employee>

    @GET("/api/v1/employee/{id}")
    suspend fun getEmployee(@Path("id") id: Int): Employee
}
