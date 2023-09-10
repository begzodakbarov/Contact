package com.example.kontakt.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.kontakt.models.User

class MyDbHelper(context: Context):SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION), MyDbService {

    companion object {
        val DB_NAME = "user_db"
        val DB_VERSION = 1


        val TABLE_NAME = "user_table"
        val FOOD_ID = "id"
        val FOOD_NAME = "name"
        val FOOD_NUMBER = "number"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query =
            "create table $TABLE_NAME($FOOD_ID integer not null primary key autoincrement unique,$FOOD_NAME text not null, $FOOD_NUMBER text not null)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    override fun addKontakt(user: User) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(FOOD_NAME, user.name)
        contentValues.put(FOOD_NUMBER, user.number)
        database.insert(TABLE_NAME, null, contentValues)
        database.close()
    }

    override fun getAllKontakt(): List<User> {
        val database = this.readableDatabase
        val list = ArrayList<User>()
        val query = "select * from $TABLE_NAME"
        val cursor = database.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                var user = User(id = cursor.getInt(0), name = cursor.getString(1), number = cursor.getString(2))
                list.add(user)
            } while (cursor.moveToNext())
        }
        return list
    }
}
