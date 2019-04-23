package com.abhie.mvp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abhie.mvp.data.db.book.BookDb
import com.abhie.mvp.data.db.book.BookDbDao

@Database(entities = arrayOf(BookDb::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    abstract fun booksDao(): BookDbDao
}