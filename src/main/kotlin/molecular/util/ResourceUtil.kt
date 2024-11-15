package molecular.util

import com.google.gson.JsonElement
import com.google.gson.JsonParser
import molecular.api.Chemical
import molecular.api.Element
import java.io.File

object ResourceUtil {
    /**
     * returns all files in a resource directory
     * @return a [ArrayList] of every non directory [File]
     */
    fun getFilesInDir(path: String): ArrayList<File> {
        // if the path does not exist, throw
        if(object{}.javaClass.getResource(path) == null)
            throw Exception("COULD NOT FIND PATH: ${path}")

        // get the directory
        val dir = File(object{}.javaClass.getResource(path)!!.file)

        val fileList = arrayListOf<File>()
        // then walk over all the files
        dir.walk().forEach{f ->
            // add all non directories to the list
            if(!f.isDirectory)
                fileList.add(f)
        }

        return fileList
    }

    /**
     * convert a json [File] to a [JsonElement]
     * @param file the [File] to convert
     * @return a [JsonElement] after the file's reader has been passed to [JsonParser.parseReader]
     */
    fun fileToJson(file: File): JsonElement = JsonParser.parseReader(file.inputStream().reader())

    /**
     * converts a json file to an [molecular.api.Element]
     * TODO: use one of the serialization libraries properly ( kotlinx/gson )
     * @param file the [File] that is being serialized
     * @return the [molecular.api.Element] with the data from the file
     */
    fun jsonToElement(jsonElement: JsonElement): Element {
        // convert the file to a gson jsonobject
        val json = jsonElement.asJsonObject

        val transKey = json.get("name").asString
        val phase = Chemical.Phase.fromString(json.get("phase").asString) // needs to be looked up since phase is an enum
        val meltingPoint = json.get("meltingPoint").asFloat
        val boilingPoint = json.get("boilingPoint").asFloat
        val colour = json.get("colour").asString.toInt(16) // it is a hex string so it needs conversion
        val symbol = json.get("symbol").asString
        val atomicMass = json.get("atomicMass").asFloat
        val atomicNumber = json.get("atomicNumber").asInt
        val family = Element.TableFamily.fromString(json.get("family").asString) // needs lookup due to being enum

        if(phase == null || family == null)
            throw Exception("phase or family is incorrect for element: $transKey !!")

        return Element(transKey, phase, meltingPoint, boilingPoint, colour, symbol, atomicMass, atomicNumber, family)
    }
}