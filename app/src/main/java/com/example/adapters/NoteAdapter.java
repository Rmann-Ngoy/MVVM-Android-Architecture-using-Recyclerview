package com.example.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.R;
import com.example.model.Entity.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Note> notes = new ArrayList<>();


    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item,parent,false);
        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.tv_Title.setText(currentNote.getTitle());
        holder.tv_Description.setText(currentNote.getDescription());
        holder.tv_priority.setText(String.valueOf(currentNote.getPriority()));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes){
        this.notes = notes;
        notifyDataSetChanged();
    }

    static class NoteHolder extends RecyclerView.ViewHolder{
        private TextView tv_Title;
        private TextView tv_Description;
        private TextView tv_priority;

        NoteHolder(View itemView){
            super(itemView);
            tv_Title = itemView.findViewById(R.id.tv_title);
            tv_Description = itemView.findViewById(R.id.tv_description);
            tv_priority = itemView.findViewById(R.id.tv_priority);
        }
    }
}
