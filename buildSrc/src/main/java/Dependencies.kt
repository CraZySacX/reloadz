object Versions {
    const val targetSdkVersion = 30
    const val compileSdkVersion = 32
    const val minSdkVersion = 24
    const val versionCode = 1
}

object AndroidX {
    internal object Versions {
        const val activity_compose = "1.4.0"
        const val compose = "1.2.0-alpha05"
        const val core = "1.7.0"
        const val espresso = "3.4.0"
        const val lifecycle = "2.4.1"
        const val test_ext = "1.1.3"
    }

    object Activity {
        const val activity_compose =
            "androidx.activity:activity-compose:${Versions.activity_compose}"
    }

    object Core {
        const val core_ktx = "androidx.core:core-ktx:${Versions.core}"
    }

    object Compose {
        const val compose_version = Versions.compose
        object Foundation {
            const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
        }

        object Material {
            const val material = "androidx.compose.material:material:${Versions.compose}"
            const val material_icons_extended =
                "androidx.compose.material:material-icons-extended:${Versions.compose}"
        }

        object Ui {
            const val ui = "androidx.compose.ui:ui:${Versions.compose}"
            const val ui_tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
            const val ui_test_junit4 = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
        }
    }

    object Lifecycle {
        const val lifecycle_runtime_ktx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
        const val lifecycle_viewmodel_compose =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"
    }

    object Test {
        const val ext = "androidx.test.ext:junit:${Versions.test_ext}"

        object Espresso {
            const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        }
    }
}

object Google {
    internal object Versions {
        const val accompanist_systemuicontroller = "0.24.4-alpha"
        const val dagger = "2.41"
    }

    object Accompanist {
        const val accompanist_systemuicontroller =
            "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist_systemuicontroller}"
    }

    object Dagger {
        const val hilt_android = "com.google.dagger:hilt-android:${Versions.dagger}"
        const val hilt_android_compiler =
            "com.google.dagger:hilt-android-compiler:${Versions.dagger}"
    }
}

object JUnit {
    internal object Versions {
        const val junit4 = "4.13.2"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
}
