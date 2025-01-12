pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ModuleApp24"

include(":app")

/* Core Module */
include(":core")
include(":core:db")
include(":core:designsystem")
include(":core:network")
include(":core:viewmodel")
include(":core:utils")
//include(":core:navigation")

/* Feature Module: Home */
include(":feature:home:api")
include(":feature:home:impl")

include(":feature:profile:impl")
include(":feature:profile:api")
