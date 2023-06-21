import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    `version-catalog`
    `maven-publish`
}

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
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
            "lifecycle-viewmodel-ktx",
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
            groupId = "com.github.FPhoenixCorneaE"
            artifactId = "version-catalog"
            version = "1.1.0"
            from(components["versionCatalog"])
            pom {
                name.set("version-catalog")
                description.set("AGP 7.0.0以上依赖库统一版本号管理。")
                url.set("https://github.com/FPhoenixCorneaE/VersionCatalog")
                inceptionYear.set("2022")
                scm {
                    url.set("https://github.com/FPhoenixCorneaE/VersionCatalog")
                    connection.set("scm:git:https://github.com/FPhoenixCorneaE/VersionCatalog.git")
                    developerConnection.set("scm:git:https://github.com/FPhoenixCorneaE/VersionCatalog.git")
                }
                licenses {
                    license {
                        name.set("The Apache Software License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("repo")
                        comments.set("A business-friendly OSS license")
                    }
                }
                developers {
                    developer {
                        id.set("FPhoenixCorneaE")
                        name.set("FPhoenixCorneaE")
                        email.set("3453207571@qq.com")
                        url.set("https://github.com/FPhoenixCorneaE/VersionCatalog")
                    }
                }
                issueManagement {
                    system.set("Github")
                    url.set("https://github.com/FPhoenixCorneaE/VersionCatalog")
                }
                withXml {
                    // Creating additional node for dependencies
                    val dependenciesNode = asNode().appendNode("dependencies")
                    project.configurations.all {
                        val name = this.name
                        // Defining configuration names from which dependencies will be taken (implementation and api)
                        if (name != "implementation" && name != "compile" && name != "api") {
                            return@all
                        }
                        println(this)
                        dependencies.forEach {
                            println(it)
                            if (it.name == "unspecified") {
                                // 忽略无法识别的
                                return@forEach
                            }
                            val dependencyNode = dependenciesNode.appendNode("dependency")
                            dependencyNode.appendNode("groupId", it.group)
                            dependencyNode.appendNode("artifactId", it.name)
                            dependencyNode.appendNode("version", it.version)
                            if (name == "api" || name == "compile") {
                                dependencyNode.appendNode("scope", "compile")
                            } else { // implementation
                                dependencyNode.appendNode("scope", "runtime")
                            }
                            // if there are any exclusions in dependency
                            if (excludeRules.isNotEmpty()) {
                                val exclusionsNode = dependencyNode.appendNode("exclusions")
                                excludeRules.forEach {
                                    val exclusionNode = exclusionsNode.appendNode("exclusion")
                                    exclusionNode.appendNode("groupId", it.group)
                                    exclusionNode.appendNode("artifactId", it.module)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    repositories {
        maven {
            isAllowInsecureProtocol = true
            url = uri("https://jitpack.io/com/github/FPhoenixCorneaE/VersionCatalog")
            credentials {
                username = file("../local.properties").takeIf { it.canRead() }?.run {
                    Properties().run {
                        load(inputStream())
                        this["maven.username"].toString()
                    }
                }
                password = file("../local.properties").takeIf { it.canRead() }?.run {
                    Properties().run {
                        load(inputStream())
                        this["maven.password"].toString()
                    }
                }
            }
        }
    }
}
