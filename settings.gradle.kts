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
        maven("https://jitpack.io")
    }
    versionCatalogs {
        create("deps") {
//            from("com.github.FPhoenixCorneaE:VersionCatalog:1.1.5")
//            from(files("$rootDir/versionCatalog/build/version-catalog/libs.versions.toml"))
        }
    }
}

rootProject.name = "VersionCatalog"
include(":app")
include(":versionCatalog")


