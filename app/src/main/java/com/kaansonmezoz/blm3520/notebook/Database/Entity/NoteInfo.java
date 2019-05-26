package com.kaansonmezoz.blm3520.notebook.Database.Entity;

import java.util.Calendar;
import java.util.Date;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import com.kaansonmezoz.blm3520.notebook.Database.Converter.DateConverter;

@Entity(tableName = "note_info")
@TypeConverters(DateConverter.class)
public class NoteInfo {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "creation_time")
    public Date creationTime;

    @ColumnInfo(name = "last_updated_date")
    public Date lastUpdatedDate;

    @ColumnInfo(name = "color")
    public String color = "#FFFF33";
}
