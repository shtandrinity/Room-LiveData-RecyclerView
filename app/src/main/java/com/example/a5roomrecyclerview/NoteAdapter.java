package com.example.a5roomrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private List<Note> notes = new ArrayList<>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new NoteHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.tvTitle.setText(currentNote.getTitle());
        holder.tvPriority.setText(String.valueOf(currentNote.getPriority()));
        holder.tvDescription.setText(currentNote.getDescription());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes (List<Note> notes){
        this.notes = notes;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private TextView tvPriority;
        private TextView tvDescription;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvPriority = itemView.findViewById(R.id.tv_priority);
            tvDescription = itemView.findViewById(R.id.tv_description);
        }
    }
}
