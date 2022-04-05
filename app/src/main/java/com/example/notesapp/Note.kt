package com.example.notesapp

class Note (
    val title: String,
    val message: String,
    val date: Long,
    var isSelected: Boolean
) {
    val rowId = 0
}