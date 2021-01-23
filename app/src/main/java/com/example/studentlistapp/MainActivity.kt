package com.example.studentlistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showStudentCount()

        findViewById<Button>(R.id.view_student_list_button).setOnClickListener {
            val intent = Intent(this, StudentListActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.add_student_button).setOnClickListener {
            val name = findViewById<EditText>(R.id.student_name).text.toString()
            val surname = findViewById<EditText>(R.id.student_surname).text.toString()
            if (name != "" && surname != "")
                addStudentToList(name, surname)
            else
                Toast.makeText(this, "Fill in all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showStudentCount() {
        findViewById<TextView>(R.id.total_count).text = StudentList.getStudentListSize().toString()
    }

    private fun clearDataFields() {
        findViewById<EditText>(R.id.student_name).text.clear()
        findViewById<EditText>(R.id.student_surname).text.clear()
    }

    private fun addStudentToList(name: String, surname: String) {
        val student = Student(name, surname)
        if (StudentList.checkStudentInList(student))
            Toast.makeText(this, "Student already exists", Toast.LENGTH_SHORT).show()
        else {
            StudentList.addStudent(student)
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            showStudentCount()
            clearDataFields()
        }
    }
}