package com.kaansonmezoz.blm3520.notebook.Database;

import android.os.AsyncTask;

import com.kaansonmezoz.blm3520.notebook.Database.DataAccessObject.NoteDao;
import com.kaansonmezoz.blm3520.notebook.Database.DataAccessObject.NoteInfoDao;
import com.kaansonmezoz.blm3520.notebook.Database.Entity.Note;
import com.kaansonmezoz.blm3520.notebook.Database.Entity.NoteInfo;

import java.util.Date;

public class PopulateDbAsync extends AsyncTask <Void, Void, Void> {
    private final NoteDao noteDao;
    private final NoteInfoDao noteInfoDao;

    public PopulateDbAsync(AppDatabase db){
        noteDao = db.noteDao();
        noteInfoDao = db.noteInfoDao();
    }

    protected Void doInBackground(final Void ... params){
        noteDao.deleteAll();

        long noteInfoId = noteInfoDao.insertNoteInfo(new NoteInfo(new Date(), new Date(), null));
        noteDao.insertNote(new Note("deneme", "deneme", noteInfoId));

        noteInfoId = noteInfoDao.insertNoteInfo(new NoteInfo(new Date(), new Date(), null));
        noteDao.insertNote(new Note("deneme1", "deneme1", noteInfoId));

        noteInfoId = noteInfoDao.insertNoteInfo(new NoteInfo(new Date(), new Date(), null));
        noteDao.insertNote(new Note("deneme2", "deneme", noteInfoId));

        noteInfoId = noteInfoDao.insertNoteInfo(new NoteInfo(new Date(), new Date(), null));
        noteDao.insertNote(new Note("deneme3", "deneme", noteInfoId));

        noteInfoId = noteInfoDao.insertNoteInfo(new NoteInfo(new Date(), new Date(), null));
        noteDao.insertNote(new Note("deneme4", "deneme", noteInfoId));

        noteInfoId = noteInfoDao.insertNoteInfo(new NoteInfo(new Date(), new Date(), null));
        noteDao.insertNote(new Note("deneme5", "deneme", noteInfoId));

        noteInfoId = noteInfoDao.insertNoteInfo(new NoteInfo(new Date(), new Date(), null));
        noteDao.insertNote(new Note("deneme6", "deneme", noteInfoId));

        noteInfoId = noteInfoDao.insertNoteInfo(new NoteInfo(new Date(), new Date(), null));
        noteDao.insertNote(new Note("deneme8", "deneme", noteInfoId));

        return null;
    }
}
