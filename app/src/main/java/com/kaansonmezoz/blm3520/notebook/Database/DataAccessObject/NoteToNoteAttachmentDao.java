package com.kaansonmezoz.blm3520.notebook.Database.DataAccessObject;

import com.kaansonmezoz.blm3520.notebook.Database.RelationEntity.NoteToNoteAttachments;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface NoteToNoteAttachmentDao {
    @Insert
    public void insert(NoteToNoteAttachments noteAndAttachments);

    @Query("SELECT * FROM note WHERE id = :noteId")
    public NoteToNoteAttachments getNoteAndAllAttachments(int noteId);
}
