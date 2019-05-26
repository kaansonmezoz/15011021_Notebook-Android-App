package com.kaansonmezoz.blm3520.notebook.Database.DataAccessObject;

import com.kaansonmezoz.blm3520.notebook.Database.RelationEntity.NoteToNoteInfo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

@Dao
public interface NoteToNoteInfoDao {
    @Query("SELECT * FROM NOTE WHERE note_info_id = :infoId")
    public NoteToNoteInfo getNoteWithInfo(int infoId);
}
