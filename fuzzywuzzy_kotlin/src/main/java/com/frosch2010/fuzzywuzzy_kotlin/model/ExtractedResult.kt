package com.frosch2010.fuzzywuzzy_kotlin.model

class ExtractedResult(var string: String, val score: Int, val index: Int) :
    Comparable<ExtractedResult> {

    override fun compareTo(o: ExtractedResult): Int {
        return Integer.compare(score, o.score)
    }

    override fun toString(): String {
        return "(string: $string, score: $score, index: $index)"
    }
}