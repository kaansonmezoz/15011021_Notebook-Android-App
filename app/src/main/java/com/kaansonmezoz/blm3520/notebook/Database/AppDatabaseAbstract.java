package com.kaansonmezoz.blm3520.notebook.Database;

import com.kaansonmezoz.blm3520.notebook.Database.DataAccessObject.NoteAttachmentDao;
import com.kaansonmezoz.blm3520.notebook.Database.DataAccessObject.NoteDao;
import com.kaansonmezoz.blm3520.notebook.Database.DataAccessObject.NoteInfoDao;
import com.kaansonmezoz.blm3520.notebook.Database.DataAccessObject.NoteToNoteAttachmentDao;
import com.kaansonmezoz.blm3520.notebook.Database.Entity.Note;
import com.kaansonmezoz.blm3520.notebook.Database.Entity.NoteAttachment;
import com.kaansonmezoz.blm3520.notebook.Database.Entity.NoteInfo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class, NoteAttachment.class, NoteInfo.class}, version = 1)
public abstract class AppDatabaseAbstract extends RoomDatabase {
    public abstract NoteDao noteDato();
    public abstract NoteInfoDao noteInfoDao();
    public abstract NoteAttachmentDao noteAttachmentDao();
    public abstract NoteToNoteAttachmentDao noteToNoteAttachmentDao();
}
