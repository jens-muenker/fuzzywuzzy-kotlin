package com.frosch2010.fuzzywuzzy_kotlin.algorithms

import com.frosch2010.fuzzywuzzy_kotlin.ToStringFunction
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.*

class WeightedRatioTest {

    @Test
    fun testUsesStringProcessor() {
        val wr = WeightedRatio()

        val mock: ToStringFunction<String> = mock(ToStringFunction::class.java) as ToStringFunction<String>

        `when`(mock.apply(anyString())).thenReturn("thesame")

        assertEquals(100, wr.apply("notthesame", "thesame", mock))
    }

    @Test
    fun testWRatio() {
        assertEquals(68, WeightedRatio().apply("test", "pesticide"))
    }
}
