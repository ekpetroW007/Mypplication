package com.example.myapplication.presentation

import android.content.Context
import android.content.Intent
import androidx.core.content.FileProvider
import com.example.myapplication.data.database.entity.DrugEntity
import com.example.myapplication.data.database.entity.PlantEntity
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FileWriter

class GardenExporter(private val context: Context) {

    fun exportGarden(plants: List<PlantEntity>, drugs: List<DrugEntity>) {
        // Создаем JSON-объект
        val gardenJson = JSONObject().apply {
            put("plants", JSONArray().apply {
                plants.forEach { plant ->
                    put(JSONObject().apply {
                        put("id", plant.id)
                        put("name", plant.plantName)
                        put("task", plant.taskName)
                        put("period", plant.period)
                    })
                }
            })
            put("drugs", JSONArray().apply {
                drugs.forEach { drug ->
                    put(JSONObject().apply {
                        put("id", drug.id)
                        put("name", drug.name)
                        put("dosage", drug.purpose)
                        put("usage", drug.consumptionRate)
                    })
                }
            })
        }

        // Сохраняем файл
        val file = createFile(gardenJson.toString())
        shareFile(file)
    }

    private fun createFile(jsonString: String): File {
        val directory = File(context.getExternalFilesDir(null), "exports")
        if (!directory.exists()) directory.mkdirs()

        val file = File(directory, "garden_export_${System.currentTimeMillis()}.json")
        FileWriter(file).use { it.write(jsonString) }
        return file
    }

    private fun shareFile(file: File) {
        val uri = FileProvider.getUriForFile(
            context,
            "${context.packageName}.provider",
            file
        )

        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "application/json"
            putExtra(Intent.EXTRA_STREAM, uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }

        context.startActivity(Intent.createChooser(intent, "Экспортировать сад"))
    }
}