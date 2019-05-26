package com.kaansonmezoz.blm3520.notebook.Database.DataAccessObject;

import com.kaansonmezoz.blm3520.notebook.Database.Entity.NoteInfo;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface NoteInfoDao {
    @Insert
    public void insertNoteInfo(NoteInfo noteInfo);
}
