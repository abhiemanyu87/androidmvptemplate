package com.abhie.mvp.utils

import android.content.Context
import android.view.MenuItem
import androidx.annotation.ColorRes
import androidx.core.graphics.drawable.DrawableCompat
import com.abhie.mvp.R
import io.reactivex.Observable
import java.io.File
import java.text.DecimalFormat


/**
 * Static class handling common function so we don't mix unnecessary function to business logic
 */
object CommonUtil {

    fun calculateNoOfColumns(context: Context?): Int {
        val displayMetrics = context!!.resources.displayMetrics
        val dpWidth: Float = displayMetrics.widthPixels / displayMetrics.density
        val column = (dpWidth / 140).toInt()
        return if (column >= 5) 4 else column
    }

    fun getETAString(context: Context, etaInMilliSeconds: Long): String {
        if (etaInMilliSeconds < 0) {
            return ""
        }
        var seconds = (etaInMilliSeconds / 1000).toInt()
        val hours = (seconds / 3600).toLong()
        seconds -= (hours * 3600).toInt()
        val minutes = (seconds / 60).toLong()
        seconds -= (minutes * 60).toInt()
        return if (hours > 0) {
            context.getString(R.string.download_eta_hrs, hours, minutes, seconds)
        } else if (minutes > 0) {
            context.getString(R.string.download_eta_min, minutes, seconds)
        } else {
            context.getString(R.string.download_eta_sec, seconds)
        }
    }

    fun getDownloadSpeedString(context: Context, downloadedBytesPerSecond: Long): String {
        if (downloadedBytesPerSecond < 0) {
            return ""
        }
        val kb = downloadedBytesPerSecond.toDouble() / 1000.toDouble()
        val mb = kb / 1000.toDouble()
        val decimalFormat = DecimalFormat(".##")
        return if (mb >= 1) {
            context.getString(R.string.download_speed_mb, decimalFormat.format(mb))
        } else if (kb >= 1) {
            context.getString(R.string.download_speed_kb, decimalFormat.format(kb))
        } else {
            context.getString(R.string.download_speed_bytes, downloadedBytesPerSecond)
        }
    }

//    fun getCheckoutBilling(context: Context): Billing {
//
//        return Billing(context, object : Billing.DefaultConfiguration() {
//            override fun getPublicKey(): String {
//                return BuildConfig.SERVICE_KEY
//            }
//        })
//    }

    fun generateDownloadFile(context: Context, filename: String): File {
        return File(context.filesDir, filename)
    }

    fun isMagzFileExists(context: Context, filename: String): Observable<Boolean> {
        return Observable.fromCallable { File(context.filesDir, filename).exists() }
    }

    fun deleteMagzFile(context: Context, filename: String): Observable<Boolean> {
        return Observable.fromCallable {
            val file = File(context.filesDir, filename)
            if (file.exists()) {
                file.delete()
            }

            true
        }
    }

    fun tintMenuIcon(context: Context, item: MenuItem?, @ColorRes color: Int) {
        item?.let {

            val normalDrawable = it.icon
            val wrapDrawable = DrawableCompat.wrap(normalDrawable)
            DrawableCompat.setTint(wrapDrawable, context.resources.getColor(color))

            it.setIcon(wrapDrawable)
        }
    }

}