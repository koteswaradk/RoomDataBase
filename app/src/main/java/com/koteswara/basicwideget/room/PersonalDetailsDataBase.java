package com.koteswara.basicwideget.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = PersonalDetailsModel.class,exportSchema = false,version =1)
public abstract class PersonalDetailsDataBase extends RoomDatabase {
    private static final String DB_NAME="personalDatabase_db";
    private static PersonalDetailsDataBase dataBaseInstance;
    private static final String LOG_TAG = PersonalDetailsDataBase.class.getSimpleName();

    public static PersonalDetailsDataBase getdatabase(Context context){
        if (dataBaseInstance==null){
            synchronized (PersonalDetailsDataBase.class){
                if (dataBaseInstance==null){
                    dataBaseInstance= Room.databaseBuilder(context.getApplicationContext(),PersonalDetailsDataBase.class,DB_NAME).fallbackToDestructiveMigration().build();
                }
            }
        }

        return dataBaseInstance;
    }
    public abstract PersonalDetailsDAO personalDetailsDAO();
}
