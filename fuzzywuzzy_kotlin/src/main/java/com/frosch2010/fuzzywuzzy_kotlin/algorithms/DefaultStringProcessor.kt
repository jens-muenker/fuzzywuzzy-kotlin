package com.frosch2010.fuzzywuzzy_kotlin.algorithms

import com.frosch2010.fuzzywuzzy_kotlin.StringProcessor
import java.util.Locale
import java.util.regex.Pattern

@Deprecated("Use {@code DefaultStringFunction} instead.")
class DefaultStringProcessor : StringProcessor() {
    /**
     * Performs the default string processing on the input string
     *
     * @param in Input string
     * @return The processed string
     */
    override fun process(`in`: String?): String {
        var `in` = `in`
        `in` = subNonAlphaNumeric(`in`, " ")
        `in` = `in`!!.lowercase(Locale.getDefault())
        `in` = `in`.trim { it <= ' ' }
        return `in`
    }

    companion object {
        private const val pattern = "[^\\p{Alnum}]"
        private val r = compilePattern()

        /**
         * Substitute non alphanumeric characters.
         *
         * @param in The input string
         * @param sub The string to substitute with
         * @return The replaced string
         */
        fun subNonAlphaNumeric(`in`: String?, sub: String?): String? {
            val m = r.matcher(`in`)
            return if (m.find()) {
                m.replaceAll(sub)
            } else {
                `in`
            }
        }

        private fun compilePattern(): Pattern {
            val p: Pattern = try {
                Pattern.compile(pattern, Pattern.UNICODE_CHARACTER_CLASS)
            } catch (e: IllegalArgumentException) {
                // Even though Android supports the unicode pattern class
                // for some reason it throws an IllegalArgumentException
                // if we pass the flag like on standard Java runtime
                //
                // We catch this and recompile without the flag (unicode should still work)
                Pattern.compile(pattern)
            }
            return p
        }
    }
}