package org.prismlauncher.dispersion.common

data class GradleSpecifier(
    val groupId: String,
    val artifactId: String,
    val version: String,
    val classifier: String? = null,
    val extension: String = "jar"
) {
    companion object {
        fun parse(s: String): GradleSpecifier {
            val extSplit = s.split('@')
            val parts = extSplit[0].split(':')
            val groupId = parts[0]
            val artifactId = parts[1]
            val version = parts[2]
            val classifier = if (parts.size == 4) parts[3] else null
            val extension = if (extSplit.size == 2) extSplit[1] else "jar"

            return GradleSpecifier(groupId, artifactId, version, classifier, extension)
        }
    }

    val filename: String
        get() {
            if (classifier != null) return "${artifactId}-${version}-${classifier}.${extension}"
            return "${artifactId}-${version}.${extension}"
        }
    val base: String
        get() {
            return "${groupId.replace('.', '/')}/${artifactId}/${version}/"
        }
    val path: String
        get() {
            return "${base}${filename}"
        }
    val isLWJGL: Boolean
        get() {
            return arrayOf("org.lwjgl", "org.lwjgl.lwjgl", "net.java.jinput", "net.java.jutils").contains(groupId)
        }
    val isLog4j: Boolean
        get() {
            return groupId == "org.apache.logging.log4j"
        }

    override fun toString(): String {
        val ext = if (extension != "jar") "@${extension}" else ""
        if (classifier != null) return "${groupId}:${artifactId}:${version}:${classifier}${ext}"
        return "${groupId}:${artifactId}:${version}${ext}"
    }
}
