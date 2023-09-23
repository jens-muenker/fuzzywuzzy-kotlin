package com.frosch2010.fuzzywuzzy_kotlin.algorithms

import com.frosch2010.fuzzywuzzy_kotlin.Ratio
import com.frosch2010.fuzzywuzzy_kotlin.ToStringFunction
import com.frosch2010.fuzzywuzzy_kotlin.ratios.SimpleRatio

abstract class RatioAlgorithm : BasicAlgorithm {
    lateinit var ratio: Ratio
        internal set

    constructor() : super() {
        ratio = SimpleRatio()
    }

    constructor(stringFunction: ToStringFunction<String>) : super(stringFunction)
    constructor(ratio: Ratio) : super() {
        this.ratio = ratio
    }

    constructor(stringFunction: ToStringFunction<String>, ratio: Ratio) : super(stringFunction) {
        this.ratio = ratio
    }

    abstract fun apply(
        s1: String,
        s2: String,
        ratio: Ratio,
        stringFunction: ToStringFunction<String>
    ): Int

    fun with(ratio: Ratio): RatioAlgorithm {
        this.ratio = ratio
        return this
    }

    fun apply(s1: String, s2: String, ratio: Ratio): Int {
        return apply(s1, s2, ratio, stringFunction)
    }

    override fun apply(s1: String, s2: String, stringFunction: ToStringFunction<String>): Int {
        return apply(s1, s2, ratio, stringFunction)
    }
}