package com.kaansonmezoz.blm3520.notebook.Database.RelationEntity;

import com.kaansonmezoz.blm3520.notebook.Database.Entity.Note;
import com.kaansonmezoz.blm3520.notebook.Database.Entity.NoteInfo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

public class NoteToNoteInfo {
    @Embedded
    public Note note;

    @Relation(parentColumn = "note_info_id", entityColumn = "id", entity = NoteInfo.class)
    public NoteInfo noteInfo;
}
