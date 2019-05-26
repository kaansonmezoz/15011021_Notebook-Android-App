package com.kaansonmezoz.blm3520.notebook.Database.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "note_attachment")
public class NoteAttachment {
    @ColumnInfo(name = "id")
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "note_id")
    public int note_id;

    @ColumnInfo(name = "type")
    @NonNull
    public String type; // AUDIO, DOCUMENT, PHOTO ...

    @ColumnInfo(name = "file_path")
    @NonNull
    public String filePath;
}
