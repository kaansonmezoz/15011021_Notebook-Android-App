package com.kaansonmezoz.blm3520.notebook.Database.DataAccessObject;

import com.kaansonmezoz.blm3520.notebook.Database.Entity.NoteAttachment;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface NoteAttachmentDao {
    @Insert
    public void insertNoteAttachment(NoteAttachment attachment);
}
