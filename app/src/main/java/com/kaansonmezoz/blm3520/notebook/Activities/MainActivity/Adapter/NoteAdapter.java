package com.kaansonmezoz.blm3520.notebook.Activities.MainActivity.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kaansonmezoz.blm3520.notebook.Activities.MainActivity.Model.NoteItem;
import com.kaansonmezoz.blm3520.notebook.R;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    private  List<NoteItem> noteItems;

    public NoteAdapter(List<NoteItem> noteItems){
        this.noteItems = noteItems;
    }

    public NoteAdapter.NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_note_item, parent, false);

        //itemView.createContextMenu();

        itemView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
            //TODO: Related information about the clicked note must be shown to the user
            }
        });



        /*
        itemView.setOnLongClickListener(new View.OnLongClickListener(){
            public boolean onLongClick(View view){
                //TODO: options: Select, Delete, Set Reminder, Share
            }
        });
        */


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

    public void removeAt(int position) {
    }

    public  class NoteViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public TextView lastUpdateDate;
        public TextView firstCharacters;

        public NoteViewHolder(View view){
            super(view);

                                                    //TODO: ContextMenu yerine belki de popup olusturmak daha mantikli olabilir ?

            //todo: kod acayip bir sekilde cirkinlesmeye basladi bunu bir guzel refactor etmek lazim
            view.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener(){     //TODO: Bunun alternatiflerine de bakmak da yarar var
                public void onCreateContextMenu(ContextMenu menu, final View view, ContextMenu.ContextMenuInfo menuInfo){

                    menu.add("Select").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            Log.d("MainActivity", "Select clicked");
                            return false;
                        }
                    });

                    menu.add("Delete").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            int position = getAdapterPosition();

                            noteItems.remove(position);
                            notifyItemRemoved(position);
                            notifyItemRangeChanged(position, noteItems.size());


                            Log.d("MainActivity", "Delete clicked");
                            return false;
                        }
                    });

                    menu.add("Set Reminder").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            Log.d("MainActivity", "Set Reminder clicked");
                            return false;
                        }
                    });

                    menu.add("Share").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            Log.d("MainActivity", "Share clicked");
                            return false;
                        }
                    });
                }

            });

            title = view.findViewById(R.id.note_title);
            lastUpdateDate = view.findViewById(R.id.note_last_update_date);
            firstCharacters = view.findViewById(R.id.note_content);
        }
    }
}
