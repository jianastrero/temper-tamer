package dev.jianastrero.tempertamer.data.downloader

import android.content.Context
import android.util.Log
import java.io.File
import java.net.HttpURLConnection
import java.net.URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object FileDownloader {

    suspend fun download(context: Context, url: String, filename: String): Boolean =
        withContext(Dispatchers.IO) {
            val newFile = File(context.filesDir, filename)

            if (newFile.exists()) {
                return@withContext true
            } else {
                newFile.createNewFile()
            }

            val fullUrl = if (url.startsWith("http")) url else "https:$url"
            var connection: HttpURLConnection? = null
            var result = false

            try {
                connection = URL(fullUrl).openConnection() as HttpURLConnection
                connection.connect()

                val statusCode = connection.responseCode
                if (statusCode != HttpURLConnection.HTTP_OK) {
                    // handle error here
                    Log.d("JIANDDEBUG", "Connection error: $statusCode")
                    connection.disconnect()
                    return@withContext false
                }

                connection.inputStream.use { inputStream ->
                    newFile.outputStream().use { outputStream ->
                        outputStream.write(inputStream.readBytes())
                    }
                }
                result = true
            } catch (e: Exception) {
                Log.d("JIANDDEBUG", "e.message: ${e.message}")
                e.printStackTrace()
            } finally {
                connection?.disconnect()
            }

            result
        }

}
