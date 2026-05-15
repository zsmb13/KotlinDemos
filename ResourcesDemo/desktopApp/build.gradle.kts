plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    dependencies {
        implementation(projects.shared)
        implementation(compose.desktop.currentOs)
    }
}

compose.desktop {
    application {
        mainClass = "com.jetbrains.demo.MainKt"
    }
}
