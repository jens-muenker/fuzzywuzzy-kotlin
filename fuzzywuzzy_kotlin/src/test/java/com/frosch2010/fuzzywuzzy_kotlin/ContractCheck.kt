package com.frosch2010.fuzzywuzzy_kotlin

import com.frosch2010.fuzzywuzzy_kotlin.FuzzySearch.extractAll
import com.frosch2010.fuzzywuzzy_kotlin.FuzzySearch.extractOne
import com.frosch2010.fuzzywuzzy_kotlin.FuzzySearch.extractSorted
import com.frosch2010.fuzzywuzzy_kotlin.FuzzySearch.extractTop
import com.frosch2010.fuzzywuzzy_kotlin.FuzzySearch.partialRatio
import com.frosch2010.fuzzywuzzy_kotlin.FuzzySearch.ratio
import com.frosch2010.fuzzywuzzy_kotlin.FuzzySearch.tokenSetPartialRatio
import com.frosch2010.fuzzywuzzy_kotlin.FuzzySearch.tokenSetRatio
import com.frosch2010.fuzzywuzzy_kotlin.FuzzySearch.tokenSortPartialRatio
import com.frosch2010.fuzzywuzzy_kotlin.FuzzySearch.tokenSortRatio
import com.frosch2010.fuzzywuzzy_kotlin.FuzzySearch.weightedRatio
import com.frosch2010.fuzzywuzzy_kotlin.algorithms.WeightedRatio

class ContractCheck {
    /**
     * Test that the public interface contract is met, to ensure no backwards
     * compatibility breaking changes. The test only ensures type safety
     * at compilation time, the rest of the tests are needed for
     * functionality testing.
     */
    /*fun testContract() {
        val ratio = ratio("mysmilarstring", "myawfullysimilarstirng")
        val i = partialRatio("mysmilarstring", "myawfullysimilarstirng")
        val sample = ArrayList<String>()
        val order_words_out_of = tokenSortPartialRatio("order words out of", "  words out of order")
        val order_words_out_of1 = tokenSortRatio("order words out of", "  words out of order")
        val i1 = tokenSetRatio("fuzzy was a bear", "fuzzy fuzzy fuzzy bear")
        val i2 = tokenSetPartialRatio("fuzzy was a bear", "fuzzy fuzzy fuzzy bear")
        val i3 = weightedRatio(
            "The quick brown fox jimps ofver the small lazy dog",
            "the quick brown fox jumps over the small lazy dog"
        )
        val weighted = WeightedRatio()
        weighted.with(object : StringProcessor() {
            override fun process(`in`: String?): String {
                return `in`!!
            }
        })
        val one = extractOne("cowboys", sample)
        val e1 = extractTop("goolge", sample, weighted, 3)
        val e2 = extractAll("goolge", sample)
        val e3 = extractAll("goolge", sample, 40)
        val e4 = extractSorted("goolge", sample)
        val e5 = extractSorted("goolge", sample, 3)
    }*/
}