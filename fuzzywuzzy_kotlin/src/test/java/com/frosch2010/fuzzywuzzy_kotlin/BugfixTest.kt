package com.frosch2010.fuzzywuzzy_kotlin

import org.junit.Assert.assertEquals
import org.junit.Test

class BugfixTest {
    @Test
    fun testIssue39() {
        val score = FuzzySearch.partialRatio("kaution",
            "kdeffxxxiban:de1110010060046666666datum:16.11.17zeit:01:12uft0000899999tan076601testd.-20-maisonette-z4-jobas-hagkautionauszug")

        assertEquals(100, score)
    }
}
