package com.frosch2010.fuzzywuzzy_kotlin.algorithms

import com.frosch2010.fuzzywuzzy_kotlin.StringProcessor

@Deprecated("Use {@code ToStringFunction#NO_PROCESS} instead.")
class NoProcess : StringProcessor() {
    @Deprecated("")
    override fun process(`in`: String?): String {
        return `in`!!
    }
}