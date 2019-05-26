package com.kaansonmezoz.blm3520.notebook.Database.DataAccessObject;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.kaansonmezoz.blm3520.notebook.Database.Entity.NoteAttachment;

@Dao
public interface NoteAttachmentDao {
    @Insert
    public void insertNoteAttachment(NoteAttachment attachment);
}
