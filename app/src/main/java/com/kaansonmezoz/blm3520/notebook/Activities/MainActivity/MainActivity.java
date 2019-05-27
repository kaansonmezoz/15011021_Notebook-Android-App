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
import com.kaansonmezoz.blm3520.notebook.Database.Repository.NoteInfo.NoteInfoRepository;
import com.kaansonmezoz.blm3520.notebook.R;
import com.kaansonmezoz.blm3520.notebook.ViewModel.NoteViewModel;
import com.kaansonmezoz.blm3520.notebook.ViewModel.NoteWithInfoViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

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
                NoteInfoRepository repo = new NoteInfoRepository(getApplication());
                List<NoteWithInfoViewModel> noteWithInfoList = new ArrayList<NoteWithInfoViewModel>();
                for(Note note: notes){
                    NoteWithInfoViewModel noteWithInfo = new NoteWithInfoViewModel(note);
                    Log.d("Insert", "Insert-1 id: " + note.id);
                    try {
                        NoteInfo noteInfo = repo.getNoteInfoById(note.id);
                        Log.d("Insert", "Insert-2 note noteInfoId: " + note.noteInfoId);
                        Log.d("Insert", "Insert-3 noteInfo id: " + noteInfo.id);
                        noteWithInfo.setNoteInfo(noteInfo);
                        noteWithInfoList.add(noteWithInfo);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                noteAdapter.setNoteItems(noteWithInfoList);
            }
        });

        recyclerView.setAdapter(noteAdapter);

    }

}
