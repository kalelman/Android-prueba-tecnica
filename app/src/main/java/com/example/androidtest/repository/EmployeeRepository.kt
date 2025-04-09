package com.example.androidtest.repository

import com.example.androidtest.model.Employee
import com.example.androidtest.network.EmployeeService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EmployeeRepository @Inject constructor(private val api: EmployeeService) {
    suspend fun fetchAllEmployees(): List<Employee> = api.getEmployees()
    suspend fun fetchEmployee(id: Int): Employee = api.getEmployee(id)
}