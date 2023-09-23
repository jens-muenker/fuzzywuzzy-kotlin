package com.frosch2010.fuzzywuzzy_kotlin.algorithms

import com.frosch2010.fuzzywuzzy_kotlin.Ratio
import com.frosch2010.fuzzywuzzy_kotlin.ToStringFunction
import com.frosch2010.fuzzywuzzy_kotlin.ratios.PartialRatio
import com.frosch2010.fuzzywuzzy_kotlin.ratios.SimpleRatio
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.*

class TokenSortTest {

    @Test
    fun testUsesStringProcessor() {
        val ts = TokenSort()
        val mock: ToStringFunction<String> = mock(ToStringFunction::class.java) as ToStringFunction<String>

        `when`(mock.apply(anyString())).thenReturn("thesame")

        assertEquals(100, ts.apply("notthesame", "thesame", mock))
    }

    @Test
    fun testUsesRatio() {
        val ts = TokenSort()
        val mock = mock(Ratio::class.java)

        `when`(mock.apply(anyString(), anyString())).thenReturn(0)

        assertEquals(0, ts.apply("one two", "one three", mock))
    }

    @Test
    fun testTokenSort() {
        val ts = TokenSort()

        assertEquals(75, ts.apply("test", "pesticide", PartialRatio()))
        assertEquals(46, ts.apply("test", "pesticide", SimpleRatio()))
    }
}
