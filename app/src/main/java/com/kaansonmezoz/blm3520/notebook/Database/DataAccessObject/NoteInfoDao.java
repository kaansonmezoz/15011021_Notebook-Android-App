package com.kaansonmezoz.blm3520.notebook.Database.DataAccessObject;

import com.kaansonmezoz.blm3520.notebook.Database.Entity.NoteInfo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;


@Dao
public interface NoteInfoDao {
    @Insert
    public void insertNoteInfo(NoteInfo noteInfo);
}
