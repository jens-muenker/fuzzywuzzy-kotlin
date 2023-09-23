package com.frosch2010.fuzzywuzzy_kotlin

import com.frosch2010.fuzzywuzzy_kotlin.algorithms.DefaultStringFunction
import org.junit.Assert.assertEquals
import org.junit.Test

class DefaultStringProcessorTest {

    @Test
    fun testProcess() {
        val inp = "s.trim μεγιουνικουντ n/o/n a.lph.a n.um"
        assertEquals("s trim μεγιουνικουντ n o n a lph a n um", DefaultStringFunction().apply(inp))
    }

}
