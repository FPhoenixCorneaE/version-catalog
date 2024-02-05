# VersionCatalog

AGP 7.0.0以上依赖库统一版本号管理。

[![Maven Central](https://img.shields.io/maven-central/v/io.github.FPhoenixCorneaE/version-catalog.svg?label=Maven%20Central&color=ff69b4)](https://search.maven.org/artifact/io.github.FPhoenixCorneaE/version-catalog)


### Usage
```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("deps") {
            from("io.github.FPhoenixCorneaE:version-catalog:$latest")
        }
    }
}
```

```kotlin
dependencies {
    implementation(deps.coil.gif)
}
```
