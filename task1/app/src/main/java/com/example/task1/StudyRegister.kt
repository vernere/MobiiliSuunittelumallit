package com.example.task1

class StudyRegister {
    val students = mutableListOf<Student>()
    val majors = mutableListOf<Major>()

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun addMajor(major: Major) {
        majors.add(major)
    }
}