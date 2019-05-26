package com.kaansonmezoz.blm3520.notebook.Database.Repository.Note;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.kaansonmezoz.blm3520.notebook.Database.AppDatabase;
import com.kaansonmezoz.blm3520.notebook.Database.DataAccessObject.NoteDao;
import com.kaansonmezoz.blm3520.notebook.Database.Entity.Note;
import com.kaansonmezoz.blm3520.notebook.Database.Repository.Note.AsyncTask.NoteAsyncInsert;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;

    public NoteRepository(Application application){
        AppDatabase database = AppDatabase.getDatabase(application);
        noteDao = database.noteDao();
    }

    public void insertNote(Note note){
        new NoteAsyncInsert(noteDao).execute(note);
    }

    public LiveData<List<Note>> getAllNotes(){
        return noteDao.getAllNotes();
    }
}
