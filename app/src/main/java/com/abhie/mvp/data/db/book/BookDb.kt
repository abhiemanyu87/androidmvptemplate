package com.abhie.mvp.data.db.book

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abhie.mvp.custom.model.DisplayableItem

@Entity(tableName = "books")
data class BookDb(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "identifier")
    var identifier: String,

    @ColumnInfo(name = "url")
    var url: String,

    @ColumnInfo(name = "passw")
    var password: String,

    @ColumnInfo(name = "kurikulum")
    var kurikulum: String

): DisplayableItem