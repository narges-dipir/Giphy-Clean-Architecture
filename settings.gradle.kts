pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven { setUrl("https://jitpack.io") }
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
}

rootProject.name = "Picnic Test"
include(":app")
include(":data")
include(":domain")
include(":presentation")
