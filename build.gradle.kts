plugins {
    id("com.android.application") apply false
    id("com.android.library") apply false
    id("org.jetbrains.kotlin.android") apply false
}

task<Delete>("clean") {
    delete(
        fileTree(rootProject.buildDir) {
            include("*.apk")
        }
    )
}