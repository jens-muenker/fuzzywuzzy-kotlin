package com.frosch2010.fuzzywuzzy_kotlin.diffutils

class EditOp {
    var type: EditType? = null
    var spos = 0 // source block pos
    var dpos = 0 // destination block pos
    override fun toString(): String {
        return type!!.name + "(" + spos + "," + dpos + ")"
    }
}