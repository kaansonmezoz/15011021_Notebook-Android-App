package com.kaansonmezoz.blm3520.notebook.Database.Entity;

import java.util.Calendar;
import java.util.Date;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_info")
public class NoteInfo {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "creation_time")
    public Date creationTime = Calendar.getInstance().getTime();

    @ColumnInfo(name = "last_updated_date")
    public Date lastUpdatedDate = Calendar.getInstance().getTime();

    @ColumnInfo(name = "color")
    public String color = "#FFFF33";
}
