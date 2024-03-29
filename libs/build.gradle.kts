plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    `version-catalog`
    `maven-publish`
    signing
}

group = "io.github.FPhoenixCorneaE"
version = "1.0.2"

android {
    compileSdk = 34

    defaultConfig {
        minSdk = 21

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    namespace = "com.fphoenixcorneae.version.catalog"
}

// 版本目录配置
catalog {
    /**
     * version - 用于声明可以被依赖项引用的版本
     * plugin  - 用于声明插件
     * library - 用于声明坐标的别名
     * bundle  - 用于声明依赖包
     */
    versionCatalog {
        version("androidGradlePlugin", "8.2.2")
        version("compileSdk", "34")
        version("minSdk", "21")
        version("targetSdk", "34")
        version("kotlin", "1.7.20")

        // plugin
        plugin("android-application", "com.android.application").versionRef("androidGradlePlugin")
        plugin("android-library", "com.android.library").versionRef("androidGradlePlugin")
        plugin("kotlin-android", "org.jetbrains.kotlin.android").versionRef("kotlin")
        plugin("kotlin-kapt", "org.jetbrains.kotlin.kapt").versionRef("kotlin")
        plugin("kotlin-parcelize", "org.jetbrains.kotlin.plugin.parcelize").versionRef("kotlin")

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
        version("lifecycle", "2.7.0")
        library("lifecycle-viewmodel-ktx", "androidx.lifecycle", "lifecycle-viewmodel-ktx").versionRef("lifecycle")
        library(
            "lifecycle-viewmodel-compose",
            "androidx.lifecycle",
            "lifecycle-viewmodel-compose"
        ).versionRef("lifecycle")
        library("lifecycle-livedata-ktx", "androidx.lifecycle", "lifecycle-livedata-ktx").versionRef("lifecycle")
        library("lifecycle-runtime-ktx", "androidx.lifecycle", "lifecycle-runtime-ktx").versionRef("lifecycle")
        library("lifecycle-runtime-compose", "androidx.lifecycle", "lifecycle-runtime-compose").versionRef("lifecycle")
        library("lifecycle-viewmodel-savedstate", "androidx.lifecycle", "lifecycle-viewmodel-savedstate")
            .versionRef("lifecycle")
        library("lifecycle-common-java8", "androidx.lifecycle", "lifecycle-common-java8").versionRef("lifecycle")
        library("lifecycle-service", "androidx.lifecycle", "lifecycle-service").versionRef("lifecycle")
        library("lifecycle-process", "androidx.lifecycle", "lifecycle-process").versionRef("lifecycle")
        library("lifecycle-reactivestreams-ktx", "androidx.lifecycle", "lifecycle-reactivestreams-ktx")
            .versionRef("lifecycle")
        library("lifecycle-compiler", "androidx.lifecycle", "lifecycle-compiler").versionRef("lifecycle")
        library("lifecycle-runtime-testing", "androidx.lifecycle", "lifecycle-runtime-testing").versionRef("lifecycle")
        bundle(
            "lifecycle", listOf(
                "lifecycle-viewmodel-ktx",
                "lifecycle-viewmodel-compose",
                "lifecycle-livedata-ktx",
                "lifecycle-runtime-ktx",
                "lifecycle-runtime-compose",
                "lifecycle-viewmodel-savedstate",
                "lifecycle-common-java8",
                "lifecycle-service",
                "lifecycle-process",
                "lifecycle-reactivestreams-ktx",
            )
        )

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
        library("test-core-ktx", "androidx.test:core-ktx:1.4.0")
        library("test-espresso-core", "androidx.test.espresso:espresso-core:3.4.0")
        library("test-junit-ktx", "androidx.test.ext:junit-ktx:1.1.3")
    }
}

// 配置 publishing
publishing {
    publications {
        // Creates a Maven publication called "maven".
        create<MavenPublication>("maven") {
            artifactId = "version-catalog"
            from(components["versionCatalog"])

            pom {
                name.set("libs-versions")
                description.set("AGP 7.0.0以上依赖库统一版本号管理。")
                url.set("https://github.com/FPhoenixCorneaE/version-catalog")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://github.com/FPhoenixCorneaE/version-catalog/blob/main/LICENSE")
                    }
                }
                developers {
                    developer {
                        id.set("1646")
                        name.set("FPhoenixCorneaE")
                        email.set("834532786@qq.com")
                    }
                }
                scm {
                    url.set("https://github.com/FPhoenixCorneaE/version-catalog")
                    connection.set("https://github.com/FPhoenixCorneaE/version-catalog.git")
                    developerConnection.set("https://github.com/FPhoenixCorneaE/version-catalog.git")
                }
            }
        }
    }
    repositories {
        maven {
            name = "OSSRH"

            val releasesRepoUrl = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
            val snapshotsRepoUrl = "https://s01.oss.sonatype.org/content/repositories/snapshots/"

            setUrl(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)
            credentials {
                username = findProperty("MAVEN_USERNAME") as String?
                password = findProperty("MAVEN_PASSWORD") as String?
            }
        }
    }
    signing {
        // gpg --list-keys --keyid-format 0xSHORT
        val defaultKeyId = findProperty("SIGNING_KEY_ID") as String?
        // gpg --armor --export-secret-key
        val defaultSecretKey = findProperty("SIGNING_KEY") as String?
        val defaultPassword = findProperty("SIGNING_PASSWORD") as String?
        useInMemoryPgpKeys(defaultKeyId, defaultSecretKey, defaultPassword)
        useGpgCmd()
        sign(publishing.publications)
    }
}
