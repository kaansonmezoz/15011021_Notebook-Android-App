package com.kaansonmezoz.blm3520.notebook.Database.Entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note")
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
