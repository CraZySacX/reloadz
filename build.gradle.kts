plugins {
    id("com.android.application") apply false
    id("com.android.library") apply false
    id("org.jetbrains.kotlin.android") apply false
}

buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.41")
    }
}

task<Delete>("clean") {
    delete(
        fileTree(rootProject.buildDir) {
            include("*.apk")
        }
    )
}
