package com.frosch2010.fuzzywuzzy_kotlin.diffutils

class MatchingBlock {
    var spos = 0
    var dpos = 0
    var length = 0
    override fun toString(): String {
        return "($spos,$dpos,$length)"
    }
}