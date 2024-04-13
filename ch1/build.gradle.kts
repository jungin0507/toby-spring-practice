plugins {
    id("java")
}

group = "com.bayne"

repositories {
    mavenCentral()
}

dependencies {
    implementation(group = "org.springframework", name = "spring-core", version = "6.1.6")
    implementation(group = "org.springframework", name = "spring-context", version = "6.1.6")
    implementation(group = "org.springframework", name = "spring-jdbc", version = "6.1.6")
    implementation(group = "com.mysql", name = "mysql-connector-j", version = "8.3.0")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
