package com.frosch2010.fuzzywuzzy_kotlin.algorithms

import org.junit.Test
import org.junit.Assert.assertEquals

class DefaultStringProcessorTest {

    @Test
    fun testProcess() {
        val inp = "s.trim μεγιουνικουντ n/o/n a.lph.a n.um"
        assertEquals("s trim μεγιουνικουντ n o n a lph a n um", DefaultStringFunction().apply(inp))
    }
}