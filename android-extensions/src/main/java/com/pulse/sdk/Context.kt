package com.pulse.sdk

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import java.util.Locale

/**
 * Checks if the device is connected to the internet.
 * @return Boolean value indicating network availability.
 */
public fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnected
}

/**
 * Retrieves the height of the device screen in pixels.
 * @return Integer value representing the screen height.
 */
public fun Context.getScreenHeight(): Int {
    val displayMetrics = resources.displayMetrics
    return displayMetrics.heightPixels
}

/**
 * Retrieves the width of the device screen in pixels.
 * @return Integer value representing the screen width.
 */
public fun Context.getScreenWidth(): Int {
    val displayMetrics = resources.displayMetrics
    return displayMetrics.widthPixels
}

/**
 * Converts density-independent pixels (dp) to pixels (px).
 * @param dp Float value representing the density-independent pixels.
 * @return Float value representing the equivalent pixels.
 */
public fun Context.dpToPx(dp: Float): Float {
    val scale = resources.displayMetrics.density
    return dp * scale
}

/**
 * Converts pixels (px) to density-independent pixels (dp).
 * @param px Float value representing the pixels.
 * @return Float value representing the equivalent density-independent pixels.
 */
public fun Context.pxToDp(px: Float): Float {
    val scale = resources.displayMetrics.density
    return px / scale
}

/**
 * Retrieves the color resource with compatibility for older Android versions.
 * @param colorResId Resource ID of the color.
 * @return Integer value representing the color.
 */
public fun Context.getCompatColor(@ColorRes colorResId: Int): Int {
    return ContextCompat.getColor(this, colorResId)
}

/**
 * Retrieves the drawable resource with compatibility for older Android versions.
 * @param drawableResId Resource ID of the drawable.
 * @return Drawable object or null if not found.
 */
public fun Context.getCompatDrawable(@DrawableRes drawableResId: Int): Drawable? {
    return ContextCompat.getDrawable(this, drawableResId)
}

/**
 * Hides the soft keyboard from the screen.
 * @param view The currently focused View.
 */
public fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

/**
 * Retrieves the system's current locale.
 * @return Locale object representing the system's current locale.
 */
public fun Context.getSystemLocale(): Locale {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        resources.configuration.locales[0]
    } else {
        @Suppress("DEPRECATION")
        resources.configuration.locale
    }
}

/**
 * Opens a URL in a browser.
 * @param url String representing the URL to open.
 * @return Locale object representing the system's current locale.
 */
public fun Context.openUrl(url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(intent)
}

/**
 * Show Toast Message
 */
public fun Context.showToast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}