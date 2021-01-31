package com.tunepruner.bomboleguerodemo.instrument

interface ResourceManager {
    fun prepareSnapshot()
    fun analyzeFiles()
    fun getGroupCount()
    fun getLayerCount(group: Int)
    fun getRoundRobinCount(group: Int, layer: Int)
    fun getResource(group: Int, layer: Int, roundRobin: Int)
}