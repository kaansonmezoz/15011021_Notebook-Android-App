package com.kaansonmezoz.blm3520.notebook.Database.RelationEntity;

import com.kaansonmezoz.blm3520.notebook.Database.Entity.Note;
import com.kaansonmezoz.blm3520.notebook.Database.Entity.NoteAttachment;

import java.util.List;

import androidx.room.Embedded;
import androidx.room.Relation;

public class NoteToNoteAttachments {
    @Embedded
    public Note note;

    @Relation(parentColumn = "id", entityColumn = "noteId", entity = NoteAttachment.class)
    public List<NoteAttachment> attachments;
}
