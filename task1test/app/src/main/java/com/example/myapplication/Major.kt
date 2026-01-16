package com.example.myapplication

class Major(var name: String, val students: MutableList<Student> = mutableListOf()) {
    fun addStudent(student: Student) {
        if (students.contains(student)) {
            print("error")
        } else {
            students.add(student)
        }
    }

    fun stats() : Triple<Double, Double, Double> {
        val weightedList = mutableListOf<Double>()

        for (student in students) {
            weightedList.add(student.weightedAverage())
        }

        return Triple(weightedList.min(), weightedList.max(), weightedList.sum() / weightedList.size)
    }

    fun stats(courseName: String) : Triple<Double, Double, Double> {
        val studentsWhoTookCourse = students.filter { s -> s.courses.any { it.name == courseName } }
        val weightedList = mutableListOf<Double>()

        if (studentsWhoTookCourse.isEmpty()) {
            return Triple(0.0, 0.0, 0.0)
        }

        val gradesForCourse = studentsWhoTookCourse.mapNotNull { student ->
            student.courses.find { it.name == courseName }?.grade
        }

        val averagesOfStudents = studentsWhoTookCourse.map { it.weightedAverage() }

        return Triple(gradesForCourse.min(), averagesOfStudents.max(), gradesForCourse.average())
    }
}