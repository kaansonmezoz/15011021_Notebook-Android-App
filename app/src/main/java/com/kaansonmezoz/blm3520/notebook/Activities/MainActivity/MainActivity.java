package com.kaansonmezoz.blm3520.notebook.Activities.MainActivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kaansonmezoz.blm3520.notebook.Activities.MainActivity.Adapter.NoteAdapter;
import com.kaansonmezoz.blm3520.notebook.Activities.MainActivity.Model.NoteItem;
import com.kaansonmezoz.blm3520.notebook.Database.Entity.Note;
import com.kaansonmezoz.blm3520.notebook.Database.Repository.Note.NoteRepository;
import com.kaansonmezoz.blm3520.notebook.R;
import com.kaansonmezoz.blm3520.notebook.ViewModel.NoteViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.note_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final NoteAdapter noteAdapter = new NoteAdapter();

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);

        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                noteAdapter.setNoteItems(notes);
            }
        });


        recyclerView.setAdapter(noteAdapter);
    }

}
