import net.ltgt.gradle.errorprone.errorprone

group = "com.github.alexandrenavarro"
version = "0.0.1-SNAPSHOT"
description = "nullaway-sample"

plugins {
    `java-library`
    `maven-publish`
    id("net.ltgt.errorprone") version "4.1.0"
}

repositories {
    mavenCentral()
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    api(platform("org.springframework.boot:spring-boot-dependencies:3.4.1"))

    errorprone("com.google.errorprone:error_prone_core:2.36.0")
    errorprone("com.uber.nullaway:nullaway:0.12.3")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.google.guava:guava:33.4.0-jre")
    implementation("io.vavr:vavr:0.10.5")

    compileOnly("org.projectlombok:lombok:1.18.36")
    compileOnly("org.jspecify:jspecify:1.0.0")
    compileOnly("org.jetbrains:annotations:24.1.0")
    compileOnly("cc.jilt:jilt:1.6.3")

    annotationProcessor("org.projectlombok:lombok:1.18.36")
    annotationProcessor("cc.jilt:jilt:1.6.3")
}

tasks.withType<JavaCompile>().configureEach {
    options.errorprone {
        option("NullAway:AnnotatedPackages", "com.github.alexandrenavarro.nullawaysample,org.springframework")
        option(
            "NullAway:ExcludedClasses",
            "com.github.alexandrenavarro.nullawaysample.PersonBuilder,com.github.alexandrenavarro.nullawaysample.RestPersonBuilder,com.github.alexandrenavarro.nullawaysample.PersonEntityBuilder,com.github.alexandrenavarro.nullawaysample.DriverLicenseBuilder,com.github.alexandrenavarro.nullawaysample.PersonEntity"
        )
    }
}
tasks.compileJava {
    options.errorprone.error("NullAway")
    options.errorprone.disable("UnusedVariable")
}



