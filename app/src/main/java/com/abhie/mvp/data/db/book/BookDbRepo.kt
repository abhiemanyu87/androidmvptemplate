package com.abhie.mvp.data.db.book

import io.reactivex.Observable
import io.reactivex.Single

interface BookDbRepo {
    fun loadAllBooks(): Single<List<BookDb>>

    fun loadBooksByKurikulum(kurikulum: String): Single<List<BookDb>>

    fun insertBook(book: BookDb): Observable<Boolean>
}