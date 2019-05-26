package com.kaansonmezoz.blm3520.notebook.Database.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_attachment",
        foreignKeys = @ForeignKey(
            entity = Note.class,
            parentColumns = "id",
            childColumns = "note_id"
        )
)
public class NoteAttachment {
    @ColumnInfo(name = "id")
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "note_id")
    @NonNull
    public int note_id;

    @ColumnInfo(name = "type")
    @NonNull
    public String type; // AUDIO, DOCUMENT, PHOTO ...

    @ColumnInfo(name = "file_path")
    @NonNull
    public String filePath;
}
