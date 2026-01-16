package com.example.myapplication

class Student(name: String, age: Int, val courses: MutableList<CourseRecord> = mutableListOf()) : Human(name, age) {
    fun addCourse(course: CourseRecord){
        if (courses.contains(course) ) {
            print("error")
        } else {
            courses.add(course)
        }
    }

    fun weightedAverage() : Double {
        var weight = 0.0
        var grade = 0.0

        for (course in courses) {
            weight += course.credits
            grade += course.grade * course.credits
        }

        return grade / weight
    }

    fun weightedAverage(year: Int) : Double {
        val relevantCourses = if (year == 0) courses else courses.filter { it.yearCompleted == year }
        var weight = 0.0
        var grade = 0.0

        for (course in relevantCourses) {
            weight += course.credits
            grade += course.grade * course.credits
        }

        return grade / weight
    }

    fun minMaxGrades() : Pair<Double, Double> {
        if (courses.isEmpty()) {
            return Pair(0.0, 0.0)
        } else {
            val values = mutableListOf<Double>()

            for(course in courses) {
                values.add(course.grade)
            }

            return Pair(values.min(), values.max())
        }
    }
}