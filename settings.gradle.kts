pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
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
//            from("com.github.FPhoenixCorneaE:VersionCatalog:1.0.8")
        }
    }
}

rootProject.name = "VersionCatalog"
include(":app")
include(":versionCatalog")


