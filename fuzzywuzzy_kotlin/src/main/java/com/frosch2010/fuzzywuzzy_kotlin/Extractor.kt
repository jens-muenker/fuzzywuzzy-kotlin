package com.frosch2010.fuzzywuzzy_kotlin

import com.frosch2010.fuzzywuzzy_kotlin.algorithms.Utils
import com.frosch2010.fuzzywuzzy_kotlin.model.BoundExtractedResult
import com.frosch2010.fuzzywuzzy_kotlin.model.ExtractedResult
import java.util.Collections


class Extractor {
    var cutoff: Int

    constructor() {
        cutoff = 0
    }

    constructor(cutoff: Int) {
        this.cutoff = cutoff
    }

    fun with(cutoff: Int): Extractor {
        this.cutoff = cutoff
        return this
    }

    /**
     * Returns the list of choices with their associated scores of similarity in a list
     * of [ExtractedResult]
     *
     * @param query The query string
     * @param choices The list of choices
     * @param func The function to apply
     * @return The list of results
     */
    fun extractWithoutOrder(
        query: String, choices: Collection<String>,
        func: Applicable
    ): List<ExtractedResult> {
        val yields: MutableList<ExtractedResult> = ArrayList()
        for ((index, s) in choices.withIndex()) {
            val score = func.apply(query, s)
            if (score >= cutoff) {
                ExtractedResult(s, score, index).let { yields.add(it) }
            }
        }
        return yields
    }

    /**
     * Returns the list of choices with their associated scores of similarity in a list
     * of [ExtractedResult]
     *
     * @param query The query string
     * @param choices The list of choices
     * @param toStringFunction The ToStringFunction to be applied to all choices.
     * @param func The function to apply
     * @return The list of results
     */
    fun <T> extractWithoutOrder(
        query: String, choices: Collection<T>,
        toStringFunction: ToStringFunction<T>, func: Applicable
    ): List<BoundExtractedResult<T>> {
        val yields: MutableList<BoundExtractedResult<T>> = ArrayList()
        for ((index, t) in choices.withIndex()) {
            val s = toStringFunction.apply(t)
            val score = func.apply(query, s)
            if (score >= cutoff) {
                yields.add(BoundExtractedResult(t, s, score, index))
            }
        }
        return yields
    }

    /**
     * Find the single best match above a score in a list of choices.
     *
     * @param query  A string to match against
     * @param choices A list of choices
     * @param func   Scoring function
     * @return An object containing the best match and it's score
     */
    fun extractOne(
        query: String,
        choices: Collection<String>,
        func: Applicable
    ): ExtractedResult {
        val extracted = extractWithoutOrder(query, choices, func)
        return extracted.max()
    }

    /**
     * Find the single best match above a score in a list of choices.
     *
     * @param query  A string to match against
     * @param choices A list of choices
     * @param toStringFunction The ToStringFunction to be applied to all choices.
     * @param func   Scoring function
     * @return An object containing the best match and it's score
     */
    fun <T : Any> extractOne(
        query: String, choices: Collection<T>, toStringFunction: ToStringFunction<T>,
        func: Applicable
    ): BoundExtractedResult<T> {
        val extracted = extractWithoutOrder(
            query, choices, toStringFunction,
            func
        )
        return Collections.max(extracted)
    }

    /**
     * Creates a **sorted** list of [ExtractedResult]  which contain the
     * top @param limit most similar choices
     *
     * @param query   The query string
     * @param choices A list of choices
     * @param func    The scoring function
     * @return A list of the results
     */
    fun extractTop(
        query: String,
        choices: Collection<String>,
        func: Applicable
    ): List<ExtractedResult> {
        val best = extractWithoutOrder(query, choices, func)
        Collections.sort(best, Collections.reverseOrder())
        return best
    }

    /**
     * Creates a **sorted** list of [ExtractedResult]  which contain the
     * top @param limit most similar choices
     *
     * @param query   The query string
     * @param choices A list of choices
     * @param toStringFunction The ToStringFunction to be applied to all choices.
     * @param func    The scoring function
     * @return A list of the results
     */
    fun <T> extractTop(
        query: String, choices: Collection<T>,
        toStringFunction: ToStringFunction<T>, func: Applicable
    ): List<BoundExtractedResult<T>> {
        val best = extractWithoutOrder(query, choices, toStringFunction, func)
        Collections.sort(best, Collections.reverseOrder())
        return best
    }

    /**
     * Creates a **sorted** list of [ExtractedResult] which contain the
     * top @param limit most similar choices
     *
     * @param query   The query string
     * @param choices A list of choices
     * @param limit   Limits the number of results and speeds up
     * the search (k-top heap sort) is used
     * @return A list of the results
     */
    fun extractTop(
        query: String,
        choices: Collection<String>,
        func: Applicable,
        limit: Int
    ): List<ExtractedResult> {
        val best = extractWithoutOrder(query, choices, func)
        val results = Utils.findTopKHeap(best, limit)
        Collections.reverse(results)
        return results
    }

    /**
     * Creates a **sorted** list of [ExtractedResult] which contain the
     * top @param limit most similar choices
     *
     * @param query   The query string
     * @param choices A list of choices
     * @param toStringFunction The ToStringFunction to be applied to all choices.
     * @param limit   Limits the number of results and speeds up
     * the search (k-top heap sort) is used
     * @return A list of the results
     */
    fun <T> extractTop(
        query: String, choices: Collection<T>,
        toStringFunction: ToStringFunction<T>, func: Applicable, limit: Int
    ): List<BoundExtractedResult<T>> {
        val best = extractWithoutOrder(query, choices, toStringFunction, func)
        val results = Utils.findTopKHeap(best, limit)
        Collections.reverse(results)
        return results
    }
}