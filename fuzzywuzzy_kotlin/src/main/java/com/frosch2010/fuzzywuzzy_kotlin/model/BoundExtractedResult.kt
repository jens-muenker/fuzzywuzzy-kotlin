package com.frosch2010.fuzzywuzzy_kotlin.model

class BoundExtractedResult<T>(val referent: T, var string: String, val score: Int, val index: Int) :
    Comparable<BoundExtractedResult<T>> {

    override fun toString(): String {
        return "(string: $string, score: $score, index: $index)"
    }

    override fun compareTo(o: BoundExtractedResult<T>): Int {
        return Integer.compare(score, o.score)
    }
}