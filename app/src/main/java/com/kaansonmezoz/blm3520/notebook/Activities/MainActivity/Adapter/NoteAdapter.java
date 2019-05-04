package com.kaansonmezoz.blm3520.notebook.Activities.MainActivity.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kaansonmezoz.blm3520.notebook.Activities.MainActivity.Model.NoteItem;
import com.kaansonmezoz.blm3520.notebook.R;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    private List<NoteItem> noteItems;

    public NoteAdapter(List<NoteItem> noteItems){
        this.noteItems = noteItems;
    }

    public NoteAdapter.NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_note_item, parent, false);

        return new NoteViewHolder(itemView);
    }

    public void onBindViewHolder(NoteViewHolder holder, int position){
        NoteItem noteItem = noteItems.get(position);

        holder.firstCharacters.setText(noteItem.getTruncatedWords());
        holder.title.setText(noteItem.getTitle());
        holder.lastUpdateDate.setText(noteItem.getLastUpdatedDate());
    }

    public int getItemCount(){
        return noteItems.size();
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public TextView lastUpdateDate;
        public TextView firstCharacters;

        public NoteViewHolder(View view){
            super(view);

            title = view.findViewById(R.id.note_title);
            lastUpdateDate = view.findViewById(R.id.note_last_update_date);
            firstCharacters = view.findViewById(R.id.note_content);
        }
    }
}
