package com.frosch2010.fuzzywuzzy_kotlin.diffutils

class OpCode {
    var type: EditType? = null
    var sbeg = 0
    var send = 0
    var dbeg = 0
    var dend = 0
    override fun toString(): String {
        return (type!!.name + "(" + sbeg + "," + send + ","
                + dbeg + "," + dend + ")")
    }
}