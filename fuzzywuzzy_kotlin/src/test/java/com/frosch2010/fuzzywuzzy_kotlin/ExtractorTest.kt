package com.frosch2010.fuzzywuzzy_kotlin

import com.frosch2010.fuzzywuzzy_kotlin.algorithms.WeightedRatio
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ExtractorTest {

    private lateinit var choices: List<String>
    private lateinit var extractor: Extractor

    @Before
    fun setUp() {
        choices = listOf("google", "bing", "facebook", "linkedin", "twitter", "googleplus", "bingnews", "plexoogl")
        extractor = Extractor()
    }

    @Test
    fun testExtractWithoutOrder() {
        val res = extractor.extractWithoutOrder("goolge", choices, WeightedRatio())

        assertEquals(choices.size, res.size)
        assertTrue(res[0].score > 0)
    }

    @Test
    fun testExtractOne() {
        val res = extractor.extractOne("goolge", choices, WeightedRatio())

        assertEquals("google", res.string)
    }

    @Test
    fun testExtractBests() {
        val res = extractor.extractTop("goolge", choices, WeightedRatio())

        assertEquals("google", res[0].string)
        assertEquals("googleplus", res[1].string)
    }

    @Test
    fun testExtractBests1() {
        val res = extractor.extractTop("goolge", choices, WeightedRatio(), 3)

        assertEquals(3, res.size)
        assertEquals("google", res[0].string)
        assertEquals("googleplus", res[1].string)
        assertEquals("plexoogl", res[2].string)
    }
}
