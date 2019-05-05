package com.kaansonmezoz.blm3520.notebook.Activities.MainActivity;

import android.animation.LayoutTransition;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kaansonmezoz.blm3520.notebook.Activities.MainActivity.Adapter.NoteAdapter;
import com.kaansonmezoz.blm3520.notebook.Activities.MainActivity.Model.NoteItem;
import com.kaansonmezoz.blm3520.notebook.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.note_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<NoteItem> noteItems = new ArrayList<NoteItem>();

        noteItems.add(new NoteItem(1, "deneme", "deneme",   "deneme"));
        noteItems.add(new NoteItem(1, "deneme1", "deneme1",   "deneme1"));
        noteItems.add(new NoteItem(1, "deneme2", "deneme",   "deneme"));
        noteItems.add(new NoteItem(1, "deneme3", "deneme",   "deneme"));
        noteItems.add(new NoteItem(1, "deneme4", "deneme",   "deneme"));
        noteItems.add(new NoteItem(1, "deneme5", "deneme",   "deneme"));
        noteItems.add(new NoteItem(1, "deneme6", "deneme",   "deneme"));
        noteItems.add(new NoteItem(1, "deneme7", "deneme",   "deneme"));


        NoteAdapter noteAdapter = new NoteAdapter(noteItems);
        recyclerView.setAdapter(noteAdapter);
    }
}
