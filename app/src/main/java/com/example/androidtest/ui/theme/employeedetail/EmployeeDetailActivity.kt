package com.example.androidtest.ui.theme.employeedetail

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.example.androidtest.R
import com.example.androidtest.viewmodel.EmployeeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmployeeDetailActivity : AppCompatActivity() {
    private val viewModel: EmployeeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_detail)

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvAge = findViewById<TextView>(R.id.tvAge)
        val tvSalary = findViewById<TextView>(R.id.tvSalary)

        val id = intent.getIntExtra("id", -1)
        if (id != -1) viewModel.loadEmployee(id)

        viewModel.selectedEmployee.observe(this) { emp ->
            tvName.text = emp.name
            emp.age.toString().also { tvAge.text = it }
            emp.salary.toString().also { tvSalary.text = it }

            val ageColor = if (emp.age in 26..34) Color.Green else Color.Red
            val salaryColor = if (emp.salary > 1000) Color.Green else Color.Red

            tvAge.setTextColor(ageColor.toArgb())
            tvSalary.setTextColor(salaryColor.toArgb())
        }
    }
}