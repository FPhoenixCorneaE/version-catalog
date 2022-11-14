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
            from(files("libs.versions.toml"))
        }
    }
}
// 开启 VERSION_CATALOGS
enableFeaturePreview("VERSION_CATALOGS")

rootProject.name = "VersionCatalog"
include(":app")
include(":versionCatalog")


