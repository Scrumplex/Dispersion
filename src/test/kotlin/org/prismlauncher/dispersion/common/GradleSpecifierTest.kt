package org.prismlauncher.dispersion.common

import kotlin.test.Test
import kotlin.test.assertEquals

class GradleSpecifierTest {

    @Test
    fun testToString() {
        assertEquals(
            "org.prismlauncher:dispersion:0.1.0",
            GradleSpecifier("org.prismlauncher", "dispersion", "0.1.0").toString()
        )
        assertEquals(
            "org.prismlauncher:dispersion:0.1.0:natives-linux",
            GradleSpecifier("org.prismlauncher", "dispersion", "0.1.0", "natives-linux").toString()
        )
        assertEquals(
            "org.prismlauncher:dispersion:0.1.0@zip",
            GradleSpecifier("org.prismlauncher", "dispersion", "0.1.0", extension = "zip").toString()
        )
    }

    @Test
    fun testFilename() {
        assertEquals(
            "dispersion-0.1.0.jar",
            GradleSpecifier("org.prismlauncher", "dispersion", "0.1.0").filename,
        )
        assertEquals(
            "dispersion-0.1.0-natives-linux.jar",
            GradleSpecifier("org.prismlauncher", "dispersion", "0.1.0", "natives-linux").filename
        )
        assertEquals(
            "dispersion-0.1.0.zip",
            GradleSpecifier("org.prismlauncher", "dispersion", "0.1.0", extension = "zip").filename
        )
    }

    @Test
    fun testBase() {
        assertEquals(
            "org/prismlauncher/dispersion/0.1.0/",
            GradleSpecifier("org.prismlauncher", "dispersion", "0.1.0").base
        )
        assertEquals(
            "org/prismlauncher/dispersion/0.1.0/",
            GradleSpecifier("org.prismlauncher", "dispersion", "0.1.0", "natives-linux").base,
            "classifier should not affect base"
        )
        assertEquals(
            "org/prismlauncher/dispersion/0.1.0/",
            GradleSpecifier("org.prismlauncher", "dispersion", "0.1.0", extension = "zip").base,
            "extension should not affect base"
        )
    }

    @Test
    fun testPath() {
        assertEquals(
            "org/prismlauncher/dispersion/0.1.0/dispersion-0.1.0.jar",
            GradleSpecifier("org.prismlauncher", "dispersion", "0.1.0").path
        )
        assertEquals(
            "org/prismlauncher/dispersion/0.1.0/dispersion-0.1.0-natives-linux.jar",
            GradleSpecifier("org.prismlauncher", "dispersion", "0.1.0", "natives-linux").path
        )
        assertEquals(
            "org/prismlauncher/dispersion/0.1.0/dispersion-0.1.0.zip",
            GradleSpecifier("org.prismlauncher", "dispersion", "0.1.0", extension = "zip").path
        )
    }

    @Test
    fun testParseReversible() {
        assertEquals(
            "org.prismlauncher:dispersion:0.1.0",
            GradleSpecifier.parse("org.prismlauncher:dispersion:0.1.0").toString()
        )
        assertEquals(
            "org.prismlauncher:dispersion:0.1.0:natives-linux",
            GradleSpecifier.parse("org.prismlauncher:dispersion:0.1.0:natives-linux").toString()
        )
        assertEquals(
            "org.prismlauncher:dispersion:0.1.0@zip",
            GradleSpecifier.parse("org.prismlauncher:dispersion:0.1.0@zip").toString()
        )
        assertEquals(
            "org.prismlauncher:dispersion:0.1.0:natives-linux@zip",
            GradleSpecifier.parse("org.prismlauncher:dispersion:0.1.0:natives-linux@zip").toString()
        )
    }
}
