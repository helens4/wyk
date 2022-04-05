package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), OnItemClickListener {

    lateinit var notesViewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notesViewModel = ViewModelProvider(this)[NotesViewModel::class.java]

        Toast.makeText(this, "abc ${notesViewModel.text}", Toast.LENGTH_LONG).show()
    }

    override fun onItemClick(note: Note, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onItemLongClick(note: Note, position: Int) {
        TODO("Not yet implemented")
    }

}