package com.abhie.mvp.data.db.book

import androidx.room.*
import com.abhie.mvp.data.db.book.BookDb

@Dao
interface BookDbDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(magazineDb: List<BookDb>)

    @Insert
    fun insert(magazineDb: BookDb): Long

    @Query("SELECT * FROM books")
    fun loadAll(): List<BookDb>

    @Delete
    fun delete(magazineDb: BookDb): Int

    @Query("SELECT * FROM books WHERE id = :bookId")
    fun load(bookId: Long): BookDb

    @Query("SELECT * FROM books WHERE identifier = :identifier")
    fun loadByIdentifier(identifier: String): List<BookDb>

    @Query("SELECT * FROM books WHERE kurikulum = :kurikulum")
    fun loadByKurikulum(kurikulum: String): List<BookDb>
}