package com.tunepruner.bomboleguerodemo.instrument

class ResourceManager {
    companion object {
        fun prepareSnapshot(){
            analyzeFiles()
        }
        fun analyzeFiles(){}
        fun getGroupCount(): Int{
            TODO("Not implemented")
        }
        fun getLayerCount(group: Int): Int{
            TODO("Not implemented")
        }
        fun getRoundRobinCount(group: Int, layer: Int): Int{
            TODO("Not implemented")
        }
        fun getResource(group: Int, layer: Int, roundRobin: Int): String{
            TODO("Not implemented")
        }
    }
}