package com.example.task1

class Student(name: String, surName: String, grade: String, birthdayYear: String) {
    val id: Int = System.currentTimeMillis().toInt() % 100000
    val name: String = name
    val surName: String = surName
    val grade: String = grade
    val birthdayYear: String = birthdayYear

}
