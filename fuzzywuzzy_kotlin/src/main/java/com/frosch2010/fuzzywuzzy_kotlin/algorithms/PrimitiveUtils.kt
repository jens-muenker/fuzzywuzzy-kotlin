package com.frosch2010.fuzzywuzzy_kotlin.algorithms

internal object PrimitiveUtils {
    fun max(vararg elems: Double): Double {
        if (elems.size == 0) return 0.0
        var best = elems[0]
        for (t in elems) {
            if (t > best) {
                best = t
            }
        }
        return best
    }

    fun max(vararg elems: Int): Int {
        if (elems.size == 0) return 0
        var best = elems[0]
        for (t in elems) {
            if (t > best) {
                best = t
            }
        }
        return best
    }
}