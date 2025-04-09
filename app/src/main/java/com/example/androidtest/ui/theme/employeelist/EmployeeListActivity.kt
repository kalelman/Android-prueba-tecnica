package com.example.androidtest.ui.theme.employeelist

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtest.R
import com.example.androidtest.ui.theme.employeedetail.EmployeeDetailActivity
import com.example.androidtest.viewmodel.EmployeeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmployeeListActivity : AppCompatActivity() {
    private val viewModel: EmployeeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.loadEmployees()
        viewModel.employees.observe(this) { employees ->
            recyclerView.adapter = EmployeeAdapter(employees) { selected ->
                val intent = Intent(this, EmployeeDetailActivity::class.java)
                intent.putExtra("id", selected.id)
                startActivity(intent)
            }
        }
    }
}
