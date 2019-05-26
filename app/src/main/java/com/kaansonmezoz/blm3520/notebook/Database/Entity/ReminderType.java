package com.kaansonmezoz.blm3520.notebook.Database.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "reminder_type")
public class ReminderType {     //TODO: Reminder ile ilgili işlemleri daha sonra yapacağız suanda herhangi bir şekilde gerek yok bunlara baslamaya
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "description")
    public String description;
}
