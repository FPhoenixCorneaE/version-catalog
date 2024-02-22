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

[Migrate your build to version catalogs](https://developer.android.google.cn/build/migrate-to-catalogs?hl=en)

### 更新日志

#### 2024-02-22
build: version-catalog upgrade to 1.0.2

1、version: add "androidGradlePlugin", compileSdk、targetSdk upgrade to 34, lifecycle upgrade to 2.7.0;
2、plugin: add "android-application"、"android-library"、"kotlin-parcelize";
3、library: add "lifecycle-viewmodel-compose"、"lifecycle-runtime-compose"、"lifecycle-compiler"、"lifecycle-runtime-testing";
4、bundle: lifecycle add "lifecycle-viewmodel-compose"、"lifecycle-runtime-compose";

