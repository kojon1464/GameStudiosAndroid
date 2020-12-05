package com.example.gamedesigners.data

class DesignerEntry(val id: Int, val logoId: Int, val name: String, val sizeId: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DesignerEntry

        if (id != other.id) return false
        if (logoId != other.logoId) return false
        if (name != other.name) return false
        if (sizeId != other.sizeId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + logoId
        result = 31 * result + name.hashCode()
        result = 31 * result + sizeId
        return result
    }
}