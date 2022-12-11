package org.prismlauncher.dispersion.fabricmc

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.cache.*
import io.ktor.client.plugins.cache.storage.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import mu.KotlinLogging
import java.nio.file.Files
import java.nio.file.Paths


private val logger = KotlinLogging.logger {}
class FabricModule {

    private val client = HttpClient(CIO) {
        install(HttpCache) {
            val cacheFile = Files.createDirectories(Paths.get("build/cache")).toFile()
            publicStorage(FileStorage(cacheFile))
        }
        install(Logging)
    }

    suspend fun lol() {
        println(client.get("https://meta.fabricmc.net/v2/versions/loader").body<String>())
    }


}
