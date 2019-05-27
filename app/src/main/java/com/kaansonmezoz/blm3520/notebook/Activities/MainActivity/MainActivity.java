package com.kaansonmezoz.blm3520.notebook.Activities.MainActivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.kaansonmezoz.blm3520.notebook.Activities.MainActivity.Adapter.NoteAdapter;
import com.kaansonmezoz.blm3520.notebook.Database.Entity.Note;
import com.kaansonmezoz.blm3520.notebook.Database.Entity.NoteInfo;
import com.kaansonmezoz.blm3520.notebook.Database.RelationEntity.NoteToNoteInfo;
import com.kaansonmezoz.blm3520.notebook.Database.Repository.NoteToNoteInfo.NoteToNoteInfoRepository;
import com.kaansonmezoz.blm3520.notebook.R;
import com.kaansonmezoz.blm3520.notebook.ViewModel.NoteInfoViewModel;
import com.kaansonmezoz.blm3520.notebook.ViewModel.NoteViewModel;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private NoteViewModel noteViewModel;
    private NoteInfoViewModel noteInfoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.note_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final NoteAdapter noteAdapter = new NoteAdapter();

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        noteInfoViewModel = ViewModelProviders.of(this).get(NoteInfoViewModel.class);

        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                noteAdapter.setNoteItems(notes);
            }
        });


        recyclerView.setAdapter(noteAdapter);

        //TODO: Insertten sonra ayrica adapter sey yapilmali notify edilmeli
        NoteInfo noteInfo = new NoteInfo(new Date(), new Date(), null);
        Note note = null;

        try{
            long id = noteInfoViewModel.insertNote(noteInfo);
            noteInfo.id = id;
            note = new Note("aaaaabbbbcc", "low", id);
            id = noteViewModel.insertNote(note);
            Log.d("Insert", "Insert-1 id: " + note.id);
            Log.d("Insert", "Insert-2 id: " + id);
            note.id = id;
            Log.d("Insert", "After insert: " + note.id);
            noteAdapter.notifyDataSetChanged();

            Log.d("Insert", "note -> noteInfoId: " + note.noteInfoId);
            Log.d("Insert", "noteInfo -> id: " + noteInfo.id);
        }catch(InterruptedException e) {
            e.printStackTrace();
        } catch(ExecutionException e) {
            e.printStackTrace();
        }
    }

}
