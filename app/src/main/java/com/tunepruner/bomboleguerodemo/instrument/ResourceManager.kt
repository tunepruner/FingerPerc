package com.tunepruner.bomboleguerodemo.instrument

import android.content.Context
import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager

class ResourceManager(val context: Context) {

    val fileSnapshots = ArrayList<FileSnapshot>()

    init {
        analyzeFiles(context)
    }

    private fun analyzeFiles(context: Context) {
        val assetManager: AssetManager = context.assets
        val filePaths = assetManager.list("bomboleguerosamples/")
            ?: error("AssetManager couldn't get filePaths")
        for (element in filePaths) {
            val filename: String = element
            val afd: AssetFileDescriptor =
//                assetManager.openFd("bomboleguerosamples/2_10_1_bomboleguero.wav")
                assetManager.openFd("bomboleguerosamples/$element")
            val fileSnapshot = filenameToSnapshot(filename, afd)
            fileSnapshots.add(fileSnapshot)
        }
        val testing = "sdfjl"
    }


    private fun filenameToSnapshot(fileName: String, assetFileDescriptor: AssetFileDescriptor): FileSnapshot {
        /* Example: "2_6_3_bomboleguero.wav"
        [group number]_[layer number]_[round robin number]_[library name]*/

        val fileNameMembers = fileName.split("_")
        val lastMemberWithoutExtension = fileNameMembers[3].split(".")

        return FileSnapshot(
            fileName,
            fileNameMembers[0].toInt(),
            fileNameMembers[1].toInt(),
            fileNameMembers[2].toInt(),
            lastMemberWithoutExtension[0],
            assetFileDescriptor
        )

    }

    fun getGroupCount(): Int {
        var groupCounter = 0
        for (element in fileSnapshots) {
            if (element.group > groupCounter)
                groupCounter = element.group
        }
        return groupCounter
    }

    fun getLayerCount(group: Int): Int {
        var fileSnapshotsThisGroup = ArrayList<FileSnapshot>()
        for (element in fileSnapshots) {
            if (element.group == group)
                fileSnapshotsThisGroup.add(element)

        }
        var layerCounter = 0
        for (element in fileSnapshotsThisGroup) {
            if (element.layer > layerCounter)
                layerCounter = element.layer
        }
        return layerCounter
    }

    fun getRoundRobinCount(group: Int, layer: Int): Int {
        var fileSnapshotsThisGroupAndLayer = ArrayList<FileSnapshot>()
        for (element in fileSnapshots) {
            if (element.group == group && element.layer == layer)
                fileSnapshotsThisGroupAndLayer.add(element)
        }
        var getRoundRobinCounter = 0
        for (element in fileSnapshotsThisGroupAndLayer) {
            if (element.roundRobin > getRoundRobinCounter)
                getRoundRobinCounter = element.roundRobin
        }
        return getRoundRobinCounter
    }

    fun getAssetFileDescriptor(
        group: Int,
        layer: Int,
        roundRobin: Int
    ): AssetFileDescriptor? {
        for (element in fileSnapshots) {
            if (element.group == group &&
                element.layer == layer &&
                element.roundRobin == roundRobin &&
                element.libraryName == "bomboleguero"
            )//compiler told me this is fine, but I'm not sure...not .equals? or .contains?
                return element.assetFileDescriptor
        }
        return null
    }
}

data class FileSnapshot(
    val fileName: String,
    val group: Int,
    val layer: Int,
    val roundRobin: Int,
    val libraryName: String,
    val assetFileDescriptor: AssetFileDescriptor
) {
    fun equals(toFind: FileSnapshot): Boolean {
        return toFind.group == group &&
                toFind.layer == layer &&
                toFind.roundRobin == roundRobin &&
                toFind.libraryName.contains(libraryName)//compiler told me this is fine, but I'm not sure...not .equals? or .contains?
    }
}
