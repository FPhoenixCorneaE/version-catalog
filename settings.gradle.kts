pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("deps") {
            from("io.github.FPhoenixCorneaE:version-catalog:1.0.1")
//            from(files("$rootDir/versionCatalog/build/version-catalog/libs.versions.toml"))
        }
    }
}

rootProject.name = "version-catalog"
include(":app")
include(":libs")


