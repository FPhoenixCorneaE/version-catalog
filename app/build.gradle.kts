plugins {
    alias(deps.plugins.android.application)
    alias(deps.plugins.kotlin.android)
    alias(deps.plugins.navigation.safeargs)
    id(deps.plugins.kotlin.kapt.get().pluginId)
    id(deps.plugins.kotlin.parcelize.get().pluginId)
}

android {
    compileSdk = deps.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.fphoenixcorneae.version.catalog"
        minSdk = deps.versions.minSdk.get().toInt()
        targetSdk = deps.versions.targetSdk.get().toInt()
        versionCode = 100
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    namespace = "com.fphoenixcorneae.version.catalog"
}

dependencies {

    implementation(deps.bundles.lifecycle)
    kapt(deps.lifecycle.compiler)
    implementation(deps.coil.gif)

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}

