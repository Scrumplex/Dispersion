package org.prismlauncher.dispersion

import mu.KLogger
import mu.KotlinLogging
import org.prismlauncher.dispersion.fabricmc.FabricModule

suspend fun main(args: Array<String>) {
    val m = FabricModule()
    m.lol()
}
