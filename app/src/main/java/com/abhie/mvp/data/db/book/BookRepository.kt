package com.abhie.mvp.data.db.book

import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class BookRepository @Inject constructor(private val bookDbDao: BookDbDao) : BookDbRepo {

    override fun loadAllBooks(): Single<List<BookDb>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadBooksByKurikulum(kurikulum: String): Single<List<BookDb>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertBook(book: BookDb): Observable<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}