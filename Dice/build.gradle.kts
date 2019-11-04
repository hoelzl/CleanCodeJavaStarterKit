plugins {
    java
    application
}

repositories {
    jcenter()
}

val hamcrestVersion = "2.2"
val jUnitVersion = "5.5.2"
val appClass = "de.mhoelzl.dice.app.App"

dependencies {
    testCompile("org.junit.jupiter:junit-jupiter-api:$jUnitVersion")
    testCompile("org.junit.jupiter:junit-jupiter-params:$jUnitVersion")
    testImplementation("org.hamcrest:hamcrest-library:$hamcrestVersion")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:$jUnitVersion")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = appClass
    }
}

application {
    mainClassName = appClass
}
