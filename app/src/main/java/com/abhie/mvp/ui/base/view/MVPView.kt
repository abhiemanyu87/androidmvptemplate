package com.abhie.mvp.ui.base.view

/**
 * Created by jyotidubey on 04/01/18.
 */
interface MVPView {

    fun showProgress()

    fun hideProgress()

    fun showMessage(message: String)

}