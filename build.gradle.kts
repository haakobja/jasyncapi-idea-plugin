plugins {
    id("org.jetbrains.intellij") version "0.6.5"
    java
    kotlin("jvm") version "1.4.21"
}

group "com.asyncapi.plugin.idea"
version = "1.0.0-EAP-1+idea2020"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testCompile("junit", "junit", "4.12")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version = "2020.2.3"
    setPlugins("yaml")
}
tasks.getByName<org.jetbrains.intellij.tasks.PatchPluginXmlTask>("patchPluginXml") {
    sinceBuild("201.*")
    untilBuild("203.*")
    changeNotes("""
        <ul>
            <li>IDEA's version range was set to 201.* - 203.*</li>
        </ul>
    """.trimIndent())
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}