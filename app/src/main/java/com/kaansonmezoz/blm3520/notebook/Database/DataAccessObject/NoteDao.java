package com.kaansonmezoz.blm3520.notebook.Database.DataAccessObject;

import com.kaansonmezoz.blm3520.notebook.Database.Entity.Note;
import com.kaansonmezoz.blm3520.notebook.Database.Entity.NoteInfo;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

@Dao
public interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertNotes(Note note, NoteInfo noteInfo);
}
