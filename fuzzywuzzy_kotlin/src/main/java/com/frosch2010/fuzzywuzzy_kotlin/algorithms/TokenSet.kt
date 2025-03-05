package com.frosch2010.fuzzywuzzy_kotlin.algorithms

import com.frosch2010.fuzzywuzzy_kotlin.Ratio
import com.frosch2010.fuzzywuzzy_kotlin.ToStringFunction
import java.util.Collections

class TokenSet : RatioAlgorithm() {
    override fun apply(
        s1: String,
        s2: String,
        ratio: Ratio,
        stringFunction: ToStringFunction<String>
    ): Int {
        var s1 = s1
        var s2 = s2
        s1 = stringFunction.apply(s1)
        s2 = stringFunction.apply(s2)
        val tokens1 = Utils.tokenizeSet(s1)
        val tokens2 = Utils.tokenizeSet(s2)
        val intersection = SetUtils.intersection(tokens1, tokens2)
        val diff1to2 = SetUtils.difference(tokens1, tokens2)
        val diff2to1 = SetUtils.difference(tokens2, tokens1)
        val sortedInter = Utils.sortAndJoin(intersection, " ").trim { it <= ' ' }
        val sorted1to2 = (sortedInter + " " + Utils.sortAndJoin(diff1to2, " ")).trim { it <= ' ' }
        val sorted2to1 = (sortedInter + " " + Utils.sortAndJoin(diff2to1, " ")).trim { it <= ' ' }
        val results: MutableList<Int> = ArrayList()
        results.add(ratio.apply(sortedInter, sorted1to2))
        results.add(ratio.apply(sortedInter, sorted2to1))
        results.add(ratio.apply(sorted1to2, sorted2to1))
        return Collections.max(results)
    }
}