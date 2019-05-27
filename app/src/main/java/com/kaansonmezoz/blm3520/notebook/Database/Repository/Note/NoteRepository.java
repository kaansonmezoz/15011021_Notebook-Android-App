package com.kaansonmezoz.blm3520.notebook.Database.Repository.Note;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.kaansonmezoz.blm3520.notebook.Database.AppDatabase;
import com.kaansonmezoz.blm3520.notebook.Database.DataAccessObject.NoteDao;
import com.kaansonmezoz.blm3520.notebook.Database.Entity.Note;
import com.kaansonmezoz.blm3520.notebook.Database.Repository.Note.AsyncTask.NoteAsyncInsert;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class NoteRepository {
    private NoteDao noteDao;

    public NoteRepository(Application application){
        AppDatabase database = AppDatabase.getDatabase(application);
        noteDao = database.noteDao();
    }

    public Long insertNote(Note note) throws ExecutionException, InterruptedException {
        return new NoteAsyncInsert(noteDao).execute(note).get();
    }

    public LiveData<List<Note>> getAllNotes(){
        return noteDao.getAllNotes();
    }
}
