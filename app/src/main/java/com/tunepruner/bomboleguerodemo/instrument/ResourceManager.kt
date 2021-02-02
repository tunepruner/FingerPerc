package com.tunepruner.bomboleguerodemo.instrument

import java.io.File

class ResourceManager {
    companion object {
        lateinit var fileSnapshots: ArrayList<FileSnapshot>

        fun prepareSnapshot() {
            analyzeFiles()
        }

        private fun analyzeFiles() {
            val dirPath = File("./assets/bombolegurosamples")/*TODO figure this out for sure*/
            val filePaths = dirPath.listFiles()
            for (i in 0..filePaths.size) {
                val file: File = filePaths[i]
                val fileSnapshot = filenameToSnapshot(file.name, file.absolutePath)
                fileSnapshots.add(fileSnapshot)
            }
        }


        private fun filenameToSnapshot(fileName: String, path: String): FileSnapshot {
            /* Example: "2_6_3_bomboleguero.wav"
            [group number]_[layer number]_[round robin number]_[library name]*/

            val fileNameMembers = fileName.split("_")
            return FileSnapshot(
                fileName,
                fileNameMembers[0].toInt(),
                fileNameMembers[1].toInt(),
                fileNameMembers[2].toInt(),
                fileNameMembers[3],
                path
            )
        }

        fun getGroupCount(): Int {
            var groupCounter = 0
            for (fileSnapshot: FileSnapshot in fileSnapshots) {
                if (fileSnapshot.group > groupCounter)
                    groupCounter = fileSnapshot.group
            }
            return groupCounter
        }

        fun getLayerCount(group: Int): Int {
            var layerCounter = 0
            for (fileSnapshot: FileSnapshot in fileSnapshots) {
                if (fileSnapshot.group == group)
                    layerCounter++
            }
            return layerCounter
        }

        fun getRoundRobinCount(group: Int, layer: Int): Int {
            var roundRobinCounter = 0
            for (fileSnapshot: FileSnapshot in fileSnapshots) {
                if (fileSnapshot.group == group && fileSnapshot.layer == layer)
                    roundRobinCounter++
            }
            return roundRobinCounter
        }

        fun getResourcePath(group: Int, layer: Int, roundRobin: Int): String? {
            return fileSnapshots
                .find {
                    equals(
                        FileSnapshot("", group, layer, roundRobin, "bomboleguro", "")
                    )
                }
                ?.path
        }
    }
}

data class FileSnapshot(
    val fileName: String,
    val group: Int,
    val layer: Int,
    val roundRobin: Int,
    val libraryName: String,
    val path: String
) {
    fun equals(toFind: FileSnapshot): Boolean {
        return toFind.group == group &&
                toFind.layer == layer &&
                toFind.roundRobin == roundRobin &&
                toFind.libraryName == libraryName//compiler told me this is fine, but I'm not sure...not .equals? or .contains?
    }
}
