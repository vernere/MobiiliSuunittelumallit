package com.example.task1

class Major(var name: String, var students: MutableList<Student> = mutableListOf()) {

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun stats(): Triple<Double, Double, Double> {
        if (students.isEmpty()) {
            return Triple(0.0, 0.0, 0.0)
        }

        val averages = students.map { it.weightedAverage() }
        val min = averages.minOrNull() ?: 0.0
        val max = averages.maxOrNull() ?: 0.0
        val avg = averages.average()

        return Triple(min, max, avg)
    }

    fun stats(courseName: String): Triple<Double, Double, Double> {
        val studentsWhoTookCourse = students.filter { s -> s.courses.any { it.name == courseName } }
        if (studentsWhoTookCourse.isEmpty()) {
            return Triple(0.0, 0.0, 0.0)
        }

        val gradesForCourse = studentsWhoTookCourse.mapNotNull { student ->
            student.courses.find { it.name == courseName }?.grade
        }

        val averagesOfStudents = studentsWhoTookCourse.map { it.weightedAverage() }


        val min = gradesForCourse.minOrNull() ?: 0.0
        val max = averagesOfStudents.maxOrNull() ?: 0.0
        val avg = gradesForCourse.average()

        return Triple(min, max, avg)
    }
}