package com.example.studentlistapp

object StudentList {
    private var studentList: MutableList<Student> = ArrayList()

    fun getStudentList(): MutableList<Student> {
        return studentList
    }

    fun addStudent(student: Student) {
        studentList.add(student)
    }

    fun getStudentListSize(): Int {
        return studentList.size
    }

    fun checkStudentInList(student: Student): Boolean {
        if (studentList.contains(student))
            return true
        return false
    }

}