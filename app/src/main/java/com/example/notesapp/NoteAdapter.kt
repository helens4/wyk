package com.example.notesapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private val noteList: List<Note>, private val listener: OnItemClickListener): RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {


    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener { listener.onItemClick(noteList[adapterPosition], adapterPosition) }
            itemView.setOnLongClickListener {
                listener.onItemLongClick(noteList[adapterPosition], adapterPosition)
                true
            }
        }

        val title: TextView = itemView.findViewById(R.id.noteTitle)
        val message: TextView = itemView.findViewById(R.id.noteMessage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.note_item, parent, false)

        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.itemView.setBackgroundColor(Color.WHITE)

        if(noteList[position].isSelected) {
            holder.itemView.setBackgroundColor(Color.LTGRAY)
        }

        holder.title.text = noteList[position].title
        holder.message.text = noteList[position].message

    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}

interface OnItemClickListener {
    fun onItemClick(note: Note, position: Int)
    fun onItemLongClick(note: Note, position: Int)
}