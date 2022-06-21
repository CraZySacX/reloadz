plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Versions.compileSdkVersion

    defaultConfig {
        applicationId = "com.ozias.reloadz"
        minSdk = Versions.minSdkVersion
        targetSdk = Versions.targetSdkVersion
        versionCode = Versions.versionCode
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    kapt {
        correctErrorTypes = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AndroidX.Compose.compose_version
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(AndroidX.Activity.activity_compose)
    implementation(AndroidX.Compose.Foundation.foundation)
    implementation(AndroidX.Compose.Material.material)
    implementation(AndroidX.Compose.Material.material_icons_extended)
    implementation(AndroidX.Compose.Ui.ui)
    implementation(AndroidX.Core.core_ktx)
    implementation(AndroidX.Lifecycle.lifecycle_runtime_ktx)
    implementation(AndroidX.Lifecycle.lifecycle_viewmodel_compose)
    implementation(Google.Accompanist.accompanist_systemuicontroller)
    implementation(Google.Dagger.hilt_android)
    implementation("io.arrow-kt:arrow-core:1.0.1")

    debugImplementation(AndroidX.Compose.Ui.ui_tooling)
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.2.0-alpha05")

    kapt(Google.Dagger.hilt_android_compiler)

    testImplementation(JUnit.junit4)
    androidTestImplementation(AndroidX.Test.ext)
    androidTestImplementation(AndroidX.Test.Espresso.espresso_core)
    androidTestImplementation(AndroidX.Compose.Ui.ui_test_junit4)
}
