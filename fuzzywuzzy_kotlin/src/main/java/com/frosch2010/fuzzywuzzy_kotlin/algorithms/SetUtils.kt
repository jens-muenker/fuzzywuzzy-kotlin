package com.frosch2010.fuzzywuzzy_kotlin.algorithms

internal object SetUtils {
    fun <T> intersection(s1: Set<T>?, s2: Set<T>?): Set<T> {
        val intersection: MutableSet<T> = HashSet(s1)
        intersection.retainAll(s2!!)
        return intersection
    }

    fun <T> difference(s1: Set<T>?, s2: Set<T>?): Set<T> {
        val difference: MutableSet<T> = HashSet(s1)
        difference.removeAll(s2!!)
        return difference
    }
}