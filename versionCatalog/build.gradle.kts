plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    `version-catalog`
    `maven-publish`
    signing
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
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

catalog {
    /**
     * version - 用于声明可以被依赖项引用的版本
     * plugin  - 用于声明插件
     * library - 用于声明坐标的别名
     * bundle  - 用于声明依赖包
     */
    versionCatalog {
        version("compileSdk", "33")
        version("minSdk", "21")
        version("targetSdk", "33")
        version("kotlin", "1.7.20")

        // plugin
        plugin("kotlin-android", "org.jetbrains.kotlin.android").versionRef("kotlin")
        plugin("kotlin-kapt", "org.jetbrains.kotlin.kapt").versionRef("kotlin")

        // androidx
        library("androidx-activity-ktx", "androidx.activity", "activity-ktx").version("1.6.1")
        library("androidx-annotation", "androidx.annotation", "annotation").version("1.5.0")
        library("androidx-appcompat", "androidx.appcompat", "appcompat").version("1.5.1")
        library("androidx-cardview", "androidx.cardview", "cardview").version("1.0.0")
        library("androidx-constraintlayout", "androidx.constraintlayout", "constraintlayout").version("2.1.4")
        library("androidx-core-ktx", "androidx.core", "core-ktx").version("1.9.0")
        version("androidx-datastore", "1.0.0")
        library("androidx-datastore", "androidx.datastore", "datastore").versionRef("androidx-datastore")
        library("androidx-datastore-preferences", "androidx.datastore", "datastore-preferences")
            .versionRef("androidx-datastore")
        bundle("androidx-datastore", listOf("androidx-datastore", "androidx-datastore-preferences"))
        library("androidx-fragment-ktx", "androidx.fragment", "fragment-ktx").version("1.5.4")
        library("androidx-multidex", "androidx.multidex", "multidex").version("2.0.1")
        library("androidx-paging", "androidx.paging", "paging-runtime").version("3.1.1")
        library("androidx-recyclerview", "androidx.recyclerview", "recyclerview").version("1.2.1")
        library("androidx-recyclerview-selection", "androidx.recyclerview", "recyclerview-selection").version("1.1.0")
        library("androidx-startup-runtime", "androidx.startup", "startup-runtime").version("1.1.1")
        library("androidx-swiperefreshlayout", "androidx.swiperefreshlayout", "swiperefreshlayout").version("1.1.0")

        // lifecycle
        version("lifecycle", "2.5.1")
        library("lifecycle-viewmodel-ktx", "androidx.lifecycle", "lifecycle-viewmodel-ktx").versionRef("lifecycle")
        library("lifecycle-livedata-ktx", "androidx.lifecycle", "lifecycle-livedata-ktx").versionRef("lifecycle")
        library("lifecycle-runtime-ktx", "androidx.lifecycle", "lifecycle-runtime-ktx").versionRef("lifecycle")
        library("lifecycle-viewmodel-savedstate", "androidx.lifecycle", "lifecycle-viewmodel-savedstate")
            .versionRef("lifecycle")
        library("lifecycle-common-java8", "androidx.lifecycle", "lifecycle-common-java8").versionRef("lifecycle")
        library("lifecycle-service", "androidx.lifecycle", "lifecycle-service").versionRef("lifecycle")
        library("lifecycle-process", "androidx.lifecycle", "lifecycle-process").versionRef("lifecycle")
        library("lifecycle-reactivestreams-ktx", "androidx.lifecycle", "lifecycle-reactivestreams-ktx")
            .versionRef("lifecycle")
        bundle("lifecycle", listOf(
            "lifecycle-viewModel-ktx",
            "lifecycle-livedata-ktx",
            "lifecycle-runtime-ktx",
            "lifecycle-viewmodel-savedstate",
            "lifecycle-common-java8",
            "lifecycle-service",
            "lifecycle-process",
            "lifecycle-reactivestreams-ktx",
        ))

        // navigation
        version("navigation", "2.5.3")
        plugin("navigation-safeargs", "androidx.navigation.safeargs.kotlin").versionRef("navigation")
        library("navigation-fragment-ktx", "androidx.navigation", "navigation-fragment-ktx")
            .versionRef("navigation")
        library("navigation-ui-ktx", "androidx.navigation", "navigation-ui-ktx")
            .versionRef("navigation")
        bundle("navigation", listOf("navigation-fragment-ktx", "navigation-ui-ktx"))

        // coroutines
        version("coroutines", "1.6.4")
        library("kotlinx-coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core")
            .versionRef("coroutines")
        library("kotlinx-coroutines-android", "org.jetbrains.kotlinx", "kotlinx-coroutines-android")
            .versionRef("coroutines")
        bundle("coroutines", listOf("kotlinx-coroutines-core", "kotlinx-coroutines-android"))

        // room
        version("room", "2.4.3")
        library("room-runtime", "androidx.room", "room-runtime").versionRef("room")
        library("room-ktx", "androidx.room", "room-ktx").versionRef("room")
        library("room-compiler", "androidx.room", "room-compiler").versionRef("room")
        bundle("room", listOf("room-runtime", "room-ktx"))

        // coil
        version("coil", "2.2.2")
        library("coil", "io.coil-kt", "coil").versionRef("coil")
        library("coil-gif", "io.coil-kt", "coil-gif").versionRef("coil")
        bundle("coil", listOf("coil", "coil-gif"))

        // test
        library("test-core-ktx","androidx.test:core-ktx:1.4.0")
        library("test-espresso-core","androidx.test.espresso:espresso-core:3.4.0")
        library("test-junit-ktx","androidx.test.ext:junit-ktx:1.1.3")
    }
}

afterEvaluate {
    publishing {
        publications {
            // Creates a Maven publication called "release".
            create<MavenPublication>("release") {
                from(components["versionCatalog"])
                groupId = "com.github.FPhoenixCorneaE"
                artifactId = "version-catalog"
                version = "1.0.1"
            }
        }
    }
}

signing {
    sign(publishing.publications)
}