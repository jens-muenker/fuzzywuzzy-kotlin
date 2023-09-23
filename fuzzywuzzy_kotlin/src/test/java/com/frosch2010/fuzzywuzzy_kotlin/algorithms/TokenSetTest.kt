package com.frosch2010.fuzzywuzzy_kotlin.algorithms

import com.frosch2010.fuzzywuzzy_kotlin.Ratio
import com.frosch2010.fuzzywuzzy_kotlin.ToStringFunction
import com.frosch2010.fuzzywuzzy_kotlin.ratios.PartialRatio
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`


class TokenSetTest {

    @Test
    fun testUsesStringProcessor() {
        val ts = TokenSet()
        val mock: ToStringFunction<String> = mock(ToStringFunction::class.java) as ToStringFunction<String>

        `when`(mock.apply(Mockito.anyString())).thenReturn("thesame")

        assertEquals(100, ts.apply("notthesame", "thesame", mock))
    }

    @Test
    fun testUsesRatio() {
        val ts = TokenSet()
        val mock = mock(Ratio::class.java)

        `when`(mock.apply(Mockito.anyString(), Mockito.anyString())).thenReturn(0)

        assertEquals(0, ts.apply("one two", "one three", mock as Ratio))
    }

    @Test
    fun testTokenSet() {
        val ts = TokenSet()

        assertEquals(46, ts.apply("test", "pesticide"))
        assertEquals(75, ts.apply("test", "pesticide", PartialRatio()))
    }
}