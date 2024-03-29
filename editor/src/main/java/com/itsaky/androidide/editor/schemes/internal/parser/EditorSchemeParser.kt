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

package com.itsaky.androidide.editor.schemes.internal.parser

import androidx.core.util.set
import com.google.gson.stream.JsonReader
import com.itsaky.androidide.editor.schemes.IDEColorScheme
import com.itsaky.androidide.editor.schemes.internal.parser.SchemeParser.EditorColors

/**
 * Parses editor scheme from a JSON color scheme file.
 *
 * @author Akash Yadav
 */
class EditorSchemeParser(private val reader: JsonReader) {
  
  fun parse(scheme: IDEColorScheme) {
    scheme.apply {
      reader.beginObject()
      while (reader.hasNext()) {
        val color = EditorColors.forKey(reader.nextName())
        val value = reader.nextString()
        editorScheme[color.id] = parseColorValue(value, false)
      }
      reader.endObject()
    }
  }
}