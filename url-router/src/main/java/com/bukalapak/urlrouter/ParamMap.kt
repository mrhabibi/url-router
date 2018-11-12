package com.bukalapak.urlrouter

import java.util.*

/**
 * Created by mrhabibi on 5/26/17.
 * Extension class of HashMap as container class for parsed variables and queries
 */

open class ParamMap : HashMap<String, List<String>>() {

    @Deprecated("Don't use default's for preventing null value")
    override fun get(key: String): List<String>? = super.get(key)

    fun put(key: String, value: String): List<String>? {
        return super.put(key, Arrays.asList(value))
    }

    fun getString(key: String): String? = if (containsKey(key)) {
        super.get(key)?.firstOrNull()
    } else null

    fun getLong(key: String): Long? = if (containsKey(key)) {
        try {
            super.get(key)?.firstOrNull()?.toLong()
        } catch (ex: Exception) {
            0L
        }
    } else null

    fun getInt(key: String): Int? = if (containsKey(key)) {
        try {
            super.get(key)?.firstOrNull()?.toInt()
        } catch (ex: Exception) {
            0
        }
    } else null

    fun getFloat(key: String): Float? = if (containsKey(key)) {
        try {
            super.get(key)?.firstOrNull()?.toFloat()
        } catch (ex: Exception) {
            0.0F
        }
    } else null

    fun getDouble(key: String): Double? = if (containsKey(key)) {
        try {
            super.get(key)?.firstOrNull()?.toDouble()
        } catch (ex: Exception) {
            0.0
        }
    } else null

    fun getBoolean(key: String): Boolean? = if (containsKey(key)) {
        val value = super.get(key)?.firstOrNull()
        !value.equals("false", true) && !value.equals("0", true)
    } else null
}

open class OptParamMap : ParamMap() {

    fun optString(key: String): String = if (containsKey(key)) {
        super.get(key)?.firstOrNull() ?: ""
    } else ""

    fun optLong(key: String): Long = if (containsKey(key)) {
        try {
            super.get(key)?.firstOrNull()?.toLong() ?: 0L
        } catch (ex: Exception) {
            0L
        }
    } else 0L

    fun optInt(key: String): Int = if (containsKey(key)) {
        try {
            super.get(key)?.firstOrNull()?.toInt() ?: 0
        } catch (ex: Exception) {
            0
        }
    } else 0

    fun optFloat(key: String): Float = if (containsKey(key)) {
        try {
            super.get(key)?.firstOrNull()?.toFloat() ?: 0.0F
        } catch (ex: Exception) {
            0.0F
        }
    } else 0.0F

    fun optDouble(key: String): Double = if (containsKey(key)) {
        try {
            super.get(key)?.firstOrNull()?.toDouble() ?: 0.0
        } catch (ex: Exception) {
            0.0
        }
    } else 0.0

    fun optBoolean(key: String): Boolean = if (containsKey(key)) {
        val value = super.get(key)?.firstOrNull()
        !value.equals("false", true) && !value.equals("0", true)
    } else false
}

open class ParamsMap : OptParamMap() {

    fun getStringList(key: String): List<String>? = if (containsKey(key)) {
        super.get(key)
    } else null

    fun getLongList(key: String): List<Long>? = if (containsKey(key)) {
        try {
            super.get(key)?.map { it.toLong() }
        } catch (ex: Exception) {
            emptyList<Long>()
        }
    } else null

    fun getIntList(key: String): List<Int>? = if (containsKey(key)) {
        try {
            super.get(key)?.map { it.toInt() }
        } catch (ex: Exception) {
            emptyList<Int>()
        }
    } else null

    fun getFloatList(key: String): List<Float>? = if (containsKey(key)) {
        try {
            super.get(key)?.map { it.toFloat() }
        } catch (ex: Exception) {
            emptyList<Float>()
        }
    } else null

    fun getDoubleList(key: String): List<Double>? = if (containsKey(key)) {
        try {
            super.get(key)?.map { it.toDouble() }
        } catch (ex: Exception) {
            emptyList<Double>()
        }
    } else null

    fun getBooleanList(key: String): List<Boolean>? = if (containsKey(key)) {
        super.get(key)?.map { !it.equals("false", true) && !it.equals("0", true) } ?: emptyList()
    } else null
}

@Suppress("DEPRECATION")
class OptParamsMap : ParamsMap() {

    fun optStringList(key: String): List<String> = if (containsKey(key)) {
        super.get(key) ?: emptyList()
    } else emptyList()

    fun optLongList(key: String): List<Long> = if (containsKey(key)) {
        try {
            super.get(key)?.map { it.toLong() } ?: emptyList()
        } catch (ex: Exception) {
            emptyList<Long>()
        }
    } else emptyList()

    fun optIntList(key: String): List<Int> = if (containsKey(key)) {
        try {
            super.get(key)?.map { it.toInt() } ?: emptyList()
        } catch (ex: Exception) {
            emptyList<Int>()
        }
    } else emptyList()

    fun optFloatList(key: String): List<Float> = if (containsKey(key)) {
        try {
            super.get(key)?.map { it.toFloat() } ?: emptyList()
        } catch (ex: Exception) {
            emptyList<Float>()
        }
    } else emptyList()

    fun optDoubleList(key: String): List<Double> = if (containsKey(key)) {
        try {
            super.get(key)?.map { it.toDouble() } ?: emptyList()
        } catch (ex: Exception) {
            emptyList<Double>()
        }
    } else emptyList()

    fun optBooleanList(key: String): List<Boolean> = if (containsKey(key)) {
        super.get(key)?.map { !it.equals("false", true) && !it.equals("0", true) } ?: emptyList()
    } else emptyList()
}