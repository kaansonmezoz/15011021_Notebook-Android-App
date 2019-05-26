package com.kaansonmezoz.blm3520.notebook.Database;

import android.content.Context;

import androidx.room.Room;

public class AppDatabase {
    private static AppDatabaseAbstract database;

    public static synchronized AppDatabaseAbstract getDatabase(Context context){
        if(database == null){
            database = Room.databaseBuilder(context, AppDatabaseAbstract.class, "notebook-database").build();
        }
        return database;
    }
}
