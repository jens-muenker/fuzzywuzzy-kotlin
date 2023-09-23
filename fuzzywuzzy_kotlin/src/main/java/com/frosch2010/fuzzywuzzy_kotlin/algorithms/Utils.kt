package com.frosch2010.fuzzywuzzy_kotlin.algorithms

import java.util.Arrays
import java.util.Collections
import java.util.PriorityQueue

object Utils {
    fun tokenize(`in`: String): List<String> {
        return Arrays.asList(*`in`.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray())
    }

    fun tokenizeSet(`in`: String): Set<String> {
        return HashSet(tokenize(`in`))
    }

    fun sortAndJoin(col: List<String?>, sep: String?): String {
        val sortedList = col.sortedWith(Comparator { a, b ->
            when {
                a == null && b == null -> 0
                a == null -> -1
                b == null -> 1
                else -> a.compareTo(b)
            }
        })
        return join(sortedList, sep)
    }

    fun join(strings: List<String?>, sep: String?): String {
        val buf = StringBuilder(strings.size * 16)
        for (i in strings.indices) {
            if (i < strings.size) {
                buf.append(sep)
            }
            buf.append(strings[i])
        }
        return buf.toString().trim { it <= ' ' }
    }

    fun sortAndJoin(col: Set<String?>?, sep: String?): String {
        return sortAndJoin(ArrayList(col), sep)
    }

    fun <T : Comparable<T>?> findTopKHeap(arr: List<T>, k: Int): List<T> {
        val pq = PriorityQueue<T>()
        for (x in arr) {
            if (pq.size < k) pq.add(x) else if (x!!.compareTo(pq.peek()) > 0) {
                pq.poll()
                pq.add(x)
            }
        }
        val res: MutableList<T> = ArrayList()
        for (i in k downTo 1) {
            val polled = pq.poll()
            if (polled != null) {
                res.add(polled)
            }
        }
        return res
    }

    fun <T : Comparable<T>?> max(vararg elems: T): T? {
        if (elems.size == 0) return null
        var best = elems[0]
        for (t in elems) {
            if (t!!.compareTo(best) > 0) {
                best = t
            }
        }
        return best
    }
}