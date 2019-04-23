package com.abhie.mvp.ui.base.view

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.abhie.mvp.R
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.AndroidSupportInjection

/**
 * Created by jyotidubey on 12/01/18.
 */
@Suppress("DEPRECATION")
abstract class BaseFragment : Fragment(), MVPView {

    private var parentActivity: BaseActivity? = null
    private var progressDialog: ProgressDialog? = null
    private var progressBar: ProgressBar? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity?
            this.parentActivity = activity
            activity?.onFragmentAttached()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDependencyInjection()
        setHasOptionsMenu(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    override fun hideProgress() {
//        if (progressDialog != null && progressDialog?.isShowing!!) {
//            progressDialog?.cancel()
//        }
        progressBar?.let {
            if(it.isShown){
                it.visibility = View.GONE
            }
        }
    }

    override fun showProgress() {
        hideProgress()
//        progressDialog = CommonUtil.showLoadingDialog(this.context)
        progressBar?.let {
            it.visibility = View.VISIBLE
        }
    }

    protected fun attachProgress(progressBar: ProgressBar){
        this.progressBar = progressBar
    }

    override fun showMessage(message: String) {
        val snackbar = Snackbar.make(parentActivity!!.findViewById( android.R.id.content) ,
                message, Snackbar.LENGTH_SHORT)
        val sbView = snackbar.view
        val textView = sbView
                .findViewById<View>(R.id.snackbar_text) as TextView
        snackbar.show()
    }

    fun getBaseActivity() = parentActivity

    private fun performDependencyInjection() = AndroidSupportInjection.inject(this)

    interface CallBack {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }

    abstract fun setUp()
}