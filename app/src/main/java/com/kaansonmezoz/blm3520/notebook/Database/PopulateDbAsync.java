package com.kaansonmezoz.blm3520.notebook.Database;

import android.os.AsyncTask;

import com.kaansonmezoz.blm3520.notebook.Database.DataAccessObject.NoteDao;
import com.kaansonmezoz.blm3520.notebook.Database.Entity.Note;

public class PopulateDbAsync extends AsyncTask <Void, Void, Void> {
    private final NoteDao noteDao;

    public PopulateDbAsync(AppDatabase db){
        noteDao = db.noteDao();
    }

    protected Void doInBackground(final Void ... params){
        noteDao.deleteAll();
        noteDao.insertNote(new Note("deneme", "deneme"));
        noteDao.insertNote(new Note("deneme1", "deneme1"));
        noteDao.insertNote(new Note("deneme2", "deneme"));
        noteDao.insertNote(new Note("deneme3", "deneme"));
        noteDao.insertNote(new Note("deneme4", "deneme"));
        noteDao.insertNote(new Note("deneme5", "deneme"));
        noteDao.insertNote(new Note("deneme6", "deneme"));
        noteDao.insertNote(new Note("deneme7", "deneme"));

        return null;
    }
}
