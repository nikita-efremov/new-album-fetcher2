import java.net.URL
plugins {
    id("org.openapi.generator") version "7.7.0"
    id("org.jetbrains.kotlin.jvm") version "1.9.22"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.22"
    application
}

val spotifyApiGenerate by tasks.registering(org.openapitools.generator.gradle.plugin.tasks.GenerateTask::class) {
    group = "generation"
    description = "Generate Spotify client from spotify-api-spec.yaml"
    val generatedOutputDir = file("build/generated/spotify")

    inputs.file(file("spotify-api-spec.yaml"))
    outputs.dir(generatedOutputDir)
    inputSpec.set(file("spotify-api-spec.yaml").absolutePath)

    doFirst {
        generatedOutputDir.mkdirs()
    }


    generatorName.set("kotlin")
    library.set("multiplatform")
    outputDir.set(generatedOutputDir.absolutePath)
    validateSpec.set(false)
    globalProperties.set(mapOf("models" to "true", "apis" to "true", "supportingFiles" to "true"))
}

sourceSets {
    getByName("main") {
        kotlin {
            srcDir("build/generated/spotify/src/commonMain/kotlin")
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile>().configureEach {
    if (name == "compileKotlin") {
        dependsOn(spotifyApiGenerate)
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}