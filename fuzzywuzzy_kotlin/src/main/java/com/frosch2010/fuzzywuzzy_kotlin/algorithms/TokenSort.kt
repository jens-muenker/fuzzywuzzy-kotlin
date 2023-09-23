package com.frosch2010.fuzzywuzzy_kotlin.algorithms

import com.frosch2010.fuzzywuzzy_kotlin.Ratio
import com.frosch2010.fuzzywuzzy_kotlin.ToStringFunction
import java.util.Arrays

class TokenSort : RatioAlgorithm() {
    override fun apply(s1: String, s2: String, ratio: Ratio, stringFunction: ToStringFunction<String>): Int {

        val sorted1 = processAndSort(s1, stringFunction)
        val sorted2 = processAndSort(s2, stringFunction)

        return ratio.apply(sorted1, sorted2)

    }

    private fun processAndSort(input: String, stringProcessor: ToStringFunction<String>): String {
        var inputCopy = input

        inputCopy = stringProcessor.apply(inputCopy)
        val wordsArray = inputCopy.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

        val words = listOf(*wordsArray)
        val joined = Utils.sortAndJoin(words, " ")

        return joined.trim { it <= ' ' }

    }
}