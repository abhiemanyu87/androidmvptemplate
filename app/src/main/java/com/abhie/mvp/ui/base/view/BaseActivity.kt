package com.abhie.mvp.ui.base.view

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.abhie.mvp.R
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjection

/**
 * Created by jyotidubey on 04/01/18.
 */
abstract class BaseActivity : AppCompatActivity(), MVPView, BaseFragment.CallBack {

    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDI()
    }

    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel() }
    }

    override fun showProgress() {
        hideProgress()
//        progressDialog = CommonUtil.showLoadingDialog(this)
    }

    override fun showMessage(message: String) {
        val snackbar = Snackbar.make(findViewById( android.R.id.content) ,
                message, Snackbar.LENGTH_SHORT)
        val sbView = snackbar.view
        val textView = sbView
                .findViewById<View>(R.id.snackbar_text) as TextView
        snackbar.show()
    }

    fun hideKeyboard() {
        val view = this.currentFocus
        view?.let { v ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.let { it.hideSoftInputFromWindow(v.windowToken, 0) }
        }
    }

    private fun performDI() = AndroidInjection.inject(this)

}