package com.example.task1

class Student(
    name: String,
    age: Int,
    val courses: MutableList<CourseRecord> = mutableListOf()
) : Human(name, age) {

    fun addCourse(course: CourseRecord) {
        courses.add(course)
    }

    fun weightedAverage(year: Int = 0): Double {
        val relevantCourse = if (year == 0) courses else courses.filter { it.yearCompleted == year }

        var totalWeight = 0.0
        var totalGrade = 0.0

        for (course in relevantCourse) {
            totalWeight += course.credits
            totalGrade += course.grade * course.credits
        }

        return totalGrade / totalWeight

    }

    fun minMaxGrades(year: Int = 0): Pair<Double, Double> {
        val relevantCourse = if (year == 0) courses else courses.filter { it.yearCompleted == year }

        var minGrade = Double.MAX_VALUE
        var maxGrade = Double.MIN_VALUE

        for (course in relevantCourse) {
            if (course.grade < minGrade) {
                minGrade = course.grade
            }
            if (course.grade > maxGrade) {
                maxGrade = course.grade
            }
        }

        return Pair(minGrade, maxGrade)

    }
}