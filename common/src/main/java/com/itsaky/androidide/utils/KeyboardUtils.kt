/*
 *  This file is part of AndroidIDE.
 *
 *  AndroidIDE is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  AndroidIDE is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with AndroidIDE.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.itsaky.androidide.utils

import android.content.Context
import android.content.res.Configuration
import android.inputmethodservice.InputMethodService

/**
 * @author Akash Yadav
 */
object KeyboardUtils {

  /**
   * Check if hardware keyboard is connected.
   * Based on default implementation of [InputMethodService.onEvaluateInputViewShown].
   *
   * https://developer.android.com/guide/topics/resources/providing-resources#ImeQualifier
   *
   * @param context The Context for operations.
   * @return Returns `true` if device has hardware keys for text input or an external hardware
   * keyboard is connected, otherwise `false`.
   */
  fun isHardKeyboardConnected(context: Context?): Boolean {
    if (context == null) return false
    val config = context.resources.configuration
    return (config.keyboard != Configuration.KEYBOARD_NOKEYS
        || config.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO)
  }
}