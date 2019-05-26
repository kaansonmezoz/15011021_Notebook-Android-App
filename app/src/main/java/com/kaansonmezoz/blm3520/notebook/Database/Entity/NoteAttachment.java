package com.kaansonmezoz.blm3520.notebook.Database.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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
