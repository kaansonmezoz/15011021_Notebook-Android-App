package com.kaansonmezoz.blm3520.notebook.Database.Repository.Note.AsyncTask;

import android.os.AsyncTask;

import com.kaansonmezoz.blm3520.notebook.Database.DataAccessObject.NoteDao;
import com.kaansonmezoz.blm3520.notebook.Database.Entity.Note;

public class NoteAsyncInsert extends AsyncTask<Note, Void, Void> {
    private NoteDao noteDao;

    public NoteAsyncInsert(NoteDao noteDao){
        this.noteDao = noteDao;
    }

    @Override
    protected Void doInBackground(final Note... params) {
        noteDao.insertNote(params[0]);
        return null;
    }
}
