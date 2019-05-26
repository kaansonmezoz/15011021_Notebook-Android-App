package com.kaansonmezoz.blm3520.notebook.Database.Entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "note",
        foreignKeys = @ForeignKey(
                entity = NoteInfo.class,
                parentColumns = "id",
                childColumns = "note_id",
                onDelete = ForeignKey.CASCADE
        )
)
public class Note {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "title")
    @NonNull
    public String title;

    @ColumnInfo(name = "note_file_path")
    @Nullable
    public String notePath;

    @ColumnInfo(name = "priority")
    public String priority = "MEDIUM";

    @ColumnInfo(name = "note_id")
    @NonNull
    public int noteId;
}
