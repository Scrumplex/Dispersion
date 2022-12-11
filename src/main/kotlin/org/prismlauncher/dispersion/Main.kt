// SPDX-FileCopyrightText: 2022 Sefa Eyeoglu <contact@scrumplex.net>
//
// SPDX-License-Identifier: AGPL-3.0-or-later

package org.prismlauncher.dispersion

import org.prismlauncher.dispersion.fabricmc.FabricModule

suspend fun main(args: Array<String>) {
    val m = FabricModule()
    m.lol()
}
