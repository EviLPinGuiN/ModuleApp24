package com.itis.template.feature.home.data.datasource.memory

import com.itis.template.feature.home.api.model.Home

internal class MemoryHomeDataSource {

    private val cache: MutableMap<String, Home> = hashMapOf() // LruCache

    fun add(home: Home) = cache.put(home.id, home)

    fun get(id: String) = cache[id]

    fun clear() = cache.clear()
}