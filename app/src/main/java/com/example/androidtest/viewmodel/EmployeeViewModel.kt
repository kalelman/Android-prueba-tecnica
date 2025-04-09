package com.example.androidtest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtest.model.Employee
import com.example.androidtest.repository.EmployeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeeViewModel @Inject constructor(private val repository: EmployeeRepository) : ViewModel() {
    private val _employees = MutableLiveData<List<Employee>>()
    val employees: LiveData<List<Employee>> = _employees

    private val _selectedEmployee = MutableLiveData<Employee>()
    val selectedEmployee: LiveData<Employee> = _selectedEmployee

    fun loadEmployees() {
        viewModelScope.launch {
            _employees.value = repository.fetchAllEmployees()
        }
    }

    fun loadEmployee(id: Int) {
        viewModelScope.launch {
            _selectedEmployee.value = repository.fetchEmployee(id)
        }
    }
}